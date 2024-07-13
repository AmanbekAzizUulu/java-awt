package complete_reference_examples.working_with_awt_list;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AWTListDemo extends Frame {
	private final List list_operating_system;
	private final List list_browser;

	private String message = "";

	public AWTListDemo(String title) {
		super(title);

		list_operating_system = new List(5, true);
		list_browser = new List(5);

		list_operating_system.add("Windows");
		list_operating_system.add("Android");
		list_operating_system.add("Mac OS");
		list_operating_system.add("Linux");

		list_browser.add("Microsoft Edge");
		list_browser.add("Google Chrome");
		list_browser.add("Mozilla FireFox");

		list_operating_system.select(0);
		list_browser.select(1);

		list_operating_system.addActionListener(new ItemFromListSelected());
		list_browser.addActionListener(new ItemFromListSelected());

		add(list_operating_system);
		add(list_browser);

		addWindowListener(new WindowCloser());

		setFont(new Font("Segoe UI", Font.BOLD, 14));
		setLayout(new FlowLayout());
		setVisible(true);
		setSize(new Dimension(400, 200));
		setAlwaysOnTop(true);
	}

	private class ItemFromListSelected implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			repaint();
		}

	}
	private class WindowCloser extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}

	}

	@Override
	public void paint(Graphics g) {
		int[] indexes = list_operating_system.getSelectedIndexes();

		message = "Current OS: ";
		for (int i = 0; i < indexes.length; i++) {
			message += list_operating_system.getItem(indexes[i]) + "  ";
		}
		g.drawString(message, 20, 140);

		message = "Current Browser: ";
		message += list_browser.getSelectedItem();
		g.drawString(message, 20, 160);
	}

	public static void main(String[] args) {
		new AWTListDemo("List Demo");
	}
}
