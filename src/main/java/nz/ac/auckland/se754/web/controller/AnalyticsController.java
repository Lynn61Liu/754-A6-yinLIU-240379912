package nz.ac.auckland.se754.web.controller;

import nz.ac.auckland.se754.web.model.factory.Course;
import nz.ac.auckland.se754.web.model.factory.Learn;
import nz.ac.auckland.se754.web.model.factory.Practice;
import nz.ac.auckland.se754.web.service.Analytics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AnalyticsController {

    @Autowired
    Analytics service;

    ModelAndView map = new ModelAndView("/analytics");

    @RequestMapping(value="/analytics", method = RequestMethod.GET)
    public ModelAndView showAnalytics(){
        Course course = service.getCourse();
        ArrayList<Learn> learningModules = course.getLearningModules();
        ArrayList<Practice> practiceModules = course.getPracticeModules();

        List<String> learningNames = new ArrayList<>();
        List<String> learnProgress = new ArrayList<>();
        List<String> practiceNames = new ArrayList<>();
        List<String> practiceProgress = new ArrayList<>();
        float completed = 0;
        for (Learn learn: learningModules){
            learningNames.add(learn.getName());
            if(learn.isCompleted()){
                completed = completed + 1;
            }
                learnProgress.add(String.valueOf(learn.isCompleted()));
        }

        for(Practice practice: practiceModules){
            practiceNames.add(practice.getName());
            if(practice.isCompleted()){
                completed = completed + 1;
            }
            practiceProgress.add(String.valueOf(practice.isCompleted()));
        }
        float numberOfCourses = learningNames.size()+practiceNames.size();

        float percentage = completed /numberOfCourses;

        map.addObject("courseName",course.getName());
        map.addObject("progress",percentage);
        map.addObject("learningModules",learningNames);
        map.addObject("learningModulesProgress",learnProgress);
        map.addObject("practiceModules",practiceNames);
        map.addObject("practiceModulesProgress",practiceProgress);
        return map;
    }
}
