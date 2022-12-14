import java.util.Date;
import java.text.SimpleDateFormat;

public class CleaningServicePlus extends Amenity{
    private Date time;

    public CleaningServicePlus() {
        super(600);
    }

    public CleaningServicePlus(float price) {
        super(price);
    }

    public CleaningServicePlus(Date time) {
        super(600);
        this.time = time;
    }
    
    public CleaningServicePlus(float price, Date time) {
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
        return "Cleaning service Plus at " + this.getPrice() + " Baht per time at " + format.format(this.getTime());
    }
}
