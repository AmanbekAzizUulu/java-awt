package complete_reference_examples.working_with_fonts;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MultiLineOutputDemo extends Frame {

    private int cursorX = 20;
    private int cursorY = 40;

    public MultiLineOutputDemo(String title) throws HeadlessException {
        super(title);

        // Add WindowsListener
        addWindowListener(new WindowCloser());

        // Setting default Font
        Font defaultFont = new Font("SansSerif", Font.PLAIN, 14);
        setFont(defaultFont);

        setVisible(true);
        setSize(new Dimension(450, 150));
        setAlwaysOnTop(true);
    }

    private class WindowCloser extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }

    @Override
    public void paint(Graphics g) {
		nextLine("This is on the line number 1", g);
		nextLine("This is on the line number 2", g);

		sameLine(" This is on the same line", g);
		sameLine(" This is too.", g);

		nextLine("This is on the third line", g);

		cursorX = 20;
		cursorY = 40;
    }

    public void nextLine(String str, Graphics g) {
        FontMetrics fm = g.getFontMetrics();

        cursorY += fm.getHeight();
        cursorX = 20;
        g.drawString(str, cursorX, cursorY);

        cursorX += fm.stringWidth(str);
    }

	public void sameLine (String str, Graphics g){
		FontMetrics fm = g.getFontMetrics();

		g.drawString(str, cursorX, cursorY);
		cursorX += fm.stringWidth(str);
	}

	public static void main(String[] args) {
		new MultiLineOutputDemo("Multi Line Output");
	}

}
