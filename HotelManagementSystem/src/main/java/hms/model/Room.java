package hms.model;

public class Room {
    private int id;
    private String type;
    private boolean available;

    public Room(int id, String type, boolean available) {
        this.id = id;
        this.type = type;
        this.available = available;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
}
