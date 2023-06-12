package nz.ac.auckland.se754.web.controller;

import nz.ac.auckland.se754.web.service.Database;
import org.mockito.Mockito;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import nz.ac.auckland.se754.web.service.Register;

@Controller
@SessionAttributes("name")
public class RegisterController {


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegisterPage(ModelMap model) {
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String showWelcomePage(ModelMap model, @RequestParam String formEmail, @RequestParam String formName) {

        Database mockDB = Mockito.mock(Database.class);
        Mockito.when(mockDB.getUsername("user1")).thenReturn("user1");
        Mockito.when(mockDB.getEmail("user1")).thenReturn("user1@gmail.com");
        Register registerService = new Register(mockDB);
        boolean existingEmail = registerService.validateUserEmail(formEmail, "user1");
        boolean existingName = registerService.validateUserName(formName, "user1");

        if (!existingEmail && !existingName) {
            model.put("successMessage", "You have created an account!");
            return "register";
        } else if (existingEmail) {
            model.put("errorMessage", "This email is taken!");
            return "register";
        } else if (existingName) {
            model.put("errorMessage", "This username is taken!");
            return "register";
        }
        return "register";
    }

}
