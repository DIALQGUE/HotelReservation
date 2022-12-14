public class Bed {
    private String size;

    public Bed() {
        this.size = "Single";
    }

    public Bed(String size) {
        this.size = size;
    }

    public String getSize() {
        return this.size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void print() {
        System.out.println(size + "-Sized Bed");
    }
}