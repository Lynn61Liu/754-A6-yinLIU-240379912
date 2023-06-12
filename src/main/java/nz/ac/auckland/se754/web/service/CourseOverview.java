package nz.ac.auckland.se754.web.service;

import nz.ac.auckland.se754.web.model.factory.*;
import org.mockito.Mockito;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;


@Service
public class CourseOverview {
    private Factory mockDB;

    public CourseOverview() {
        mockDB = Mockito.mock(Factory.class);
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(2023, Calendar.JULY, 6);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(2023, Calendar.JULY, 17);
        Calendar calendar3 = Calendar.getInstance();
        calendar3.set(2023, Calendar.JULY, 8);

        Course mockCourse = Mockito.mock(Course.class);
        Mockito.when(mockCourse.getName()).thenReturn("Intro to Java");
        Mockito.when(mockCourse.getCategory()).thenReturn("Java");
        Mockito.when(mockCourse.getDescription()).thenReturn("This course explains the basic and fundamentals of Java, an object oriented programming " +
                "language. This includes the history of Java, and how to get started on reading some beginner examples.");
        Mockito.when(mockCourse.getFormat()).thenReturn("Text");
        Mockito.when(mockCourse.getTopic()).thenReturn("Java Basics");

        ArrayList<Learn> expectedLearningModuleNames = new ArrayList<Learn>();
        Learn learnOne = Mockito.mock(Learn.class);
        Mockito.when(learnOne.getName()).thenReturn("History of Java");
        Mockito.when(learnOne.isCompleted()).thenReturn(true);
        Learn learnTwo = Mockito.mock(Learn.class);
        Mockito.when(learnTwo.getName()).thenReturn("Java Basic Syntax");
        Mockito.when(learnTwo.isCompleted()).thenReturn(true);
        Learn learnThree = Mockito.mock(Learn.class);
        Mockito.when(learnThree.getName()).thenReturn("Java Object Theory");
        Mockito.when(learnThree.isCompleted()).thenReturn(true);
        expectedLearningModuleNames.add(learnOne);
        expectedLearningModuleNames.add(learnTwo);
        expectedLearningModuleNames.add(learnThree);

        ArrayList<Practice> expectedPracticeModuleNames = new ArrayList<Practice>();
        Practice practiceOne = Mockito.mock(Practice.class);
        Mockito.when(practiceOne.getName()).thenReturn("Java Facts");
        Mockito.when(practiceOne.getStartDate()).thenReturn(calendar1.getTime());
        Practice practiceTwo = Mockito.mock(Practice.class);
        Mockito.when(practiceTwo.getName()).thenReturn("Java Syntax Quiz");
        Mockito.when(practiceTwo.getStartDate()).thenReturn(calendar2.getTime());
        Practice practiceThree = Mockito.mock(Practice.class);
        Mockito.when(practiceThree.getName()).thenReturn("Java Object and Class Practice");
        Mockito.when(practiceThree.getStartDate()).thenReturn(calendar3.getTime());
        expectedPracticeModuleNames.add(practiceOne);
        expectedPracticeModuleNames.add(practiceTwo);
        expectedPracticeModuleNames.add(practiceThree);

        Mockito.when(mockCourse.getLearningModules()).thenReturn(expectedLearningModuleNames);
        Mockito.when(mockCourse.getPracticeModules()).thenReturn(expectedPracticeModuleNames);

        Mockito.when(mockDB.getCourse(anyLong())).thenReturn(mockCourse);

        Enrolment mockEnrolment = Mockito.mock(Enrolment.class);
        Map<Course, Float> progress = new HashMap<Course, Float>();
        Mockito.when(mockEnrolment.getEnrolledCourses()).thenReturn(progress);

        Mockito.when(mockDB.getEnrolment(anyString())).thenReturn(mockEnrolment);
    }

    public static List<Map<String, String>> getPracticeNames(Course course) {
        List<Practice> modules = course.getPracticeModules();
        List<Map<String, String>> output = new ArrayList<>();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        for (Practice prac : modules) {
            Map<String, String> practiceMap = new HashMap<>();
            practiceMap.put("name", prac.getName());
            practiceMap.put("date", dateFormat.format(prac.getStartDate()));
            output.add(practiceMap);
        }

        Collections.sort(output, Comparator.comparing(map -> map.get("date")));
        return output;
    }

    public Course getCourse(long id) {
        return mockDB.getCourse(id);
    }

    public Map<String, Boolean> getLearnNamesAndProgress(Course course) {
        List<Learn> modules = course.getLearningModules();
        Map<String, Boolean> output = new HashMap<>();
        for (Learn learn : modules) {
            output.put(learn.getName(), learn.isCompleted());
        }
        return output;
    }

    public int calculateCourseDifficulty(Course matchingCourse) {
        ArrayList<Learn> learningModules = matchingCourse.getLearningModules();
        ArrayList<Practice> practiceModules = matchingCourse.getPracticeModules();
        int sizeOfAllModules = learningModules.size() + practiceModules.size();
        int difficulty = convertModulesSizeToDifficulty(sizeOfAllModules);
        return difficulty;
    }

    public int calculateCourseTimeEstimate(Course matchingCourse) {
        ArrayList<Learn> learningModules = matchingCourse.getLearningModules();
        ArrayList<Practice> practiceModules = matchingCourse.getPracticeModules();

        return computeTimeEstimateOnSize(learningModules.size(), practiceModules.size(), 10);
    }


    private int computeTimeEstimateOnSize(int learningModulesSize, int practiceModulesSize, int setupTime) {
        int learningtime = learningModulesSize * 25;
        int practicingTime = practiceModulesSize * 10;

        return learningtime + practicingTime + setupTime;
    }

    private int convertModulesSizeToDifficulty(int sizeOfAllModules) {
        if (sizeOfAllModules < 4) {
            return 1;
        } else if (sizeOfAllModules < 7) {
            return 2;
        } else if (sizeOfAllModules < 10) {
            return 3;
        } else if (sizeOfAllModules < 13) {
            return 4;
        } else {
            return 5;
        }
    }

    public ArrayList<String> getCourseSyllabus(Course matchingCourse) {
        ArrayList<String> generatedSyllabus = new ArrayList<String>();
        ArrayList<Learn> learningModules = matchingCourse.getLearningModules();
        ArrayList<Practice> practiceModules = matchingCourse.getPracticeModules();

        int i = 0;
        while (i < learningModules.size() || i < practiceModules.size()) {
            if (i < learningModules.size()) {
                generatedSyllabus.add("Learning: ".concat(learningModules.get(i).getName()));
            }

            if (i < practiceModules.size()) {
                generatedSyllabus.add("Practice: ".concat(practiceModules.get(i).getName()));
            }
            i++;
        }

        return generatedSyllabus;
    }

    public boolean getEnrolmentStatus(Course course, String username) {
        Enrolment userEnrolments = mockDB.getEnrolment(username);
        boolean isEnrolled = userEnrolments.getEnrolledCourses().keySet().contains(course);
        return isEnrolled;
    }

    public boolean addEnrolment(Course course, String username) {
        Enrolment userEnrolments = mockDB.getEnrolment(username);
        userEnrolments.getEnrolledCourses().put(course, 0f);
        return true;
    }
}
