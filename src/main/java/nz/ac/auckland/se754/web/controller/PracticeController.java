package nz.ac.auckland.se754.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;


@Controller
@SessionAttributes("name")
public class PracticeController {
    ModelAndView map = new ModelAndView("/practice");

    @RequestMapping(value="/practice/{id}", method = RequestMethod.GET)
    public ModelAndView showPractice(ModelMap model, @PathVariable String id) {
        return map;
    }
}
