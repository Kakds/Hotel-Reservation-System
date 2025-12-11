public class Booking {
    private Guest guest;
    private Room room;
    private int night;

    public Booking(Guest guest, Room room, int night){
        this.guest=guest;
        this.room=room;
        this.night=night;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public int getNight() {
        return night;
    }

    public void setNight(int night) {
        this.night = night;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public double cost(){
        return room.getPrice()*night;
    }

    public void info(){
        System.out.println("Booking: ");
        guest.info();
        room.info();
        System.out.println("For how many nights: "+night+" Total cost:"+cost());
    }
}