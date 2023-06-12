package nz.ac.auckland.se754.web.controller;

import nz.ac.auckland.se754.web.model.factory.Course;
import nz.ac.auckland.se754.web.model.factory.Practice;
import nz.ac.auckland.se754.web.service.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes("name")
public class ResultsController {

    @Autowired
    Results service;

    ModelAndView map = new ModelAndView("/practice-results");

    @RequestMapping(value="/practice/{id}/results", method = RequestMethod.GET)
    public ModelAndView showResults(ModelMap model, @PathVariable String id) {
        String username = (String) model.get("name");
        if (username == null) {
            username = "user1";
        }

        Practice practice = service.getPractice(id);

        // This should be a value passed to the page from the POST request of the previous page in a real application
        Map<String, Boolean> userAnswers = new HashMap<String, Boolean>();
        userAnswers.put("A for loop is a loop", true);
        userAnswers.put("A for loop can loop indefinitely", true);
        userAnswers.put("the for loop is the only way to loop", true);
        userAnswers.put("for loops are unique to Java", false);
        userAnswers.put("for loops are useful", true);
        userAnswers.put("Loops can be replaced with if statements", false);

        String overallResult = service.getOverallTrueFalseResult(userAnswers, practice);
        double rawPercentage = service.calculateTrueOrFalseResults(userAnswers, practice);
        String percentageResult = Double.toString(rawPercentage);

        Map<String, Boolean> incorrectQuestionsAndAnswers = service.getAnswersForIncorrectTrueOrFalseQuestions(userAnswers, practice);
        List<String> questionList = incorrectQuestionsAndAnswers.keySet().stream().toList();
        List<Boolean> answerList = incorrectQuestionsAndAnswers.values().stream().toList();

        map.addObject("overallResult", overallResult);
        map.addObject("practiceName", practice.getName());
        map.addObject("percentageResult", percentageResult);
        map.addObject("questionList", questionList);
        map.addObject("answerList", answerList);
        return map;
    }

    @RequestMapping(value="/practice/{id}/results", method = RequestMethod.POST)
    public String navigateToPracticeAgain(ModelMap model, @PathVariable String id){
        return "redirect:/practice/".concat(id);
    }
}
