package nz.ac.auckland.se754.web.service;

import nz.ac.auckland.se754.web.model.factory.Factory;
import nz.ac.auckland.se754.web.model.factory.Practice;
import org.mockito.Mockito;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.ArgumentMatchers.anyString;

@Service
public class Results {
    private Factory mockDB;

    public Results() {
        mockDB = Mockito.mock(Factory.class);
        Practice mockPractice = Mockito.mock(Practice.class);
        Mockito.when(mockPractice.getName()).thenReturn("Java Theory - For Loops");
        Mockito.when(mockDB.getModule(anyString())).thenReturn(mockPractice);

        Map<String, Boolean> trueOrFalseQuestionsAndAnswers = new HashMap<>();
        trueOrFalseQuestionsAndAnswers.put("A for loop is a loop", true);
        trueOrFalseQuestionsAndAnswers.put("A for loop can loop indefinitely", false);
        trueOrFalseQuestionsAndAnswers.put("the for loop is the only way to loop", false);
        trueOrFalseQuestionsAndAnswers.put("for loops are unique to Java", false);
        trueOrFalseQuestionsAndAnswers.put("for loops are useful", true);
        trueOrFalseQuestionsAndAnswers.put("Loops can be replaced with if statements", false);

        Mockito.when(mockPractice.getTrueOrFalseQuestionsAndAnswers()).thenReturn(trueOrFalseQuestionsAndAnswers);

    }

    public ArrayList<String[]> getFillInTheBlanks(Practice practice) {
        return practice.getFillInTheBlanksQuestionsAndAnswers();
    }

    public Map<String, Boolean> getTrueOrFalse(Practice practice) {
        return practice.getTrueOrFalseQuestionsAndAnswers();
    }

    public double calculateTrueOrFalseResults(Map<String, Boolean> userInputAnswers, Practice practice) {
        Map<String, Boolean> answers = this.getTrueOrFalse(practice);
        int correctCount = 0;
        for (String key : userInputAnswers.keySet()) {
            Boolean questionAnswer = answers.get(key);
            if (questionAnswer == null) {
                return 0.00;
            } else if (questionAnswer == userInputAnswers.get(key)) {
                correctCount++;
            }
        }

        return getRoundedPercentage((double) correctCount, (double) userInputAnswers.size());
    }

    public String getOverallTrueFalseResult(Map<String, Boolean> userInputAnswers, Practice practice) {
        return (calculateTrueOrFalseResults(userInputAnswers, practice) >= 65.00) ? "PASS" : "FAIL";
    }

    public double calculateFillInBlankResults(ArrayList<String> userInputAnswers, Practice practice) {
        ArrayList<String[]> answers = practice.getFillInTheBlanksQuestionsAndAnswers();
        int correct = 0;
        for (int i = 0; i < userInputAnswers.size() && i < answers.size(); i++) {
            String fullAnswer = answers.get(i)[0].replace("BLANK", answers.get(i)[1]);
            if (fullAnswer.equals(userInputAnswers.get(i))) {
                correct++;
            }
        }

        return getRoundedPercentage((double) correct, (double) answers.size());
    }

    private double getRoundedPercentage(double correct, double size) {
        double rawPercentage = correct / size;

        // Round to 2 decimal places
        double percentageResult = Math.floor((rawPercentage)*10000) / 100;
        return percentageResult;
    }

    public Practice getPractice(String id) {
        return (Practice) mockDB.getModule(id);
    }

    public Map<String, Boolean> getAnswersForIncorrectTrueOrFalseQuestions(Map<String, Boolean> userInputAnswers, Practice practice) {
        Map<String, Boolean> answers = this.getTrueOrFalse(practice);
        Map<String, Boolean> feedback = new HashMap<String, Boolean>();
        for (String key : userInputAnswers.keySet()) {
            Boolean questionAnswer = answers.get(key);
            if (questionAnswer == null) {
                continue;
            } else if (questionAnswer != userInputAnswers.get(key)) {
                feedback.put(key, questionAnswer);
            }
        }

        return feedback;
    }
}
