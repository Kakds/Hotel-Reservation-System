public class Booking {
    private Guest guest;
    private Room room;
    private int night;

    public Booking(Guest guest, Room room, int night){
        this.guest=guest;
        this.room=room;
        this.night=night;
        room.setAvailable(false);
    }

    public double cost(){
        return room.getPrice()*night;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "guest=" + guest +
                ", room=" + room +
                ", night=" + night +
                '}';
    }
}