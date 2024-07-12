package complete_reference_examples.working_with_choice;

import java.awt.Choice;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ChoiceDemo extends Frame {
	private final Choice choice_operationg_system;
	private final Choice choice_browser;

	private String message;

	public ChoiceDemo(String title) {
		super(title);

		setLayout(new FlowLayout());
		setFont(new Font("Segoe UI", Font.BOLD, 14));

		choice_browser = new Choice();
		choice_operationg_system = new Choice();

		choice_browser.add("Google Chrome");
		choice_browser.add("Microsoft Edge");
		choice_browser.add("Mozilla FireFox");

		choice_operationg_system.add("Android");
		choice_operationg_system.add("Windows");
		choice_operationg_system.add("Mac OS");
		choice_operationg_system.add("Linux");

		choice_browser.addItemListener(new ChoiceMade());
		choice_operationg_system.addItemListener(new ChoiceMade());

		add(choice_browser);
		add(choice_operationg_system);

		addWindowListener(new WindowCloser());

		setVisible(true);
		setSize(new Dimension(340, 200));
	}

	@Override
	public void paint(Graphics g) {
		message = "Current operationg System: ";
		message += choice_operationg_system.getSelectedItem();
		g.drawString(message, 20, 150);

		message = "Current browser: ";
		message += choice_browser.getSelectedItem();
		g.drawString(message, 20, 170);
	}

	public static void main(String[] args) {
		new ChoiceDemo("Choice Demo");
	}

	private class WindowCloser extends WindowAdapter {

		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}

	}

	private class ChoiceMade implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			repaint();
		}

	}
}
