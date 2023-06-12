package nz.ac.auckland.se754.web.service;

import nz.ac.auckland.se754.web.model.factory.Course;
import nz.ac.auckland.se754.web.model.factory.Learn;
import nz.ac.auckland.se754.web.model.factory.Practice;
import org.mockito.Mockito;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Analytics {
    Course mockCourse;
    public Analytics(){
        Learn mockLearnOne = Mockito.mock(Learn.class);
        Mockito.when(mockLearnOne.isCompleted()).thenReturn(true);
        Mockito.when(mockLearnOne.getName()).thenReturn("Java");
        Learn mockLearnTwo = Mockito.mock(Learn.class);
        Mockito.when(mockLearnTwo.isCompleted()).thenReturn(true);
        Mockito.when(mockLearnTwo.getName()).thenReturn("Lists");
        Practice mockPracticeOne = Mockito.mock(Practice.class);
        Mockito.when(mockPracticeOne.isCompleted()).thenReturn(false);
        Mockito.when(mockPracticeOne.getName()).thenReturn("Java");
        Practice mockPracticeTwo = Mockito.mock(Practice.class);
        Mockito.when(mockPracticeTwo.isCompleted()).thenReturn(false);
        Mockito.when(mockPracticeTwo.getName()).thenReturn("Lists");
        mockCourse = Mockito.mock(Course.class);
        ArrayList<Practice> expectedPracticeModules = new ArrayList<>();
        expectedPracticeModules.add(mockPracticeOne);
        expectedPracticeModules.add(mockPracticeTwo);
        ArrayList<Learn> expectedLearnModules = new ArrayList<>();
        expectedLearnModules.add(mockLearnOne);
        expectedLearnModules.add(mockLearnTwo);
        Mockito.when(mockCourse.getName()).thenReturn("Java Essentials");
        Mockito.when(mockCourse.getLearningModules()).thenReturn(expectedLearnModules);
        Mockito.when(mockCourse.getPracticeModules()).thenReturn(expectedPracticeModules);
    }

    public Course getCourse(){return mockCourse;}
}
