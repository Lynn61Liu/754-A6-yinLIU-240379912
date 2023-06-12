package nz.ac.auckland.se754.web.model.factory;

import java.util.ArrayList;

public class Factory {
    
    public Module getModule(String moduleType){
        if(moduleType == null){
            return null;
        }
        if(moduleType.equalsIgnoreCase("PRACTICE")){
            return new Practice();
        } else if(moduleType.equalsIgnoreCase("LEARNING")){
            return new Learn();
        }

        return null;
    }

    public Question getQuestions(){
        return new Question();
    }

    public Course getCourse(long id){
        return new Course(id);
    }
    
    public Enrolment getEnrolment(String userName){
        return new Enrolment();
    }

    public User getUser(int id){
        return new User();
    }
    public ArrayList<Course> getAllCourses() {
        ArrayList<Course> courseList = new ArrayList<>();
        return courseList;
    }
}
