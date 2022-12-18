// Factory class for creating plus amenities.
public class PlusAmenityFactory extends AmenityFactory{
    public Amenity createFoodAmenity() {
        return new FoodPlus();
    }

    public Amenity createCleaningAmenity() {
        return new CleaningServicePlus();
    }
}