import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class RectangleObject extends CollisionObject {
    private double width;
    private double height;

    public RectangleObject(double x, double y, double width, double height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public Rectangle2D.Double getShape() {
        return new Rectangle2D.Double(x - width / 2, y - height / 2, width, height);
    }

    @Override
    public void drawObject(Graphics2D g2d) {
        g2d.setColor(color);
        g2d.fill(getShape());
    }


    @Override
    public double computeDistance(double cameraX, double cameraY) {
        double left = x - width / 2;
        double right = x + width / 2;
        double top = y - height / 2;
        double bottom = y + height / 2;

        Line2D.Double line1 = new Line2D.Double(left, top, right, top);
        Line2D.Double line2 = new Line2D.Double(right, top, right, bottom);
        Line2D.Double line3 = new Line2D.Double(left, bottom, right, bottom);
        Line2D.Double line4 = new Line2D.Double(left, top, left, bottom);

        double minDistance = Math.min(
                Math.min(line1.ptSegDist(cameraX, cameraY), line2.ptSegDist(cameraX, cameraY)),
                Math.min(line3.ptSegDist(cameraX, cameraY), line4.ptSegDist(cameraX, cameraY))
        );

        return minDistance;
    }
}
