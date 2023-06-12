package nz.ac.auckland.se754.web.model.factory;
import java.util.Map;

public class Users {
    Map<Integer, User> listOfUsers;

    public Map<Integer, User> getListOfUsers() {
        return listOfUsers;
    }

    public void setListOfUsers(Map<Integer, User> userList) {
        this.listOfUsers = userList;
    }
}
