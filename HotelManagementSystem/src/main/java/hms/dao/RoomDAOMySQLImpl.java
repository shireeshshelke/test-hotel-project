package hms.dao;

import hms.model.Room;
import java.sql.*;
import java.util.*;

public class RoomDAOMySQLImpl implements RoomDAO {
    private final Connection conn;

    public RoomDAOMySQLImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Room> getAllRooms() {
        List<Room> rooms = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM rooms")) {
            while (rs.next()) {
                rooms.add(new Room(
                    rs.getInt("id"),
                    rs.getString("type"),
                    rs.getBoolean("available")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rooms;
    }

    @Override
    public Room getRoomById(int id) {
        try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM rooms WHERE id = ?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Room(
                    rs.getInt("id"),
                    rs.getString("type"),
                    rs.getBoolean("available")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addRoom(Room room) {
        try (PreparedStatement ps = conn.prepareStatement("INSERT INTO rooms (type, available) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, room.getType());
            ps.setBoolean(2, room.isAvailable());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                room.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateRoom(Room room) {
        try (PreparedStatement ps = conn.prepareStatement("UPDATE rooms SET type=?, available=? WHERE id=?")) {
            ps.setString(1, room.getType());
            ps.setBoolean(2, room.isAvailable());
            ps.setInt(3, room.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteRoom(int id) {
        try (PreparedStatement ps = conn.prepareStatement("DELETE FROM rooms WHERE id=?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
