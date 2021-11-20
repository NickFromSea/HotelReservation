package model;

public class FreeRoom extends Room{

    public FreeRoom(String roomNumber, RoomType enumeration) {
        super(roomNumber, enumeration);
    }

    @Override
    public double getRoomPrice() {
        return 0.0d;
    }

    @Override
    public String toString() {
        return "FreeRoom{" +
                "roomNumber='" + roomNumber + '\'' +
                ", price=" + price +
                ", enumeration=" + enumeration +
                '}';
    }
}
