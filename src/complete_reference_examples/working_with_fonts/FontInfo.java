package complete_reference_examples.working_with_fonts;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FontInfo extends Frame {

    public FontInfo(String title) throws HeadlessException {
        super(title);
		setDefaultFont();
        addWindowListener(new WindowCloser());

		setVisible(true);
		setSize(new Dimension(613, 90));
		setResizable(false);
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
        Font font = g.getFont();

        String fontName = font.getFontName();
        String fontFamily = font.getFamily();
        int fontSize = font.getSize();
        int fontStyle = font.getStyle();

        String message = "Font Family: " + fontFamily;
        message += " Font Name: " + fontName;
        message += " Font Size: " + fontSize;
        message += " Font Style: ";

		// побитовый унарный оператор '&' ('AND')
        if ((fontStyle & Font.BOLD) == Font.BOLD) {
            message += "BOLD";
        } else if ((fontStyle & Font.PLAIN) == Font.PLAIN) {
            message += "PLAIN";
        } else if ((fontStyle & Font.ITALIC) == Font.ITALIC) {
            message += "ITALIC";
        }
		g.drawString(message, 10, 60);
	}

	public static void main(String[] args) {
		new FontInfo("Default Font Information");
	}

	public final void setDefaultFont(){
		Font font = new Font("Candara Light", Font.BOLD, 16);
		this.setFont(font);
	}

}
