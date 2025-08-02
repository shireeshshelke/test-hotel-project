package hms.dao;

import hms.model.User;
import java.util.*;

public class UserDAOMemoryImpl implements UserDAO {
    private static List<User> users;
    public UserDAOMemoryImpl() {
       if (users == null) {
            users = new ArrayList<>();
            users.add(new User("admin", "admin"));
        users.add(new User("user", "user"));
        }
        
    }

    @Override
    public void addUser(User user) throws Exception {
        for (User u : users) {
            if (u.getUsername().equals(user.getUsername())) {
                throw new Exception("User already exists!");
            }
        }
        users.add(user);
    }

    @Override
    public User getUserByUsername(String username) {
        System.out.println("Searching for user: " + username);
        for (User u : users) {
            if (u.getUsername().equals(username)) {
                return u;
            }
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }
}
