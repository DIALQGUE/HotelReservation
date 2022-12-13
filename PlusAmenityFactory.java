public class PlusAmenityFactory {
    public Amenity createFoodAmenity() {
        return new FoodPlus();
    }

    public Amenity createCleaningAmenity() {
        return new CleaningServicePlus();
    }
}