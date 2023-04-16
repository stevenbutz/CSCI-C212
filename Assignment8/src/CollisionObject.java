import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

public abstract class CollisionObject implements Drawable {
    protected double x;
    protected double y;
    protected Color color;

    public CollisionObject(double x, double y) {
        this.x = x;
        this.y = y;
        this.color = new Color((float) Math.random(), (float) Math.random(), (float) Math.random());
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public abstract void drawObject(Graphics2D g2d);
    @Override
    public void mousePressed(MouseEvent e) {
        // Default behavior or make this method abstract if you want the subclasses to implement it
    }
    public abstract double computeDistance(double cameraX, double cameraY);
}

