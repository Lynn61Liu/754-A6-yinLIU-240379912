package nz.ac.auckland.se754.web.controller;

import nz.ac.auckland.se754.web.service.LearnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@SessionAttributes("name")
public class LearnController {
    @Autowired
    LearnService service;

    ModelAndView map = new ModelAndView("/learn");

    @RequestMapping(value = "/learn/{id}", method = RequestMethod.GET)
    public ModelAndView showLearningPage(ModelMap model) {
        String name = service.getName();
        List<String> learningText = service.getTexts();
        List<String> learningImages = service.getImages();
        List<String> learningVideos = service.getVideos();

        map.addObject("name", name);
        map.addObject("learningText", learningText);
        map.addObject("learningImages", learningImages);
        map.addObject("learningVideos", learningVideos);
        return map;
    }
}
