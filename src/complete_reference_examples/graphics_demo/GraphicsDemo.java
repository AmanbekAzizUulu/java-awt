package complete_reference_examples.graphics_demo;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GraphicsDemo extends Frame {

    public GraphicsDemo(String title) {
        super(title);
        setLayout(new FlowLayout());

        setSize(new Dimension(370, 700));
        setVisible(true);
        setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Downloads\\graphics_demo_icon_1.png"));
        setResizable(false);
        setAlwaysOnTop(true);
        addWindowListener(new WindowCloser());
    }

    private class WindowCloser extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }

    @Override
    public void paint(Graphics g) {
        g.drawLine(20, 40, 100, 90);
        g.drawLine(20, 90, 100, 40);
        g.drawLine(40, 45, 250, 80);
		
        // Вычертить прямоугольники.
        g.drawRect(20, 150, 60, 50);
        g.fillRect(110, 150, 60, 50);
        g.drawRoundRect(200, 150, 60, 50, 15, 15);
        g.fillRoundRect(290, 150, 60, 50, 30, 40);

        // Вычертить эллипсы и окружности.
        g.drawOval(20, 250, 50, 50);
        g.fillOval(100, 250, 75, 50);
        g.drawOval(200, 260, 100, 40);

        // Вычертить дуги.
        g.drawArc(20, 350, 70, 70, 0, 180);
        g.fillArc(70, 350, 70, 70, 0, 75);

        // Вычертить многоугольник .
        int[] xpoints = {20, 200, 20, 200, 20};
        int[] ypoints = {450, 450, 650, 650, 450};
        int nums = 5;
        g.drawPolygon(xpoints, ypoints, nums);
    }

    public static void main(String[] args) {
        new GraphicsDemo("Graphics Demo");
    }
}
