public class CleaningService extends Amenity {
    private int time;

    public CleaningService() {
        super(500);
    }

    public CleaningService(float price) {
        super(price);
    }

    public CleaningService(int time) {
        super(500);
        this.time = time;
    }
    
    public CleaningService(float price, int time) {
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