package nz.ac.auckland.se754.web.model.factory;

import java.util.Map;

public class Achievements {
    long userID;


    //TRUE means that the achievement is achieved, FALSE means the achievement has not been achieved.
    Map<Achievement, Boolean> achievements;

    public long getUserID(){return userID;}

    public Map<Achievement,Boolean> getAllAchievements(){
        return achievements;
    }

    public void setAchievements(Map<Achievement,Boolean> achievements){
        this.achievements = achievements;
    }
}
