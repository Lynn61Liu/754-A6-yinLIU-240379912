package nz.ac.auckland.se754.web.controller;

import nz.ac.auckland.se754.web.model.factory.User;
import nz.ac.auckland.se754.web.service.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@SessionAttributes("value")
public class UserSettingsController {

    @Autowired
    UserProfile profileService;

    ModelAndView map = new ModelAndView("/settings");

    @RequestMapping(value = "/settings/{id}", method = RequestMethod.GET)
    public ModelAndView showSettingsPage(ModelMap model, @PathVariable String id) {
        return map;
    }

    @RequestMapping(value = "/settings/{id}", method = RequestMethod.POST)
    public ModelAndView editSettingsPage(ModelMap model, @PathVariable String id, @RequestParam(value = "checkBox", required = false) String checkBoxValue) {

        User newUser = profileService.getUser(Integer.parseInt(id));

        if (checkBoxValue != null || checkBoxValue.length() != 0) {
            Map<String, Boolean> userSettings = newUser.getSettings();
            newUser.setSettings(userSettings);
            model.put("successMessage", "Settings saved!");
        }
        return map;
    }
}
