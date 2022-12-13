public class FoodPlus extends Amenity {

    public FoodPlus() {
        super(300);
    }

    public FoodPlus(float price) {
        super(price);
    }

    public String getDescription() {
        return "FoodPlus amenity at " + this.getPrice() + "Baht per time" ;
    }

}
