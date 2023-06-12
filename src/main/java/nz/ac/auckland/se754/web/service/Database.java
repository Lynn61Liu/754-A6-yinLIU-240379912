package nz.ac.auckland.se754.web.service;

import java.util.Map;

public interface Database {

    String getEmail (String name);

    String getUsername(String name);

    String getPassword(String name);

    Boolean getProfileSection(String name);

    Boolean setProfileSection(String name, Boolean value);
    
    Boolean getDarkModeSetting(String name);

    Boolean setDarkModeSetting(String name, Boolean value);

    Boolean getProfileVisibility(String name);

    Boolean setProfileVisibilty(String name, Boolean value);
}
