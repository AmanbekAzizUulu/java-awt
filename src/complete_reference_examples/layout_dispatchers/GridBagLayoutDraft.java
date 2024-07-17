package complete_reference_examples.layout_dispatchers;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// class where I tried to learn GridBagLayout in practice
public class GridBagLayoutDraft extends Frame {
	private GridBagConstraints constraints_grid_bag = new GridBagConstraints();
	private Button button_1;
	private Button button_2;
	private Button button_3;
	private Button button_4;
	private Button button_5;
	private Button button_6;
	private Button button_7;

	public GridBagLayoutDraft(String title) {
		super(title);
		setLayout(new GridBagLayout());

		button_1 = new Button("BUTTON_1");
		button_2 = new Button("BUTTON_2");
		button_3 = new Button("BUTTON_3");
		button_4 = new Button("BUTTON_4");
		button_5 = new Button("BUTTON_5");
		button_6 = new Button("BUTTON_6");
		button_7 = new Button("BUTTON_7");
		constraints_grid_bag.insets = new Insets(5, 5, 5, 5);

		constraints_grid_bag.gridx = 0;
		constraints_grid_bag.gridy = 0;
		add(button_1, constraints_grid_bag);

		constraints_grid_bag.gridx = 1;
		constraints_grid_bag.gridy = 0;
		add(button_2, constraints_grid_bag);

		constraints_grid_bag.gridx = 2;
		constraints_grid_bag.gridy = 0;
		add(button_3, constraints_grid_bag);

		constraints_grid_bag.gridx = 0;
		constraints_grid_bag.gridy = 1;
		add(button_4, constraints_grid_bag);

		constraints_grid_bag.gridx = 1;
		constraints_grid_bag.gridy = 1;
		constraints_grid_bag.gridwidth = GridBagConstraints.REMAINDER;
		constraints_grid_bag.fill = GridBagConstraints.HORIZONTAL;
		add(button_5, constraints_grid_bag);

		// constraints_grid_bag.gridx = 2;
		// constraints_grid_bag.gridy = 1;
		// add(button_6, constraints_grid_bag);


		constraints_grid_bag.gridx = 0;
		constraints_grid_bag.gridy = 2;
		constraints_grid_bag.gridwidth = GridBagConstraints.REMAINDER;
		constraints_grid_bag.fill = GridBagConstraints.HORIZONTAL;
		add(button_7, constraints_grid_bag);

		addWindowListener(new WindowCloser());
		setBackground(Color.CYAN);
		setVisible(true);
		setSize(300, 300);
	}

	public class WindowCloser extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}

	// @Override
	// public Insets getInsets() {
	// return new Insets(0, 0, 0,0);
	// }

	public static void main(String[] args) {
		new GridBagLayoutDraft("Grid Layout Demo");
	}

}
