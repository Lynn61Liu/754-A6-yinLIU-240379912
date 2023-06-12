package nz.ac.auckland.se754.web.service;

public class Register {
    private final Database db;

    public Register(Database db) {
        this.db = db;
    }

    public boolean validateUserName(String newUserName, String existUserName) {
        return newUserName.equals(db.getUsername(existUserName));
    }

    public boolean validateUserEmail(String newUserEmail, String existUserName) {
        return newUserEmail.equals(db.getEmail(existUserName));
    }
}
