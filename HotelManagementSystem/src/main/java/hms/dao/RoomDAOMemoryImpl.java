package hms.dao;

import hms.model.Room;
import java.util.*;

public class RoomDAOMemoryImpl implements RoomDAO {
    private static List<Room> rooms;

    public RoomDAOMemoryImpl() {
        // Stub data
        if (rooms == null) {
            rooms = new ArrayList<>();
            rooms.add(new Room(1, "Single", true));
        rooms.add(new Room(2, "Double", false));
        rooms.add(new Room(3, "Suite", true));
        }
        
    }

    @Override
    public List<Room> getAllRooms() {
        return new ArrayList<>(rooms);
    }

    @Override
    public Room getRoomById(int id) {
        return rooms.stream().filter(r -> r.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void addRoom(Room room) {
        rooms.add(room);
    }

    @Override
    public void updateRoom(Room room) {
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getId() == room.getId()) {
                rooms.set(i, room);
                return;
            }
        }
    }

    @Override
    public void deleteRoom(int id) {
        rooms.removeIf(r -> r.getId() == id);
    }
}
