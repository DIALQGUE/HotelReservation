public abstract class Amenity {
    private float price;

    public Amenity() {}

    public Amenity(float price) {
        this.price = price;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public abstract String getDescription();

}