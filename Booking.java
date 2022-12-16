import java.util.ArrayList;
import java.util.Date;
// Object: Booking class
public class Booking {
    private ArrayList<Guest> host;
    private Date dateCheckIn;
    private Date dateCheckOut;
    private Room room;
    private Transaction transaction;

    public Booking(ArrayList<Guest> host, Date dateCheckIn, Date dateCheckOut, Room room, Transaction transaction) {
        this.host = host;
        this.dateCheckIn = dateCheckIn;
        this.dateCheckOut = dateCheckOut;
        this.room = room;
        this.transaction = transaction;
    }

    public ArrayList<Guest> getHost() {
        return this.host;
    }

    public void setHost(ArrayList<Guest> host) {
        this.host = host;
    }

    public void addHost(Guest guest) {
        this.host.add(guest);
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
        for (int i = 0; i < this.host.size(); i++) {
            System.out.println("Host " + i + ":");
            host.get(i).print();
        }
        System.out.println("Check-In Date: " + this.dateCheckIn);
        System.out.println("Check-Out Date: " + this.dateCheckOut);
        room.print();
        transaction.print();
    }
}
