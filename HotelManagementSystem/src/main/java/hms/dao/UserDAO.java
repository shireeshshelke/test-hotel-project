package hms.dao;

import hms.model.User;
import java.util.List;

public interface UserDAO {
    void addUser(User user) throws Exception;
    User getUserByUsername(String username) throws Exception;
    List<User> getAllUsers() throws Exception;
}
