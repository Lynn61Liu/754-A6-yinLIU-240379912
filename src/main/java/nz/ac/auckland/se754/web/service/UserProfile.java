package nz.ac.auckland.se754.web.service;

import nz.ac.auckland.se754.web.model.factory.Factory;
import nz.ac.auckland.se754.web.model.factory.User;
import org.mockito.Mockito;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;

@Service
public class UserProfile {
    private Factory mockDB;
    private User mockUser;

    public UserProfile() {
        mockDB = Mockito.mock(Factory.class);
        mockUser = Mockito.mock(User.class);

        Mockito.when(mockUser.getName()).thenReturn("user1");
        Mockito.when(mockUser.getPassword()).thenReturn("password");

        Map<String, Boolean> mockSettings = new HashMap<>();
        mockSettings.put("Dark Mode", Boolean.FALSE);
        Mockito.when(mockUser.getSettings()).thenReturn(mockSettings);

        Map<String, Boolean> mockProfile = new HashMap<>();
        mockProfile.put("Profile Information", Boolean.TRUE);
        Mockito.when(mockUser.getProfileInfo()).thenReturn(mockProfile);

        Mockito.when(mockDB.getUser(anyInt())).thenReturn(mockUser);
    }

    public User getUser(int id) {
        return mockDB.getUser(id);
    }

    public void setProfileSettings(Map<String, Boolean> profileSettings) {
        mockUser.setSettings(profileSettings);
    }

    public void setProfileInfo(Map<String, Boolean> profileInfo) {
        mockUser.setProfileInfo(profileInfo);
    }

    public void setProfileVisibility(Boolean profileVis) {
        mockUser.setProfileVisibility(profileVis);
    }
}
