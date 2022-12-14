public class PremiumRoom extends Room {
    
    public PremiumRoom() {
        super();
        this.setDescription("Premium Room come with single bed in room size 30 square feet at 1500 baht base price per night, cannot add extra bed or add amenities");
    }

    public PremiumRoom(int number) {
        super(number);
        this.setBasePrice(1500);
        this.setRoomSize(30);
        this.getBedList().add(new Bed("Single"));
        this.setDescription("Premium Room come with single bed in room size 30 square feet at 1500 baht base price per night, cannot add extra bed or add amenities");
    }

    public float getTotalPrice() {
        return this.getBasePrice();
    }

    public void print() {
        System.out.println("Room number: " + this.getNumber());
        System.out.println("Room size: " + this.getRoomSize());
        System.out.println("Description: " + this.getDescription());
        System.out.println("Bed List: ");
        for (int i = 0; i < this.getBedList().size(); i++) {
            System.out.println("\tBed " + (i+1) + ": ");
            this.getBedList().get(i).print();
        }
    }
}