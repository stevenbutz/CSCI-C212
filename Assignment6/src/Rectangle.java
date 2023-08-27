public class Rectangle {
    private int width;
    private int length;
    public Rectangle(int width, int length){
        if (width < 0) {
            throw new IllegalArgumentException("width must be positive");
        }
        if (length < 0) {
            throw new IllegalArgumentException("length must be positive");
        }
        this.width = width;
        this.length = length;
    }
    public String printShape() {
        return getShape(length);
    }
    private String getShape(int n) {
        if (n <= 0) {
            return "";
        }
        return getShape(n - 1) + "*".repeat(width) + "\n";
    }

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(3,2);
        System.out.println(rectangle.printShape());
    }
}
