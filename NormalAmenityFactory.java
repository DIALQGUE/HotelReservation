// Factory class for creating normal amenities
public class NormalAmenityFactory extends AmenityFactory{
     public Amenity createFoodAmenity() {
        return new Food();
    }

    public Amenity createCleaningAmenity() {
        return new CleaningService();
    }
}
