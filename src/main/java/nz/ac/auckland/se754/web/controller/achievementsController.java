package nz.ac.auckland.se754.web.controller;


import nz.ac.auckland.se754.web.model.factory.Achievement;
import nz.ac.auckland.se754.web.model.factory.Achievements;
import nz.ac.auckland.se754.web.model.factory.Course;
import nz.ac.auckland.se754.web.service.achievements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
@SessionAttributes("name")
public class achievementsController {
    @Autowired
    achievements service;

    ModelAndView map = new ModelAndView("/achievements");

    @RequestMapping(value="/{id}/achievements", method = RequestMethod.GET)
    public ModelAndView showAchievements(ModelMap model, @PathVariable String id){
        Achievements achievements = service.getAchievements();
        List<Achievement> achievementObjList = achievements.getAllAchievements().keySet().stream().toList();
        List<String> achievementList = new ArrayList<>();
        for (Achievement achievement : achievementObjList){
            achievementList.add(achievement.getName());
        }
        List<String> achievementStateList = new ArrayList<>();
        List<Boolean> achievementStateObjList = achievements.getAllAchievements().values().stream().toList();
        for (Boolean bool : achievementStateObjList){
            achievementStateList.add(bool.toString());
        }

        map.addObject("achievementList",achievementList);
        map.addObject("achievementStateList",achievementStateList);

        return map;
    }

    @RequestMapping(value="/{id}/achievements2", method = RequestMethod.GET)
    public ModelAndView showUpdatedAchievements(ModelMap model, @PathVariable String id){
        Achievements achievements = service.getAchievements();
        Map<Achievement,Boolean> achievementsList = achievements.getAllAchievements();
        List<Achievement> achievementObjList = achievementsList.keySet().stream().toList();

        Achievement achieved = (Achievement) achievementsList.keySet().toArray()[0];
        achievementsList.put(achieved,true);

        service.setAchievements(achievementsList);

        List<String> achievementList = new ArrayList<>();
        for (Achievement achievement : achievementObjList){
            achievementList.add(achievement.getName());
        }
        List<String> achievementStateList = new ArrayList<>();
        List<Boolean> achievementStateObjList = achievementsList.values().stream().toList();
        for (Boolean bool : achievementStateObjList){
            achievementStateList.add(bool.toString());
        }

        map.addObject("achievementList",achievementList);
        map.addObject("achievementStateList",achievementStateList);

        return map;
    }
    @RequestMapping(value="/{id}/achievements2", method = RequestMethod.POST,params = "unachieved")
    public ModelAndView showUnachievedAchievements(ModelMap model, @PathVariable String id){

        Set<Map.Entry<Achievement,Boolean>> achievementsList = service.getAchievements().getAllAchievements().entrySet();
        Map<Achievement,Boolean> unachieved = new HashMap<>();
        for (Map.Entry<Achievement,Boolean> entry : achievementsList) {
            if(entry.getValue().equals(false)){
                unachieved.put(entry.getKey(), entry.getValue());
            }
        }

        List<String> achievementList = new ArrayList<>();
        for (Achievement achievement : unachieved.keySet()){
            achievementList.add(achievement.getName());
        }
        List<String> achievementStateList = new ArrayList<>();
        List<Boolean> achievementStateObjList = unachieved.values().stream().toList();
        for (Boolean bool : achievementStateObjList){
            achievementStateList.add(bool.toString());
        }

        map.addObject("achievementList",achievementList);
        map.addObject("achievementStateList",achievementStateList);
        return map;
    }

    @RequestMapping(value="/{id}/achievements2", method = RequestMethod.POST,params = "achieved")
    public ModelAndView showAchievedAchievements(ModelMap model, @PathVariable String id){

        Set<Map.Entry<Achievement,Boolean>> achievementsList = service.getAchievements().getAllAchievements().entrySet();
        Map<Achievement,Boolean> unachieved = new HashMap<>();
        for (Map.Entry<Achievement,Boolean> entry : achievementsList) {
            if(entry.getValue().equals(true)){
                unachieved.put(entry.getKey(), entry.getValue());
            }
        }

        List<String> achievementList = new ArrayList<>();
        for (Achievement achievement : unachieved.keySet()){
            achievementList.add(achievement.getName());
        }
        List<String> achievementStateList = new ArrayList<>();
        List<Boolean> achievementStateObjList = unachieved.values().stream().toList();
        for (Boolean bool : achievementStateObjList){
            achievementStateList.add(bool.toString());
        }

        map.addObject("achievementList",achievementList);
        map.addObject("achievementStateList",achievementStateList);
        return map;
    }
}
