import java.util.ArrayList;

public class GrandSuiteRoom extends Room {
    private boolean additionalBed;
    private AmenityFactory normalAmenityFactory, plusAmenityFactory;
    private ArrayList<Amenity> amenityList = new ArrayList<Amenity>();
    
    public GrandSuiteRoom() {
        super();
        this.setRoomType("Grand Suite room");
        this.setDescription("Grand Suite Room come with single bed and double bed in room size 600 square feet at 4000 baht base price per night, can add extra bed and amenities");
    }

    public GrandSuiteRoom(int number) {
        super(number);
        this.setBasePrice(4000);
        this.setRoomSize(600);
        this.getBedList().add(new Bed("Single"));
        this.getBedList().add(new Bed("Double"));
        this.setRoomType("Grand Suite room");
        this.setDescription("Grand Suite Room come with single bed and double bed in room size 600 square feet at 4000 baht base price per night, can add extra bed and amenities");
        this.normalAmenityFactory = new NormalAmenityFactory();
        this.plusAmenityFactory = new PlusAmenityFactory();
        this.additionalBed = false;
        this.amenityList.add(this.normalAmenityFactory.createFoodAmenity());
        this.amenityList.add(this.normalAmenityFactory.createCleaningAmenity());
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

    // Add more amenity
    public void addFoodPlusAmenity() {
        this.amenityList.add(this.plusAmenityFactory.createFoodAmenity());
    }

    public void addCleaningPlusAmenity() {
        this.amenityList.add(this.plusAmenityFactory.createCleaningAmenity());
    }

    // Remove amenity
    public void removeAmenity(Amenity amenity) {
        if (this.amenityList.contains(amenity)) {
            this.amenityList.remove(amenity);
        }
        else {
            System.out.println("Amenity not found");
        }
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
