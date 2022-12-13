public class Food extends Amenity {

    public Food() {
        super(200);
    }

    public Food(float price) {
        super(price);
    }

    public String getDescription() {
        return "Food amenity at " + this.getPrice() + "Baht per time" ;
    }

}
