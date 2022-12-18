import java.util.Scanner;

public class Transaction {
    Scanner scanner = new Scanner(System.in);
    private float totalPrice;
    private String paymentMethod;

    public Transaction(float totalPrice, String paymentMethod) {
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

    // Confirm booking
    public boolean confirm() {
        while (true) {
            if (Input.getYN("Do you want to confirm your booking? (y/n): ")) {
                return true;
            }
            else {
                // Confirm cancel booking
                System.out.println("Do you want to cancel your booking?");
                System.out.println("This process cannot be undone.");
                System.out.println("'y' = Cancel your booking");
                System.out.println("'n' = Not Cancel your booking");
                if (Input.getYN("(y/n): ")) {
                    return false;
                }
            }
        }
    }

    public void print() {
        System.out.println("Total price: " + this.totalPrice);
        System.out.println("Payment method: " + this.paymentMethod);
    }
}
