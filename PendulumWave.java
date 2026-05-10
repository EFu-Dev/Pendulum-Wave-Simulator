import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PendulumWave extends JPanel {
    private List<Pendulum> pendulums;
    private final int PIVOT_X = 400; 
    private final int PIVOT_Y = 50; 

    public PendulumWave() {
        pendulums = new ArrayList<>();

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of pendulums: ");
        int numPendulums = input.nextInt();

        for (int i = 0; i < numPendulums; i++) {
            double length = 150 + (i * 20); 
            // Start everyone at a 90-degree angle (Math.PI / 2)
            pendulums.add(new Pendulum(length, Math.PI / 2));
        }

        // The "Game Loop" - Runs every 16ms (~60 FPS)
        Timer timer = new Timer(10, e -> {
            for (Pendulum p : pendulums) {
                p.update(0.10); // Update physics
            }
            repaint(); // Redraw the screen
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for (Pendulum p : pendulums) {
            int x = (int) (PIVOT_X + p.length * Math.sin(p.angle));
            int y = (int) (PIVOT_Y + p.length * Math.cos(p.angle));

            // Draw the string
            g2d.setColor(new Color	(80,47,0));
            g2d.drawLine(PIVOT_X, PIVOT_Y, x, y);

            // Draw the ball
            g2d.setColor(new Color(255, 165, 31)); // Steel Blue
            g2d.fillOval(x - 10, y - 10, 20, 20);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Multi-Pendulum Physics Simulator");
        PendulumWave simulation = new PendulumWave();
        
        frame.add(simulation);
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}