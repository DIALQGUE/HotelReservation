import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.text.SimpleDateFormat;
// Object: Booking class
public class Booking {
    private ArrayList<Guest> guestList;
    private Date dateCheckIn;
    private Date dateCheckOut;
    private Room room;
    private Transaction transaction;

    public Booking(ArrayList<Guest> guestList, Date dateCheckIn, Date dateCheckOut, Room room, Transaction transaction) {
        this.guestList = guestList;
        this.dateCheckIn = dateCheckIn;
        this.dateCheckOut = dateCheckOut;
        this.room = room;
        this.transaction = transaction;
    }

    public ArrayList<Guest> getGuestList() {
        return this.guestList;
    }

    public void setGuestList(ArrayList<Guest> guestList) {
        this.guestList = guestList;
    }

    public void addGuest(Guest guest) {
        this.guestList.add(guest);
    }

    public Date getDateCheckIn() {
        return this.dateCheckIn;
    }

    public void setDateCheckIn(Date dateCheckIn) {
        this.dateCheckIn = dateCheckIn;
    }

    public Date getDateCheckOut() {
        return this.dateCheckOut;
    }

    public void setDateCheckOut(Date dateCheckOut) {
        this.dateCheckOut = dateCheckOut;
    }

    public Room getRoom() {
        return this.room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Transaction getTransaction() {
        return this.transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public void print() {
        for (int i = 0; i < this.guestList.size(); i++) {
            System.out.println("====================");
            System.out.println("Guest No. " + (i + 1) + ":");
            guestList.get(i).print();
        }
        System.out.println("====================\n");
        SimpleDateFormat dateFormat = new SimpleDateFormat("E, dd MMMM yyyy", new Locale("en", "TH"));
        System.out.println("Check-In Date: " + dateFormat.format(this.dateCheckIn));
        System.out.println("Check-Out Date: " + dateFormat.format(this.dateCheckOut));
        room.print();
        transaction.print();
    }
}
