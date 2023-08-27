public class Triangle {
    private int length;
    public Triangle(int length){
        if (length < 0) {
            throw new IllegalArgumentException("length must be positive");
        }
        this.length = length;
    }
    public String printShape() {
        return getShape(length);
    }

    private String getShape(int n) {
        if (n <= 0) {
            return "";
        }
        return getShape(n - 1) + "*".repeat(n) + "\n";
    }

}
