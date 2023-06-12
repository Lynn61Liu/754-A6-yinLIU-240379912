package nz.ac.auckland.se754.web.service;

public class Settings {
    private final Database db;

    public Settings(Database db) {
        this.db = db;
    }

    public boolean saveDarkModeSetting(String userName, Boolean value) {
        return db.setDarkModeSetting(userName, value);
    }
}