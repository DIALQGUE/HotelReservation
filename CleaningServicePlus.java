public class CleaningServicePlus extends Amenity{
    private int time;

    public CleaningServicePlus() {
        super(600);
    }

    public CleaningServicePlus(float price) {
        super(price);
    }

    public CleaningServicePlus(int time) {
        super(600);
        this.time = time;
    }
    
    public CleaningServicePlus(float price, int time) {
        super(price);
        this.time = time;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String printTime() {
        return "24:00:00";
    }

    public String getDescription() {
        return "Cleaning service at " + this.getPrice() + " baht per time at " + this.getTime();
    }
}
