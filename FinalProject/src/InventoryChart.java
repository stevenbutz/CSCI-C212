import javax.swing.*;
import java.awt.*;

public class InventoryChart {
    private String title;
    private int[] stats;

    public InventoryChart(String title, int[] stats) {
        this.title = title;
        this.stats = stats;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int[] getStats() {
        return stats;
    }

    public void setStats(int[] stats) {
        this.stats = stats;
    }

    public void displayGraph() {
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        try {
            JProgressBar fictionBar = new JProgressBar(0, stats[0]);
            fictionBar.setValue(stats[0]);
            fictionBar.setStringPainted(true);
            fictionBar.setForeground(Color.BLUE);
            JLabel fictionLabel = new JLabel("Fiction Books: " + stats[0]);

            JProgressBar nonfictionBar = new JProgressBar(0, stats[1]);
            nonfictionBar.setValue(stats[1]);
            nonfictionBar.setStringPainted(true);
            nonfictionBar.setForeground(Color.RED);
            JLabel nonfictionLabel = new JLabel("Non-fiction Books: " + stats[1]);

            JPanel panel = new JPanel(new GridLayout(2, 2));
            panel.add(fictionLabel);
            panel.add(fictionBar);
            panel.add(nonfictionLabel);
            panel.add(nonfictionBar);

            frame.add(panel, BorderLayout.CENTER);

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
