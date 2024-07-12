package complete_reference_examples.XOR_color_mode_demo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class XORColorModeDemo extends Frame {

    private int cursor_x = 100;
    private int cursor_y = 100;

    public XORColorModeDemo(String title) {
        super(title);

        addMouseMotionListener(new MouseMotionMonitor());
        addWindowListener(new WindowCloser());

        setVisible(true);
        setSize(new Dimension(300, 260));
    }

    public static void main(String[] args) {
        new XORColorModeDemo("XORColor mode demo");
    }

    private class MouseMotionMonitor extends MouseMotionAdapter {

        @Override
        public void mouseMoved(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();

            cursor_x = x - 10;
            cursor_y = y - 10;

            repaint();
        }

    }

    private class WindowCloser extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }

    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(20, 40, 60, 70);

        g.setColor(Color.BLUE);
        g.fillRect(110, 40, 60, 70);

        g.setColor(Color.BLACK);
        g.fillRect(200, 40, 60, 70);

        g.setColor(Color.RED);
        g.fillRect(60, 120, 160, 110);

        g.setXORMode(Color.BLACK);
        g.drawLine(cursor_x - 10, cursor_y, cursor_x + 10, cursor_y);
        g.drawLine(cursor_x, cursor_y - 10, cursor_x, cursor_y + 10);
        g.setPaintMode();
    }
}
