package nz.ac.auckland.se754.web.controller;

import nz.ac.auckland.se754.web.model.Item;
import nz.ac.auckland.se754.web.service.Questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes("name")
public class MCQController {

    @Autowired
    Questions service;

    ModelAndView map = new ModelAndView("/list-mcq");
    @RequestMapping(value = "/list-mcq/{id}", method = RequestMethod.GET)
    public ModelAndView showQuestions(ModelMap model) {
        String name = (String) model.get("name");
        List<Item> questionsAndAnswers = service.retrieveQuestionsAndAnswers(name);

        map.addObject("questionsAndAnswers", questionsAndAnswers);
        return map;
    }
}
