package hms.dao;

import hms.model.Room;
import java.util.List;

public interface RoomDAO {
    List<Room> getAllRooms();
    Room getRoomById(int id);
    void addRoom(Room room);
    void updateRoom(Room room);
    void deleteRoom(int id);
}
