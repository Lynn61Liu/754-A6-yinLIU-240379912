package nz.ac.auckland.se754.web.controller;

import nz.ac.auckland.se754.web.service.Database;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import nz.ac.auckland.se754.web.service.Settings;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes("value")
public class SettingsController {

    ModelAndView map = new ModelAndView("/analytics");

    @RequestMapping(value = "/settings", method = RequestMethod.GET)
    public String showSettingsPage(ModelMap model) {
        return "settings";
    }

    @RequestMapping(value = "/settings", method = RequestMethod.POST)
    public String editSettingsPage(ModelMap model, @RequestParam(value = "checkBox", required = false) String checkBoxValue) {
        Database mockDB = Mockito.mock(Database.class);
        Mockito.when(mockDB.getDarkModeSetting("user1")).thenReturn(Boolean.FALSE);
        Settings settingsService = new Settings(mockDB);

        if (checkBoxValue == null || checkBoxValue.length() == 0) {
            settingsService.saveDarkModeSetting("user1", Boolean.FALSE);
        } else {
            settingsService.saveDarkModeSetting("user1", Boolean.TRUE);
            model.put("successMessage", "Settings saved!");
        }
        return "settings";
    }

    @RequestMapping("/analytics")
    public String analyticsPage(){
        return "analytics";
    }

}
