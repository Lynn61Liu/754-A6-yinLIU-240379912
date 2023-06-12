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
@SessionAttributes("name")
public class UserProfileController {

    @Autowired
    UserProfile profileService;

    ModelAndView map = new ModelAndView("/profile");

    @RequestMapping(value = "/profile/{id}", method = RequestMethod.GET)
    public ModelAndView showProfilePage(ModelMap model, @PathVariable String id) {
        return map;
    }

    @RequestMapping(value = "/profile/{id}", method = RequestMethod.POST)
    public ModelAndView setProfileInfoAndVisibility(ModelMap model, @PathVariable String id, @RequestParam(value = "checkBox", required = false) String pSectionTwo, @RequestParam(value = "checkBox", required = false) String pVisCheck) {

        User newUser = profileService.getUser(Integer.parseInt(id));

        if (pSectionTwo != null) {
            Map<String, Boolean> userProfileInfo = newUser.getSettings();
            profileService.setProfileInfo(userProfileInfo);
            model.put("successMessage", "Profile Information Updated!");
            return map;
        }

        if (pVisCheck != null) {
            profileService.setProfileVisibility(Boolean.TRUE);
            model.put("successMessage", "Profile Information Updated!");
            return map;
        } else {
            profileService.setProfileVisibility(Boolean.FALSE);
        }
        return map;
    }
}
