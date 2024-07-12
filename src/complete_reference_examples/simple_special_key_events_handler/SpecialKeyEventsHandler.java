package complete_reference_examples.simple_special_key_events_handler;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SpecialKeyEventsHandler extends Frame implements KeyListener {

    private String key_state = "";
    private String message = "";

    public SpecialKeyEventsHandler(String title) {
        super(title);
        Label label_1 = new Label("Press any of these keys: ");
        Label label_2 = new Label("F1");
        Label label_3 = new Label("F2");
        Label label_4 = new Label("F3");
        Label label_5 = new Label("Page  Up");
        Label label_6 = new Label("Page Down");
        Label label_7 = new Label("->");
        Label label_8 = new Label("<-");

        addKeyListener(this);
        addWindowListener(new WindowCloser());

        setSize(new Dimension(600, 200));
        setVisible(true);
        setAlwaysOnTop(true);
        setLocation(900, 250);

        this.add(label_1);
        this.add(label_2);
        this.add(label_3);
        this.add(label_4);
        this.add(label_5);
        this.add(label_6);
        this.add(label_7);
        this.add(label_8);

        this.setLayout(new FlowLayout());
    }

    @Override
    public void keyTyped(KeyEvent e) {
        message = message + e.getKeyChar();
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        key_state = "Key pressed";
        int key_code = e.getKeyCode();

        message = switch (key_code) {
            case KeyEvent.VK_F1 ->
                message + "<F1>";
            case KeyEvent.VK_F2 ->
                message + "<F2>";
            case KeyEvent.VK_F3 ->
                message + "<F3>";
            case KeyEvent.VK_PAGE_UP ->
                message + "<PAGE UP>";
            case KeyEvent.VK_PAGE_DOWN ->
                message + "<PAGE DOWN>";
            case KeyEvent.VK_LEFT ->
                message + "<LEFT ARROW>";
            case KeyEvent.VK_RIGHT ->
                message + "<RIGHT ARROW>";
            default ->
                message + "< Unsupported key event >";
        };
        repaint();

    }

    @Override
    public void keyReleased(KeyEvent e) {
        key_state = "Key released";
        repaint();
    }

    public static void main(String[] args) {
        new SpecialKeyEventsHandler("Special Key Events Handler");
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(message, 20, 150);
        g.drawString(key_state, this.getWidth() / 2 - 50, 100);
    }

    private class WindowCloser extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }
}
