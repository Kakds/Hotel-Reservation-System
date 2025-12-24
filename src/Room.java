import java.util.Objects;

public class Room {
    private int RoomNum;
    private String RoomType;
    private double price;
    private boolean available;

    public Room(int RoomNum, String RoomType, double price, boolean available){
        this.price=price;
        this.RoomNum=RoomNum;
        this.RoomType=RoomType;
        this.available=available;
    }

    public double getPrice() {
        return price;
    }

    public int getRoomNum() {
        return RoomNum;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Room{" +
                "RoomNum=" + RoomNum +
                ", RoomType='" + RoomType + '\'' +
                ", price=" + price +
                ", available=" + available +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return RoomNum == room.RoomNum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(RoomNum);
    }
}