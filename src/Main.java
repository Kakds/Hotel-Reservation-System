public class Main {
    public static void main(String[] args){
        Room r1 = new Room(123, "Deluxe", 500.0 , 5);
        Room r2 = new Room(101, "Basic", 150.0, 2);

        Guest g1 = new Guest("Cristiano", "Ronaldo", 1);
        Guest g2 = new Guest("Lionel", "Pepsi", 2);

        r1.info();
        r2.info();
        g1.info();
        g2.info();

        Booking b1 = new Booking(g1, r1, 3);
        b1.info();

        System.out.println("Comparing room prices:");
        if (r1.getPrice()> r2.getPrice()){
            System.out.println(r1.getPrice()+ " is more expensive");
        } else if (r1.getPrice()< r2.getPrice()) {
            System.out.println(r2.getPrice()+" is more expensive");
        }else {
            System.out.println("There price is equal");
        }
    }
}