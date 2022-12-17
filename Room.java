import java.util.ArrayList;
// Room Abstract class for all room types
public abstract class Room {
    private int number;
    private boolean reservation;
    private float basePrice;
    private int roomSize;
    private ArrayList<Bed> bedList = new ArrayList<Bed>();
    private String roomType;
    private String description;

    public Room() {
        this.reservation = false;
    }

    public Room(int number) {
        this.number = number;
        this.reservation = false;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isReserved() {
        return this.reservation;
    }

    public void reserve() {
        this.reservation = true;
    }

    public void unReserve() {
        this.reservation = false;
    }

    public float getBasePrice() {
        return this.basePrice;
    }

    public void setBasePrice(float basePrice) {
        this.basePrice = basePrice;
    }

    public int getRoomSize() {
        return this.roomSize;
    }

    public void setRoomSize(int roomSize) {
        this.roomSize = roomSize;
    }

    public ArrayList<Bed> getBedList() {
        return this.bedList;
    }

    public void setBedList(ArrayList<Bed> bedList) {
        this.bedList = bedList;
    }

    public String getRoomType() {
        return this.roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Abstract method for getting total price of room and print description
    public abstract float getTotalPrice(int stayDay);
    public abstract void print();
}
