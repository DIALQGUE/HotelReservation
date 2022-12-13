import java.util.Scanner;

public class Transaction {
    Scanner scanner = new Scanner(System.in);
    private float totalPrice;
    private String paymentMethod;

    public  Transaction(float totalPrice, String paymentMethod) {
        this.totalPrice = totalPrice;
        this.paymentMethod = paymentMethod;
    }

    public float getTotalPrice() {
        return this.totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getPaymentMethod() {
        return this.paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    private char getYN() {
        char choice = scanner.next().charAt(0);
        while (choice != 'y' && choice != 'n') {
            System.out.println("Please enter 'y' or 'n' (y = yes | n = no)");
            choice = Character.toLowerCase(scanner.next().charAt(0));
        }
        return choice;
    }

    public boolean confirm() {
        while (true) {
            System.out.println("Do you want to confirm your booking? (y/n)");
            char choice = getYN();
            if (choice == 'y') {
                return true;
            }
            else if (choice == 'n') {
                System.out.println("Do you want to cancel your booking?");
                System.out.println("This process cannot be undone.");
                System.out.println("'y' = Cancel your booking");
                System.out.println("'n' = Not Cancel your booking");
                if (getYN() == 'y') {
                    return false;
                }
            }
        }
    }
}
