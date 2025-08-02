package hms.dao;

import hms.model.User;
import java.sql.*;
import java.util.*;

public class UserDAOMySQLImpl implements UserDAO {
    private final Connection conn;

    public UserDAOMySQLImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void addUser(User user) throws Exception {
        try (PreparedStatement ps = conn.prepareStatement("INSERT INTO login (username, password) VALUES (?, ?)");) {
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new Exception("User already exists!");
        } catch (SQLException e) {
            throw new Exception("Database error: " + e.getMessage());
        }
    }

    @Override
    public User getUserByUsername(String username) throws Exception {
        try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM login WHERE username = ?");) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new User(rs.getString("username"), rs.getString("password"));
            }
        } catch (SQLException e) {
            throw new Exception("Database error: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() throws Exception {
        List<User> users = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM login")) {
            while (rs.next()) {
                users.add(new User(rs.getString("username"), rs.getString("password")));
            }
        } catch (SQLException e) {
            throw new Exception("Database error: " + e.getMessage());
        }
        return users;
    }
}
