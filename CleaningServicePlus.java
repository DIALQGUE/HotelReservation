import java.util.Date;
import java.text.SimpleDateFormat;

// Object: CleaningServicePlus class
public class CleaningServicePlus extends CleaningService {

    public CleaningServicePlus() {
        super(600);
    }

    public CleaningServicePlus(float price) {
        super(price);
    }

    public CleaningServicePlus(Date time) {
        super(600);
        this.setTime(time);
    }
    
    public CleaningServicePlus(float price, Date time) {
        super(price);
        this.setTime(time);
    }

    @Override
    public String getDescription() {
        SimpleDateFormat format = new SimpleDateFormat("hh:mm");
        return "Cleaning service Plus at " + this.getPrice() + " Baht at " + format.format(this.getTime());
    }

    @Override
    public void makeAppointment()
    {
        System.out.println("What time do you want to get cleaning service plus? (hh.mm)");
        Date time = Input.getTime();
        this.setTime(time);
    }
}
