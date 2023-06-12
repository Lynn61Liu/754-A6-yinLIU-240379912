package nz.ac.auckland.se754.web.controller;

import nz.ac.auckland.se754.web.model.factory.Course;
import nz.ac.auckland.se754.web.service.CourseOverview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Controller
@SessionAttributes("name")
public class CourseOverviewController {

    @Autowired
    CourseOverview service;

    ModelAndView map = new ModelAndView("/course-overview");

    @RequestMapping(value="/course/{id}/overview", method = RequestMethod.GET)
    public ModelAndView showCourse(ModelMap model, @PathVariable String id){
        Course course = service.getCourse(Long.parseLong(id));

        map.addObject("courseName", course.getName());
        map.addObject("courseCategory", course.getCategory());
        map.addObject("courseTopic", course.getTopic());
        map.addObject("courseDescription", course.getDescription());
        map.addObject("courseFormat", course.getFormat());
        List<String> practiceNames = new ArrayList<>();
        Map<String, Boolean> learnNames = service.getLearnNamesAndProgress(course);
        for (Map<String, String> practice : service.getPracticeNames(course)) {
            String name = practice.get("name");
            String date = practice.get("date");
            String modifiedName = name + " - " + date;
            practiceNames.add(modifiedName);
        }
        map.addObject("learnMap", learnNames);
        map.addObject("practiceList", practiceNames);

        int courseTime = service.calculateCourseTimeEstimate(course);
        int courseDifficulty = service.calculateCourseDifficulty(course);
        map.addObject("courseTime", courseTime);
        map.addObject("courseDifficulty", courseDifficulty);

        List<String> courseSyllabus = service.getCourseSyllabus(course);
        map.addObject("courseSyllabus", courseSyllabus);

        String username = (String) model.get("name");
        if (username == null) {
            username = "user1";
        }
        boolean isEnrolled = service.getEnrolmentStatus(course, username);
        map.addObject("isEnrolled", isEnrolled);

        return map;
    }

    @RequestMapping(value="/course/{id}/overview", method = RequestMethod.POST)
    public ModelAndView handleAddEnrolment(ModelMap model, @PathVariable String id){
        Course course = service.getCourse(Long.parseLong(id));
        String username = (String) model.get("name");
        if (username == null) {
            username = "user1";
        }
        boolean enrolmentSuccess = service.addEnrolment(course, username);

        map.addObject("isEnrolled", enrolmentSuccess);

        return map;
    }
}
