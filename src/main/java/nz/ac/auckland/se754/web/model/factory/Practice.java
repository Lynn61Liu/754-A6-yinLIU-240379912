package nz.ac.auckland.se754.web.model.factory;
import java.util.ArrayList;
import java.util.Map;

public class Practice extends ContentModules {
    ArrayList<String[]> fillInTheBlanksQuestionsAndAnswers;

    Map<String, Boolean> trueOrFalseQuestionsAndAnswers;

    boolean isCompleted = false;

    @Override
    public void type() {
        System.out.println("Inside practice::type method.");
    }


    public void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public ArrayList<String[]> getFillInTheBlanksQuestionsAndAnswers() {
        return fillInTheBlanksQuestionsAndAnswers;
    }

    public Map<String, Boolean> getTrueOrFalseQuestionsAndAnswers() {
        return trueOrFalseQuestionsAndAnswers;
    }

}
