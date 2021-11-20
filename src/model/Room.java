package model;

public class Room implements IRoom{
    String roomNumber;
    double price;
    RoomType enumeration;

    public Room(String roomNumber, double price, RoomType enumeration) {
        this.roomNumber = roomNumber;
        this.price = price;
        this.enumeration = enumeration;
    }

    public Room(String roomNumber, RoomType enumeration) {
        this.roomNumber = roomNumber;
        this.enumeration = enumeration;
    }

    @Override
    public String getRoomNumber() {
        return roomNumber;
    }

    @Override
    public double getRoomPrice() {
        return Double.parseDouble(String.valueOf(price));
    }

    @Override
    public RoomType getRoomType() {
        return enumeration;
    }

    @Override
    public boolean isFree() {
        return false;
    }

    @Override
    public String toString() {
        return "ROOM - {" +
                "roomNumber - " + roomNumber +
                ", price - $" + price +
                ", enumeration - " + enumeration +
                '}';
    }
}
