package nz.ac.auckland.se754.web.service;

import nz.ac.auckland.se754.web.model.Item;
import nz.ac.auckland.se754.web.model.factory.Course;
import org.mockito.Mockito;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class Filter {
    private final ArrayList<Course> mockedCoursesList = new ArrayList<>();

    public Filter(){
//mock  course01
        Course mockCourse1 = Mockito.mock(Course.class);
        Mockito.when(mockCourse1.getId()).thenReturn(Long.valueOf(123456780));
        Mockito.when(mockCourse1.getName()).thenReturn("Full Stack Java developer");
        Mockito.when(mockCourse1.getCategory()).thenReturn("Programming Languages");
        Mockito.when(mockCourse1.getDescription()).thenReturn("Full Stack Java developer - Core Java + JSP Servlets + Hibernate +Spring + Java Web-service/RestFul API + Spring boot.");
        Mockito.when(mockCourse1.getFormat()).thenReturn("Text");
        Mockito.when(mockCourse1.getTopic()).thenReturn("Java");


//mock  course02
        Course mockCourse2 = Mockito.mock(Course.class);
        Mockito.when(mockCourse2.getId()).thenReturn(Long.valueOf(123456781));
        Mockito.when(mockCourse2.getName()).thenReturn("Python Fundamentals");
        Mockito.when(mockCourse2.getCategory()).thenReturn("Programming Languages");
        Mockito.when(mockCourse2.getDescription()).thenReturn("Learn the basics of Python programming language.");
        Mockito.when(mockCourse2.getFormat()).thenReturn("Text");
        Mockito.when(mockCourse2.getTopic()).thenReturn("Python");

//mock  course03
        Course mockCourse3 = Mockito.mock(Course.class);
        Mockito.when(mockCourse3.getId()).thenReturn(Long.valueOf(123456782));
        Mockito.when(mockCourse3.getName()).thenReturn("Operating Systems Design");
        Mockito.when(mockCourse3.getCategory()).thenReturn("Systems");
        Mockito.when(mockCourse3.getDescription()).thenReturn("Introduce OS definition, challenges, and history .");
        Mockito.when(mockCourse3.getFormat()).thenReturn("video");
        Mockito.when(mockCourse3.getTopic()).thenReturn("Systems");

//mock  course04
        Course mockCourse4 = Mockito.mock(Course.class);
        Mockito.when(mockCourse4.getId()).thenReturn(Long.valueOf(123456783));
        Mockito.when(mockCourse4.getName()).thenReturn("Introduction to Computational Robotics");
        Mockito.when(mockCourse4.getCategory()).thenReturn("Robotics");
        Mockito.when(mockCourse4.getDescription()).thenReturn("This course provides a general introduction to robotics from a computational perspective with a focus on mobile robots.");
        Mockito.when(mockCourse4.getFormat()).thenReturn("video");
        Mockito.when(mockCourse4.getTopic()).thenReturn("AI");

//mock  course05
        Course mockCourse5 = Mockito.mock(Course.class);
        Mockito.when(mockCourse5.getId()).thenReturn(Long.valueOf(123456784));
        Mockito.when(mockCourse5.getName()).thenReturn("The Complete Java Development Bootcamp");
        Mockito.when(mockCourse5.getCategory()).thenReturn("Bootcamp");
        Mockito.when(mockCourse5.getDescription()).thenReturn("Become an Experienced Java Developer with Just One Course. Fully Updated with 100+ Coding Challenges!");
        Mockito.when(mockCourse5.getFormat()).thenReturn("video");
        Mockito.when(mockCourse5.getTopic()).thenReturn("Java");


        mockedCoursesList.add(mockCourse1);
        mockedCoursesList.add(mockCourse2);
        mockedCoursesList.add(mockCourse3);
        mockedCoursesList.add(mockCourse4);
        mockedCoursesList.add(mockCourse5);
    }

    public ArrayList<Course> getAllCourses(){
        return mockedCoursesList;
    }
    public ArrayList<Course> searchCourses(String query) {
        ArrayList<Course> matchedCoursesList = new ArrayList<>();
        for (Course course : mockedCoursesList) {
            if (course.getName().toLowerCase().contains(query.toLowerCase()) ||
                    course.getDescription().toLowerCase().contains(query.toLowerCase())) {
                matchedCoursesList.add(course);
            }
        }
        return matchedCoursesList;
    }

    public ArrayList<Course> searchCoursesCategory(String Category) {
        ArrayList<Course> matchedCoursesList = new ArrayList<>();
        for (Course course : mockedCoursesList) {
            if (course.getCategory().toLowerCase().contains(Category.toLowerCase()) ) {
                matchedCoursesList.add(course);
            }
        }
        return matchedCoursesList;
    }

    public ArrayList<Course>
    sortAllCourses() {
        ArrayList<Course> sortedList = new ArrayList<>(mockedCoursesList);
        Collections.sort(sortedList, (c1, c2) -> c1.getName().compareTo(c2.getName()));
        return sortedList;
    }

}