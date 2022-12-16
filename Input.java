import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

// Object: Input class
public class Input {
    static Scanner scanner = new Scanner(System.in);
    public Input(){
    }

    // Get y/n (confirm) from user.
    public static boolean getYN(String message) {
        System.out.print(message);
        char choice = scanner.next().charAt(0);
        while (choice != 'y' && choice != 'n') {
            System.out.println("Please enter 'y' or 'n' (y = yes | n = no)");
            choice = Character.toLowerCase(scanner.next().charAt(0));
        }
        if(choice == 'y') return true;
        return false;
    }

    // Get date in correct format.
    public static Date getDate() {
        String dateString;
        Date date = new Date();
        boolean done = false;
        while (!done) {
            dateString = scanner.nextLine();
            try {
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                date = format.parse(dateString);
                done = true;
            } catch (Exception e) {
                System.out.println("Invalid date: " + dateString);
            }
        }
        return date;
    }

    // Get time in correct format.
    public static Date getTime() {
        String timeString;
        Date time = new Date();
        boolean done = false;
        while (!done) {
            scanner.nextLine();
            timeString = scanner.nextLine();
            try {
                SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
                time = format.parse(timeString);
                done = true;
            }
            catch (Exception e) {
                System.out.println("Invalid time: " + timeString);
            }
        }
        return time;
    }
}
