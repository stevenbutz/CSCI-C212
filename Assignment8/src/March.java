import java.awt.geom.Point2D;

public class March {
    private Point2D.Double start;
    private Point2D.Double end;

    public March(double startX, double startY, double endX, double endY) {
        start = new Point2D.Double(startX, startY);
        end = new Point2D.Double(endX, endY);
    }

    // Getter methods for start and end properties
    public Point2D.Double getStart() {
        return start;
    }

    public Point2D.Double getEnd() {
        return end;
    }
}
