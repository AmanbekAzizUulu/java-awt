package complete_reference_examples.layout_dispatchers;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Insets;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BorderLayoutWithInsetsDemo extends Frame {

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

	public BorderLayoutWithInsetsDemo(String title) {
		super(title);

		setLayout(new BorderLayout());
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

		setBackground(Color.CYAN);
		setFont(new Font("Consolas", Font.BOLD, 14));
		setVisible(true);
		setSize(new Dimension(480, 300));

	}

	private class WindowCloser extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}

	/*
	 * 	Sometimes, it may be necessary to leave a small space between the container
	 * 	holding the components and the window in which they are located. To achieve
	 * 	this, you need to override the getInsets() method of the Container class.
	 * 	This method returns an object of type Insets, containing the top, bottom,
	 * 	left, and right insets that will be applied when the container is displayed.
	 * 	These values are used by the layout manager to insert components when laying
	 * 	out the window. Here is the constructor for the Insets class:
	 * 	Insets(int top, int left, int bottom, int right)
	 *
	 * 	The values passed to top, left, bottom, and right specify the distances
	 * 	between the container and its surrounding window.
	 */
	@Override
	public Insets getInsets() {
		return new Insets(40, 20, 10, 20);
	}

	public static void main(String[] args) {
		new BorderLayoutWithInsetsDemo("Border Layout Demo");
	}
}
