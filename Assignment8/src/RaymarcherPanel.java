import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Random;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.swing.JPanel;

public class RaymarcherPanel extends JPanel {

    private final RaymarcherRunner raymarcherRunner;
    private final ArrayList<CollisionObject> collisionObjects; // Changed the variable name here
    private Camera camera;

    public RaymarcherPanel(RaymarcherRunner raymarcherRunner) {
        this.raymarcherRunner = raymarcherRunner;
        this.setPreferredSize(new Dimension(this.raymarcherRunner.getFrame().getWidth(),
                this.raymarcherRunner.getFrame().getHeight()));

        collisionObjects = new ArrayList<>(); // Changed the variable name here
        populateObjects();
        camera = new Camera(raymarcherRunner.getFrame().getWidth() / 2, raymarcherRunner.getFrame().getHeight() / 2);
        this.addMouseMotionListener(camera);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    camera.incrementAngle();
                } else if (e.getButton() == MouseEvent.BUTTON3) {
                    camera.decrementAngle();
                }
            }});
    }

    private void populateObjects() {
        Random random = new Random();
        int numObjects = 20;

        for (int i = 0; i < numObjects; i++) {
            double x = random.nextDouble() * (getPreferredSize().width - 1) + 1;
            double y = random.nextDouble() * (getPreferredSize().height - 1) + 1;


            double size1 = random.nextDouble() * (100 - 30) + 30;
            double size2 = random.nextDouble() * (100 - 30) + 30;

            if (random.nextBoolean()) {
                // Create a RectangleObject
                collisionObjects.add(new RectangleObject(x, y, size1, size2)); // Changed the variable name here
            } else {
                // Create a CircleObject
                collisionObjects.add(new CircleObject(x, y, size1 / 2)); // Changed the variable name here
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        // Clear the background
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        // Draw collision objects
        for (CollisionObject obj : collisionObjects) {
            obj.drawObject(g2d);
        }

        // Draw the camera
        camera.drawObject(g2d);

        ArrayList<March> marches = march();
        g2d.setColor(Color.RED);
        for (March march : marches) {
            Point2D.Double start = march.getStart();
            Point2D.Double end = march.getEnd();
            g2d.drawLine((int) start.getX(), (int) start.getY(), (int) end.getX(), (int) end.getY());

            double minDistance = Double.MAX_VALUE;
            for (CollisionObject obj : collisionObjects) {
                double distance = obj.computeDistance(end.getX(), end.getY());
                minDistance = Math.min(minDistance, distance);
            }

            double radius = minDistance;
            double diameter = radius * 2;
            g2d.drawOval((int) (end.getX() - radius), (int) (end.getY() - radius), (int) diameter, (int) diameter);
        }
    }
    public ArrayList<March> march() {
        ArrayList<March> marches = new ArrayList<>();
        Point2D.Double currentPoint = new Point2D.Double(camera.getX(), camera.getY());
        double threshold = 0.01;
        int maxIterations = 1000;
        int iterationCount = 0;

        do {
            double minDistance = Double.MAX_VALUE;
            for (CollisionObject obj : collisionObjects) {
                double distance = obj.computeDistance(currentPoint.getX(), currentPoint.getY());
                minDistance = Math.min(minDistance, distance);
            }

            if (minDistance < threshold) {
                break;
            }

            double marchLength = minDistance * 2;
            double marchEndX = currentPoint.getX() + marchLength * Math.cos(Math.toRadians(camera.getAngle()));
            double marchEndY = currentPoint.getY() + marchLength * Math.sin(Math.toRadians(camera.getAngle()));

            marches.add(new March(currentPoint.getX(), currentPoint.getY(), marchEndX, marchEndY));

            currentPoint.setLocation(marchEndX, marchEndY);

            // Terminate the loop if the point goes beyond the screen
            if (currentPoint.getX() < 0 || currentPoint.getX() > getWidth() || currentPoint.getY() < 0 || currentPoint.getY() > getHeight()) {
                break;
            }

            iterationCount++;
        } while (iterationCount < maxIterations);

        return marches;
    }

}
