package nz.ac.auckland.se754.web.model.factory;

import java.util.ArrayList;

public class Course {
    long id;
    String category;
    String format;
    String name;
    String description;

    String topic;

    ArrayList<Learn> learningModules;
    ArrayList<Practice> practiceModules;

    public Course(long id) {
        this.id = id;
    }

    public void setLearningModules(ArrayList<Learn> learn) {
        this.learningModules = learn;
    }

    public void setPracticeModules(ArrayList<Practice> practice) {
        this.practiceModules = practice;
    }

    public ArrayList<Learn> getLearningModules() {
        return learningModules;
    }

    public ArrayList<ContentModules> getAllModules() {
        ArrayList<ContentModules> allModules = new ArrayList<>();
        allModules.addAll(learningModules);
        allModules.addAll(practiceModules);
        return allModules;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public String getFormat() {

        return format;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }
    public String getTopic() {
        return topic;
    }


    public ArrayList<Practice> getPracticeModules() {
        return practiceModules;
    }


}
