package hms.dao;

import hms.model.User;
import java.util.*;

public class UserDAOMemoryImpl implements UserDAO {
    private final List<User> users = new ArrayList<>();

    public UserDAOMemoryImpl() {
        // Add a default user for demo
        users.add(new User("demo", "demo"));
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
