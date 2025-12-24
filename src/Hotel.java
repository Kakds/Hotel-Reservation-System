import java.util.*;
public class Hotel {
    private List<Room> rooms = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();

    public void addRooms(Room room) {
        rooms.add(room);
    }

    public Room findRoom(int num) {
        for (Room r : rooms) {
            if (r.getRoomNum() == num) {
                return r;
            }
        }
        return null;
    }

    public List<Room> availableRooms() {
        List<Room> result = new ArrayList<>();
        for (Room r : rooms) {
            if (r.isAvailable())
                result.add(r);
        }
        return result;
    }

    public void addBooking(Booking booking){
        bookings.add(booking);
    }

    public void sortRooms(){
        rooms.sort(Comparator.comparingDouble(Room::getPrice));
    }

    public void printRooms(){
        rooms.forEach(System.out::println);
    }
}
