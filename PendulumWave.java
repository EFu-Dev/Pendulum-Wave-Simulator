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
            double length = 150 + (i * 12); 
            pendulums.add(new Pendulum(length, Math.PI / 2)); // Start everyone at a 90-degree angle (Math.PI / 2)
        }

        // Every 10 ms (100 FPS)
        Timer timer = new Timer(10, e -> {
            for (Pendulum p : pendulums) {
                p.update(0.10); // Update physics
            }
            repaint(); // Redraw the screen
        });
        timer.start();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int colorIndex = 0;
        int colorFlip = 1;
        for (int i = pendulums.size()-1 ; i >= 0; i--) {
            Pendulum p = pendulums.get(i); // this makes it so the longest pendulum renders first
            
            int x = (int) (PIVOT_X + p.length * Math.sin(p.angle));
            int y = (int) (PIVOT_Y + p.length * Math.cos(p.angle));

            // Draw the string
            g2d.setColor(new Color	(80,47,0));
            g2d.drawLine(PIVOT_X, PIVOT_Y, x, y);

            if (colorIndex >= 245){
                colorFlip = -1;
            }
            else if (colorIndex <= 0){
                colorFlip = 1;
            }
            colorIndex += colorFlip * 10;
            
            // Draw the ball
            g2d.setColor(new Color(colorIndex, 165, 31));
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
