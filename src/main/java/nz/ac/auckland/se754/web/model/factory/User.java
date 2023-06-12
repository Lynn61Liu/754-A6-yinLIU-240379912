package nz.ac.auckland.se754.web.model.factory;
import java.util.Map;

public class User {
    int id;
    String name;
    String password;
    String token;
    Map<String, Boolean> settings;
    Map<String, Boolean> profileInfo;
    Boolean profileVisibility;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Map<String, Boolean> getSettings() {
        return settings;
    }

    public void setSettings(Map<String, Boolean> settings) {
        this.settings = settings;
    }

    public Map<String, Boolean> getProfileInfo() {
        return profileInfo;
    }

    public void setProfileInfo(Map<String, Boolean> profileInfo) {
        this.profileInfo = profileInfo;
    }

    public Boolean getProfileVisibility() {
        return profileVisibility;
    }

    public void setProfileVisibility(Boolean profileVisibility) {
        this.profileVisibility = profileVisibility;
    }
}
