package complete_reference_examples.working_with_fonts;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FontsAvailableDemo extends Frame {

    private String message = "| ";
    private final GraphicsEnvironment graphicsEnvironment;

    public FontsAvailableDemo(String title) throws HeadlessException {
        super(title);
        addWindowListener(new WindowCloser());
        add(new Label("First 5 Fonts"));
        setLayout(new FlowLayout());
        graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();

        String fontList[];
        fontList = graphicsEnvironment.getAvailableFontFamilyNames();

        for (int i = 0; (i < 5) && (i < fontList.length); i++) {
            message += fontList[i] + " | ";
        }
		try (FileOutputStream fos = new FileOutputStream(new File("D:\\JavaLanguage\\EducationalProjects_VSCode\\java-awt\\java-awt\\src\\complete_reference_examples\\working_with_fonts\\available_fonts.txt"))) {
			for (String font : fontList) {
				fos.write((font + "\n").getBytes());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}


        setVisible(true);
        setSize(new Dimension(500, 100));
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(message, 10, 80);
    }

    private class WindowCloser extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }

    }

    public static void main(String[] args) {
        new FontsAvailableDemo("Fonts");
    }
}
