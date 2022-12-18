// Object: FoodPlus
public class FoodPlus extends Food {

    public FoodPlus() {
        super(300);
    }

    public FoodPlus(float price) {
        super(price);
    }

    @Override
    public String getDescription() {
        return "FoodPlus amenity at " + this.getPrice() + " Baht per set" ;
    }
}
