package complete_reference_examples.working_with_buttons;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ButtonDemo extends Frame {
	private String message = "";
	private final Button button_yes = new Button("YES");
	private final Button button_no = new Button("NO");
	private final Button button_not_decided_yet = new Button("NOT DECIDED YET");

	private final Button[] button_list;

	public ButtonDemo(String title) {
		super(title);

		setLayout(new FlowLayout());
		// version #1
		// button_yes.addActionListener(new ButtonPressed());
		// button_not_decided_yet.addActionListener(new ButtonPressed());
		// button_no.addActionListener(new ButtonPressed());

		button_list = new Button[] {
				(Button) add(button_yes),
				(Button) add(button_not_decided_yet),
				(Button) add(button_no)
		};

		for (Button button : button_list) {
			button.addActionListener(new ButtonPressed());
		}

		// version #1
		// add(button_yes);
		// add(button_not_decided_yet);
		// add(button_no);

		addWindowListener(new WindowCloser());

		setVisible(true);
		setSize(new Dimension(250, 150));

	}

	@Override
	public void paint(Graphics g) {
		g.drawString(message, 20, 100);
	}

	private class ButtonPressed implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent button_pressed_event) {
			// version #1
			// String button_label = button_pressed_event.getActionCommand();

			// message = switch (button_label) {
			// case "YES" -> "You pressed YES button";
			// case "NO" -> "You pressed NO button";
			// case "NOT DECIDED YET" -> "You pressed NOT DECIDED YET button";
			// default -> "Unsupported button pressed";
			// };

			for (Button button : button_list) {
				if (button_pressed_event.getSource() == button) {
					message = "You've pressed " + button.getLabel();
				}
			}
			repaint();
		}

	}

	private class WindowCloser extends WindowAdapter {

		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}

	}

	public static void main(String[] args) {
		new ButtonDemo("Button Demo");
	}
}
