import java.sql.*;
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

        String url = "jdbc:postgresql://localhost:5432/hotel";
        String user = "postgres";
        String password = "1234";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {

            System.out.println("Connected to database!");

            String insertRoom =
                    "INSERT INTO rooms(room_number, room_type, price, is_available) VALUES (?, ?, ?, ?)";
            PreparedStatement psRoom = conn.prepareStatement(insertRoom);
            psRoom.setInt(1, 101);
            psRoom.setString(2, "Single");
            psRoom.setInt(3, 20000);
            psRoom.setBoolean(4, true);
            psRoom.executeUpdate();
            System.out.println("Room added");

            Statement stmt = conn.createStatement();
            ResultSet rsRooms = stmt.executeQuery("SELECT * FROM rooms");

            System.out.println("\nRooms:");
            while (rsRooms.next()) {
                System.out.println(
                        rsRooms.getInt("id") + " | Room " +
                                rsRooms.getInt("room_number") + " | " +
                                rsRooms.getString("room_type") + " | Price: " +
                                rsRooms.getInt("price") + " | Available: " +
                                rsRooms.getBoolean("is_available")
                );
            }

            String insertGuest =
                    "INSERT INTO guests(full_name, phone, room_id) VALUES (?, ?, ?)";
            PreparedStatement psGuest = conn.prepareStatement(insertGuest);
            psGuest.setString(1, "Ali Akhmetov");
            psGuest.setString(2, "+77011234567");
            psGuest.setInt(3, 1); // room_id
            psGuest.executeUpdate();
            System.out.println("\nGuest added");

            ResultSet rsGuests = stmt.executeQuery(
                    "SELECT g.id, g.full_name, r.room_number " +
                            "FROM guests g JOIN rooms r ON g.room_id = r.id"
            );

            System.out.println("\nGuests:");
            while (rsGuests.next()) {
                System.out.println(
                        rsGuests.getInt("id") + " | " +
                                rsGuests.getString("full_name") + " | Room: " +
                                rsGuests.getInt("room_number")
                );
            }

            String updateRoom =
                    "UPDATE rooms SET is_available = false WHERE id = 1";
            stmt.executeUpdate(updateRoom);
            System.out.println("\nRoom updated (not available)");

            String deleteGuest =
                    "DELETE FROM guests WHERE full_name = 'Ali Akhmetov'";
            stmt.executeUpdate(deleteGuest);
            System.out.println("Guest deleted");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}