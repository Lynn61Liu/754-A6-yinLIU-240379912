package nz.ac.auckland.se754.web.model.factory;

import java.util.ArrayList;

public class Learn extends ContentModules {

    ArrayList<String> texts;
    ArrayList<String> mediaLinks;

    boolean isCompleted = false;


    @Override
    public void type() {
        System.out.println("Inside learning::type method.");
    }


    public ArrayList<String> getTexts() {
        return null;
    }

    public ArrayList<String> getMediaLinks() {
        return null;
    }

    public void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }
}
