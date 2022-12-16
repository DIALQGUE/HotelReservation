import java.util.Date;
// Object: CleaningService class
public class CleaningService extends Amenity {
    private Date time;

    public CleaningService() {
        super(500);
    }

    public CleaningService(float price) {
        super(price);
    }

    public CleaningService(Date time) {
        super(500);
        this.time = time;
    }
    
    public CleaningService(float price, Date time) {
        super(price);
        this.time = time;
    }

    public Date getTime() {
        return this.time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getDescription() {
        return "Cleaning service at " + this.getPrice() + " Baht per time at " + this.getTime();
    }
}