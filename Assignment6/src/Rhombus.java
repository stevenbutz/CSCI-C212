public class Rhombus {
    private int height;
    public Rhombus(int height) {
        if (height % 2 == 0) {
            throw new IllegalArgumentException("Height must be an odd number");
        }
        if (height < 0) {
            throw new IllegalArgumentException("Height must be positive");
        }
        this.height = height;
    }
    public String printShape() {
        return getUpperShape(1,(height-1)/2) + getLowerShape(height-2,1);
    }

    private String getUpperShape(int n, int padding) {
        if (padding == -1) {
            return "";
        }
        String line = " ".repeat(padding) + "*".repeat(n) + " ".repeat(padding) + "\n";
        return line + getUpperShape(n + 2,padding-1);
    }
    private String getLowerShape(int n, int padding) {
        if (n < 1) {
            return "";
        }
        String line = " ".repeat(padding) + "*".repeat(n) + " ".repeat(padding) + "\n";
        return line + getLowerShape(n - 2,padding + 1);
    }
}
