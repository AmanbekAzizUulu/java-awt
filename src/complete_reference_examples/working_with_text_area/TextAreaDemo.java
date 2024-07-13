package complete_reference_examples.working_with_text_area;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TextAreaDemo extends Frame {
	private FileInputStream fis;
	private String text;
	private final TextArea textArea;

	public TextAreaDemo(String title) throws HeadlessException {
		super(title);

		textArea = new TextArea(text, 10, 90, TextArea.SCROLLBARS_VERTICAL_ONLY);
		try {
			fis = new FileInputStream(
					"D:\\JavaLanguage\\EducationalProjects_VSCode\\java-awt\\java-awt\\src\\complete_reference_examples\\working_with_text_area\\about_java_language.txt");

			byte[] buffer = new byte[1024];
			int bytesRead;

			while ((bytesRead = fis.read(buffer)) != -1) {
				textArea.append(new String(buffer, 0, bytesRead));
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		add(textArea);

		addWindowListener(new WindowCloser());

		setFont(new Font("Segoe UI", Font.BOLD, 14));
		setLayout(new FlowLayout());
		setVisible(true);
		setSize(new Dimension(800, 500));
	}

	private class WindowCloser extends WindowAdapter {

		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new TextAreaDemo("TextArea Demo");
	}
}
