// Object: PremiumRoom
public class PremiumRoom extends Room {
    
    public PremiumRoom() {
        super();
        this.setRoomType("Premium room");
        this.setDescription("Premium Room come with single bed in room size 300 square feet at 1500 baht base price per night, cannot add extra bed or add amenities");
    }

    public PremiumRoom(int number) {
        super(number);
        this.setBasePrice(1500);
        this.setRoomSize(300);
        this.getBedList().add(new Bed("Single"));
        this.setRoomType("Premium room");
        this.setDescription("Premium Room come with single bed in room size 300 square feet at 1500 baht base price per night, cannot add extra bed or add amenities");
    }

    public float getTotalPrice(int stayDay) {
        return this.getBasePrice() * stayDay;
    }

    // Override print method from room class
    public void print() {
        System.out.println("Room number: " + this.getNumber());
        System.out.println("Room type: " + this.getRoomType());
        System.out.println("Description: " + this.getDescription());
        System.out.println("Bed List: ");
        for (int i = 0; i < this.getBedList().size(); i++) {
            System.out.print("\tBed " + (i+1) + ": ");
            this.getBedList().get(i).print();
        }
    }
}
