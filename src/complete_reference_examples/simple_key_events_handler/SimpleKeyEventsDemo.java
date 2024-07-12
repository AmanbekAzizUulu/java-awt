package complete_reference_examples.simple_key_events_handler;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SimpleKeyEventsDemo extends Frame implements KeyListener {

    private String message = "";
    private String key_state = "";

    private SimpleKeyEventsDemo(String title) {
        super(title);

        addKeyListener(this);
        addWindowListener(new WindowCloser());

		setSize(new Dimension(400, 200));
		setVisible(true);
		setResizable(true);
		setLocation(900, 380);
		setAlwaysOnTop(true);
    }

    public static void main(String[] args) {
		new SimpleKeyEventsDemo("Simple Key Events Handler");
    }

    @Override
    public void keyTyped(KeyEvent e) {
        message = message + e.getKeyChar();
		repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        key_state = "Key pressed";
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
		key_state = "Key released";
		repaint();
	}

    @Override
    public void paint(Graphics g) {
        g.drawString(message, 20, 100);
        g.drawString(key_state, 20, 50);
    }

    private class WindowCloser extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }
}
