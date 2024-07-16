package complete_reference_examples.layout_dispatchers;

import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Checkbox;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CardLayoutDemo extends Frame {

	private final Checkbox checkbox_windows_10;
	private final Checkbox checkbox_windows_8;
	private final Checkbox checkbox_windows_7;

	private final Checkbox checkbox_mac;
	private final Checkbox checkbox_android;
	private final Checkbox checkbox_linux;

	private final Panel deck_operating_system;
	private final Panel deck_versions_of_windows;
	private final Panel deck_not_windows_os;

	private final CardLayout layout_card;

	private final Button button_windows;
	private final Button button_other;

	public CardLayoutDemo(String title) {
		super(title);

		setLayout(new FlowLayout());

		button_windows = new Button("Windows");
		button_other = new Button("Other");

		add(button_windows);
		add(button_other);

		button_windows.addActionListener(new WindowsButtonPressed());
		button_other.addActionListener(new OtherButtonPressed());

		// getting card layout object
		layout_card = new CardLayout();

		// creating a panel and setting layout as CardLayout
		deck_operating_system = new Panel();
		deck_operating_system.setLayout(layout_card);

		// windows os versions
		checkbox_windows_10 = new Checkbox("Windows 10", true);
		checkbox_windows_8 = new Checkbox("Windows 8");
		checkbox_windows_7 = new Checkbox("Windows 7");

		// other os
		checkbox_android = new Checkbox("Android");
		checkbox_mac = new Checkbox("Mac OS");
		checkbox_linux = new Checkbox("Linux");

		deck_versions_of_windows = new Panel();

		deck_versions_of_windows.add(checkbox_windows_10);
		deck_versions_of_windows.add(checkbox_windows_8);
		deck_versions_of_windows.add(checkbox_windows_7);

		deck_not_windows_os = new Panel();

		deck_not_windows_os.add(checkbox_android);
		deck_not_windows_os.add(checkbox_mac);
		deck_not_windows_os.add(checkbox_linux);

		deck_operating_system.add(deck_versions_of_windows, "Windows");
		deck_operating_system.add(deck_not_windows_os, "Other");

		add(deck_operating_system);

		addMouseListener(new MousePressed());
		addWindowListener(new WindowCloser());

		setVisible(true);
		setFont(new Font("Times New Roman", Font.PLAIN, 16));
		setSize(new Dimension(300, 220));
	}

	private class WindowCloser extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}

	}

	private class WindowsButtonPressed implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			layout_card.show(deck_operating_system, "Windows");
		}

	}

	private class OtherButtonPressed implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			layout_card.show(deck_operating_system, "Other");
		}

	}

	private class MousePressed extends MouseAdapter {

		@Override
		public void mousePressed(MouseEvent e) {
			layout_card.next(deck_operating_system);
		}

	}

	public static void main(String[] args) {
		new CardLayoutDemo("Card Layout demo");
	}
}
