package complete_reference_examples.simple_mouse_events_handler;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MouseEventsDemo extends Frame implements MouseMotionListener, MouseListener {

    private String message;
    private int mouseX = 0;
    private int mouseY = 0;

    public static void main(String[] args) {
        new MouseEventsDemo("Mouse Events Demonstration");
    }

    public MouseEventsDemo(String title) {
        super(title);

        addMouseListener(this);
        addMouseMotionListener(this);

        setVisible(true);
        setSize(new Dimension(380, 480));
        setLocation(900, 250);
        setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Downloads\\cursor_icon_1.png"));
        setResizable(false);
        addWindowListener(new WindowCloser());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        message = message + " -- click received";
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        message = "mouse button pressed";
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        message = "mouse button released";
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        mouseX = 120;
        mouseY = 240;
        message = "mouse entered";
        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        mouseX = 120;
        mouseY = 240;
        message = "mouse exited";
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        message = "+ mouse at x=" + mouseX + " y=" + mouseY;
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        message = "moving mouse at x=" + e.getX() + " y=" + e.getY();
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(message, mouseX, mouseY);
    }

    private class WindowCloser extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }
}
