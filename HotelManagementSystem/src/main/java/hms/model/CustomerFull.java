package hms.model;

public class CustomerFull {
    public String idType;
    public String idNumber;
    public String name;
    public String gender;
    public String country;
    public String roomNumber;
    public String roomPrice;
    public String mobile;
    public String email;
    public String checkInDate;
    public String checkOutDate;
    public String status;

    public CustomerFull(String idType, String idNumber, String name, String gender, String country, String roomNumber, String roomPrice, String mobile, String email, String checkInDate, String checkOutDate, String status) {
        this.idType = idType;
        this.idNumber = idNumber;
        this.name = name;
        this.gender = gender;
        this.country = country;
        this.roomNumber = roomNumber;
        this.roomPrice = roomPrice;
        this.mobile = mobile;
        this.email = email;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.status = status;
    }
}
