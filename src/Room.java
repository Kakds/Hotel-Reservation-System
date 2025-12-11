public class Room {
    private int RoomNum;
    private String RoomType;
    private double price;
    private int PepSum;

    public Room(int RoomNum, String RoomType, double price, int PepSum){
        this.price=price;
        this.RoomNum=RoomNum;
        this.RoomType=RoomType;
        this.PepSum=PepSum;
    }

    public int getPepSum() {
        return PepSum;
    }

    public void setPepSum(int pepSum) {
        PepSum = pepSum;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRoomNum() {
        return RoomNum;
    }

    public void setRoomNum(int roomNum) {
        RoomNum = roomNum;
    }

    public String getRoomType() {
        return RoomType;
    }

    public void setRoomType(String roomType) {
        RoomType = roomType;
    }

    public void info() {
        System.out.println("Room "+RoomNum+"[ "+RoomType+" ] "+"Price for night: "+price+" "+"How many people: "+ PepSum);
    }
}