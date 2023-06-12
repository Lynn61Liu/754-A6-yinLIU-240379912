package nz.ac.auckland.se754.web.service;

public class Profile {
    private final Database db;

    public Profile(Database db) {
        this.db = db;
    }

    public boolean saveProfileSection(String userName, Boolean value) {
        return db.setProfileSection(userName, value);
    }
    public boolean saveProfileVisibility(String userName, Boolean value) {
        return db.setProfileVisibilty(userName, value);
    }

}