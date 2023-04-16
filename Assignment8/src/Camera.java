import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;

public class Camera implements Drawable, MouseMotionListener {
    private double x;
    private double y;
    private final double radius = 10;
    private double angle;

    public Camera(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Shape getShape() {
        return new Ellipse2D.Double(x - radius, y - radius, radius * 2, radius * 2);
    }

    @Override
    public void drawObject(Graphics2D g2d) {
        g2d.setColor(Color.RED);
        g2d.fill(getShape());
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // Not needed for this implementation
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        x = e.getX();
        y = e.getY();
    }
    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            angle++;
        } else if (e.getButton() == MouseEvent.BUTTON3) {
            angle--;
        }
    }
    public void incrementAngle() {
        angle++;
    }

    public void decrementAngle() {
        angle--;
    }


    public double getAngle() {
        return angle;
    }
}

