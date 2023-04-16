import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

public interface Drawable {
    void drawObject(Graphics2D g2d);

    void mousePressed(MouseEvent e);

}