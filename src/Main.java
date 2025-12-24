public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();

        hotel.addRooms(new Room(101, "Basic", 100, true));
        hotel.addRooms(new Room(102, "Deluxe", 300, false));

        Guest g1 = new Guest("Cristiano Ronaldo", "777-777","suii@mail.com");
        Guest g2 = new Guest("Lionel Pepsi", "100-000", "cameraVovo@mail.com");

        System.out.println("Guests equal: "+ g1.equals(g2));

        System.out.println("\n Available rooms: ");
        hotel.availableRooms().forEach(System.out::println);

        hotel.sortRooms();
        System.out.println("\n Sorted Rooms:");
        hotel.printRooms();

        Booking b1 = new Booking(g1, hotel.findRoom(101),2);
        System.out.println("\n"+b1);
    }
}