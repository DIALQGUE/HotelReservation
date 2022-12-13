import java.util.ArrayList;

public class DeluxeRoom extends Room {
    private boolean additionalBed;
    private ArrayList<Amenity> amenityList = new ArrayList<Amenity>();

    public DeluxeRoom() {
        super();
        this.setDescription("Deluxe Room come with double bed in room size 40 square feet at 2500 baht base price per night, can add extra bed but cannot add amenities");
    }

    public DeluxeRoom(int number) {
        super(number);
        this.setBasePrice(2500);
        this.setRoomSize(40);
        this.getBedList().add(new Bed("Double"));
        this.setDescription("Deluxe Room come with double bed in room size 40 square feet at 2500 baht base price per night, can add extra bed but cannot add amenities");
        this.additionalBed = false;
        this.amenityList.add((new NormalAmenityFactory()).createFoodAmenity());
    }

    public void addBed() {
        if (this.additionalBed == false) {
            this.getBedList().add(new Bed("Single"));
            this.additionalBed = true;
        }
        else {
            System.out.println("Room already has an additional bed, cannot add more bed");
        }
    }

    public void removeBed() {
        if (this.additionalBed == true) {
            this.getBedList().remove(1);
            this.additionalBed = false;
        }
        else {
            System.out.println("Room does not have an additional bed, cannot remove bed");
        }
    }

    public float getTotalPrice() {
        float totalPrice = this.getBasePrice();
        if (this.additionalBed == true) {
            totalPrice += 500;
        }
        if (this.amenityList.size() > 0) {
            for (Amenity amenity : amenityList) {
                totalPrice += amenity.getPrice();
            }
        }
        return totalPrice;
    }
}
