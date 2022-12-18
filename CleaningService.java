import java.util.Date;
import java.text.SimpleDateFormat;
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
        SimpleDateFormat format = new SimpleDateFormat("hh:mm");
        return "Cleaning service at " + this.getPrice() + " Baht at " + format.format(this.getTime());
    }

    public void makeAppointment()
    {
        System.out.println("What time do you want to get cleaning service? (hh.mm)");
        Date time = Input.getTime();
        this.setTime(time);
    }
}