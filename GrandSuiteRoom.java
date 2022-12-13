import java.util.ArrayList;

public class GrandSuiteRoom extends Room {
    private boolean additionalBed;
    private ArrayList<Amenity> amenityList = new ArrayList<Amenity>();
    
    public GrandSuiteRoom() {
        super();
        this.setDescription("Grand Suite Room come with single bed and double bed in room size 60 square feet at 4000 baht base price per night, can add extra bed and amenities");
    }

    public GrandSuiteRoom(int number) {
        super(number);
        this.setBasePrice(4000);
        this.setRoomSize(60);
        this.getBedList().add(new Bed("Single"));
        this.getBedList().add(new Bed("Double"));
        this.setDescription("Grand Suite Room come with single bed and double bed in room size 60 square feet at 4000 baht base price per night, can add extra bed and amenities");
        this.additionalBed = false;
        this.amenityList.add((new NormalAmenityFactory()).createFoodAmenity());
        this.amenityList.add((new NormalAmenityFactory()).createCleaningAmenity());
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

    public void addAmenity(Amenity amenity) {
        this.amenityList.add(amenity);
    }

    public void removeAmenity(Amenity amenity) {
        if (this.amenityList.contains(amenity)) {
            this.amenityList.remove(amenity);
        }
        else {
            System.out.println("Amenity not found");
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
