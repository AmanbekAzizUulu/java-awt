package complete_reference_examples.working_with_text_fields;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TextFieldsDemo extends Frame {

	private final TextField textField_user_password;
	private final TextField textField_user_name;

	private final Label label_user_name;
	private final Label label_user_password;

	public TextFieldsDemo(String title) throws HeadlessException {
		super(title);

		label_user_name = new Label("User name: ", Label.RIGHT);
		label_user_password = new Label("User password: ", Label.RIGHT);

		textField_user_name = new TextField(12);

		textField_user_password = new TextField(9);
		textField_user_password.setEchoChar('*');

		textField_user_name.addActionListener(new TextFieldEnterPressed());
		textField_user_password.addActionListener(new TextFieldEnterPressed());

		add(label_user_name);
		add(textField_user_name);

		add(label_user_password);
		add(textField_user_password);

		addWindowListener(new WindowCloser());
		setFont(new Font("Segoe UI", Font.BOLD, 14));
		setLayout(new FlowLayout());
		setVisible(true);
		setSize(new Dimension(500, 200));
	}

	private class WindowCloser extends WindowAdapter {

		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}

	}

	private class TextFieldEnterPressed implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			repaint();
		}

	}

	public static void main(String[] args) {
		new TextFieldsDemo("TextField Demo");
	}

	@Override
	public void paint(Graphics g) {
		g.drawString("User Name: " + textField_user_name.getText(), 20, 120);
		g.drawString("Selected text in 'user_name' text field: " + textField_user_name.getSelectedText(), 20, 140);

		g.drawString("User password: " + textField_user_password.getText(), 20, 160);
	}
}
