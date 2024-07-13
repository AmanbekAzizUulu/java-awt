package complete_reference_examples.layout_dispatchers;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BorderLayoutDemo extends Frame {
	private final String message = """

				The reasonable man adapts
				himself to the world;

				the unreasonable one persists in
				trying to adapt the world to himself

				Therefore all progress depends
				on the unreasonable man.


						--- George Bernard Shaw
			""";
	private final Button button_top;
	private final Button button_right;
	private final Button button_left;

	private final Label label_bottom;

	private final TextArea textArea_center;

	public BorderLayoutDemo(String title) {
		super(title);

		button_top = new Button("This is across the top");
		button_left = new Button("Left");
		button_right = new Button("Right");
		label_bottom = new Label("The footer message might go here");
		textArea_center = new TextArea(message, -1, -1, TextArea.SCROLLBARS_NONE);

		add(button_top, BorderLayout.NORTH);
		add(button_left, BorderLayout.WEST);
		add(button_right, BorderLayout.EAST);
		add(label_bottom, BorderLayout.SOUTH);
		add(textArea_center, BorderLayout.CENTER);

		addWindowListener(new WindowCloser());

		setResizable(false);
		setFont(new Font("Consolas", Font.BOLD, 14));
		setVisible(true);
		setSize(new Dimension(450, 300));

	}

	private class WindowCloser extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new BorderLayoutDemo("Border Layout Demo");
	}
}
