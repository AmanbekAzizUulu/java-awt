package complete_reference_examples.working_with_checkbox;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CheckboxGroupDemo extends Frame {
	private String message = "";
	private final Checkbox checkbox_windows;
	private final Checkbox checkbox_android;
	private final Checkbox checkbox_linux;
	private final Checkbox checkbox_mac_os;
	private final Button button_1;
	private CheckboxGroup checkboxGroup_1;

	public CheckboxGroupDemo(String title) throws HeadlessException {
		super(title);

		setLayout(new FlowLayout());
		setFont(new Font("Segoe UI", Font.BOLD, 14));

		checkboxGroup_1 = new CheckboxGroup();
		button_1 = new Button("SUBMIT SELECTION");

		checkbox_windows = new Checkbox("Windows", checkboxGroup_1, false);
		checkbox_android = new Checkbox("Android", checkboxGroup_1, false);
		checkbox_linux = new Checkbox("Linux", checkboxGroup_1, false);
		checkbox_mac_os = new Checkbox("Mac OS", checkboxGroup_1, false);

		checkbox_windows.addItemListener(new CheckboxSelected());
		checkbox_android.addItemListener(new CheckboxSelected());
		checkbox_linux.addItemListener(new CheckboxSelected());
		checkbox_mac_os.addItemListener(new CheckboxSelected());

		button_1.addActionListener(new ButtonPressed());

		add(checkbox_android);
		add(checkbox_linux);
		add(checkbox_mac_os);
		add(checkbox_windows);
		add(button_1);

		addWindowListener(new WindowCloser());

		setVisible(true);
		setSize(new Dimension(350, 166));
	}

	private class WindowCloser extends WindowAdapter {

		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}

	}

	private class CheckboxSelected implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			repaint();
		}
	}

	@Override
	public void paint(Graphics g) {
		// message = "Current selection: ";

		// message += checkboxGroup_1.getSelectedCheckbox().getLabel();
		g.drawString(message, 20, 120);
	}

	public static void main(String[] args) {
		new CheckboxGroupDemo("Checkbox Group Demo");
	}

	private class ButtonPressed implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Checkbox selectedCheckbox;
			if ((selectedCheckbox = checkboxGroup_1.getSelectedCheckbox()) == null) {
				message = "Options not selected yet";
			} else {
				message = "You've selected: " + selectedCheckbox.getLabel();
			}
			repaint();
		}

	}
}
