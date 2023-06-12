package nz.ac.auckland.se754.web.service;


import nz.ac.auckland.se754.web.model.factory.Achievement;
import nz.ac.auckland.se754.web.model.factory.Achievements;
import nz.ac.auckland.se754.web.model.factory.Factory;
import org.mockito.Mockito;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class achievements {
    Achievements mockAchievements;
    public achievements(){

        Achievement mockAchievementOne = Mockito.mock(Achievement.class);
        Mockito.when(mockAchievementOne.getId()).thenReturn(100L);
        Mockito.when(mockAchievementOne.getName()).thenReturn("Finished 1st Learning Module");
        Mockito.when(mockAchievementOne.getDescription()).thenReturn("Finished your learning module");

        Achievement mockAchievementTwo = Mockito.mock(Achievement.class);
        Mockito.when(mockAchievementTwo.getId()).thenReturn(101L);
        Mockito.when(mockAchievementTwo.getName()).thenReturn("Finished 1st Practice Module");
        Mockito.when(mockAchievementTwo.getDescription()).thenReturn("Finished your practice module");

        Map<Achievement,Boolean> expectedAchievementList = new HashMap<>();
        expectedAchievementList.put(mockAchievementOne, false);
        expectedAchievementList.put(mockAchievementTwo,false);

        mockAchievements = Mockito.mock(Achievements.class);
        Mockito.when(mockAchievements.getUserID()).thenReturn(123456L);
        Mockito.when(mockAchievements.getAllAchievements()).thenReturn(expectedAchievementList);

    }
    public Achievements getAchievements(){return mockAchievements;}

    public Boolean setAchievements(Map<Achievement,Boolean> map){
        mockAchievements.setAchievements(map);
        Mockito.when(mockAchievements.getAllAchievements()).thenReturn(map);
        return true;}
}
