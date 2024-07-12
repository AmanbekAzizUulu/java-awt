package complete_reference_examples.working_with_checkbox;

import java.awt.Checkbox;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CheckBoxDemo extends Frame {
	private String message = "";

	private final Checkbox checkbox_windows;
	private final Checkbox checkbox_linux;
	private final Checkbox checkbox_android;
	private final Checkbox checkbox_mac;

	public CheckBoxDemo(String title) {
		super(title);

		checkbox_windows = new Checkbox("Windows", true);
		checkbox_linux = new Checkbox("Linux");
		checkbox_mac = new Checkbox("Mac OS");
		checkbox_android = new Checkbox("Android");

		checkbox_linux.addItemListener(new ItemStateMonitor());
		checkbox_mac.addItemListener(new ItemStateMonitor());
		checkbox_windows.addItemListener(new ItemStateMonitor());
		checkbox_android.addItemListener(new ItemStateMonitor());

		setFont(new Font("Segoe UI", Font.BOLD, 14));

		add(checkbox_windows);
		add(checkbox_linux);
		add(checkbox_mac);
		add(checkbox_android);

		setLayout(new FlowLayout());

		addWindowListener(new WindowCloser());

		setSize(new Dimension(307, 250));
		setVisible(true);
	}

	@Override
	public void paint(Graphics g) {
		message = "**** Current state ****";
		g.drawString(message, 20, 120);

		message = "Windows:             " + checkbox_windows.getState();
		g.drawString(message, 20, 160);

		message = "Linux:                    " + checkbox_linux.getState();
		g.drawString(message, 20, 180);

		message = "Mac OS:                " + checkbox_mac.getState();
		g.drawString(message, 20, 200);

		message = "Android:               " + checkbox_android.getState();
		g.drawString(message, 20, 220);
	}

	private class WindowCloser extends WindowAdapter {

		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}

	}

	private class ItemStateMonitor implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			repaint();
		}
	}

	public static void main(String[] args) {
		new CheckBoxDemo("Checkbox Demo");
	}
}
