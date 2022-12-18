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

    public String getDescription() {
        SimpleDateFormat format = new SimpleDateFormat("hh:mm");
        return "Cleaning service Plus at " + this.getPrice() + " Baht per time at " + format.format(this.getTime());
    }
}
