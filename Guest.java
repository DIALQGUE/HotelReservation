// Object: Guest class
public class Guest {
    private String fullName;
    private String phone;
    private String email;

    public Guest(String fullName, String phone, String email) {
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void print() {
        System.out.println("Name: " + this.fullName);
        System.out.println("Phone: " + this.phone);
        System.out.println("Email: " + this.email);
    }
}
