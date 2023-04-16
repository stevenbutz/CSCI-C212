import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;

public class CircleObject extends CollisionObject {
    private double radius;

    public CircleObject(double x, double y, double radius) {
        super(x, y);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public Ellipse2D.Double getShape() {
        return new Ellipse2D.Double(x - radius, y - radius, radius * 2, radius * 2);
    }
    @Override
    public void drawObject(Graphics2D g2d) {
        g2d.setColor(color);
        g2d.fill(getShape());
    }


    @Override
    public double computeDistance(double cameraX, double cameraY) {
        double dx = x - cameraX;
        double dy = y - cameraY;
        return Math.sqrt(dx * dx + dy * dy) - radius;
    }
}
