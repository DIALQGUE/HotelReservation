import java.util.ArrayList;
// Object: DeluxeRoom class
public class DeluxeRoom extends Room {
    private boolean additionalBed;
    private AmenityFactory normalAmenityFactory;
    private ArrayList<Amenity> amenityList = new ArrayList<Amenity>();

    public DeluxeRoom() {
        super();
        this.setRoomType("Deluxe room");
        this.setDescription("Deluxe Room come with double bed in room size 450 square feet at 2500 baht base price per night, can add extra bed but cannot add amenities");
    }
    
    public DeluxeRoom(int number) {
        super(number);
        this.setBasePrice(2500);
        this.setRoomSize(450);
        this.getBedList().add(new Bed("Double"));
        this.setRoomType("Deluxe room");
        this.setDescription("Deluxe Room come with double bed in room size 450 square feet at 2500 baht base price per night, can add extra bed but cannot add amenities");
        this.additionalBed = false;
        this.normalAmenityFactory = new NormalAmenityFactory();
        this.amenityList.add(this.normalAmenityFactory.createFoodAmenity());
    }

    // Add additional bed
    public void addBed() {
        if (this.additionalBed == false) {
            this.getBedList().add(new Bed("Single"));
            this.additionalBed = true;
        }
        else {
            System.out.println("Room already has an additional bed, cannot add more bed");
        }
    }
    // Remove additional bed
    public void removeBed() {
        if (this.additionalBed == true) {
            this.getBedList().remove(1);
            this.additionalBed = false;
        }
        else {
            System.out.println("Room does not have an additional bed, cannot remove bed");
        }
    }

    public ArrayList<Amenity> getAmenityList() {
        return this.amenityList;
    }

    public float getTotalPrice(int stayDay) {
        float totalPrice = this.getBasePrice();
        if (this.additionalBed == true) {
            totalPrice += 500;
        }
        if (this.amenityList.size() > 0) {
            for (Amenity amenity : amenityList) {
                totalPrice += amenity.getPrice();
            }
        }
        totalPrice = totalPrice * stayDay;
        return totalPrice;
    }

    public void print() {
        System.out.println("Room number: " + this.getNumber());
        System.out.println("Room type: " + this.getRoomType());
        System.out.println("Description: " + this.getDescription());
        System.out.println("Bed List: ");
        for (int i = 0; i < this.getBedList().size(); i++) {
            System.out.print("\tBed " + (i+1) + ": ");
            this.getBedList().get(i).print();
        }
        System.out.println("Amenity list: ");
        for (int i = 0; i < this.amenityList.size(); i++) {
            System.out.println("\tAmenity " + (i+1) + ": " + this.amenityList.get(i).getDescription());
        }
    }
}
