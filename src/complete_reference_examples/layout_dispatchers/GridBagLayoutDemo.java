package complete_reference_examples.layout_dispatchers;

import java.awt.Checkbox;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GridBagLayoutDemo extends Frame {
	private GridBagLayout layout_grid_bag_layout;
	private GridBagConstraints constraints;

	private String message = "";
	private Checkbox checkbox_windows;
	private Checkbox checkbox_linux;
	private Checkbox checkbox_android;
	private Checkbox checkbox_mac_os;

	public GridBagLayoutDemo(String title) {
		super(title);

		// Initialize GridBagLayout and GridBagConstraints
		layout_grid_bag_layout = new GridBagLayout();
		constraints = new GridBagConstraints();

		// Set the layout manager for this frame
		setLayout(layout_grid_bag_layout);

		// Initialize checkboxes
		checkbox_windows = new Checkbox("Windows", true);
		checkbox_android = new Checkbox("Android");
		checkbox_linux = new Checkbox("Linux");
		checkbox_mac_os = new Checkbox("Mac OS");

		// Add listeners to handle checkbox selection events
		checkbox_windows.addItemListener(new ItemStateChanged());
		checkbox_android.addItemListener(new ItemStateChanged());
		checkbox_linux.addItemListener(new ItemStateChanged());
		checkbox_mac_os.addItemListener(new ItemStateChanged());

		// Set layout constraints for checkbox_windows
		constraints.weightx = 1.0; 																	// Distribute extra horizontal space
		constraints.weighty = 0.0; 																	// No extra vertical space
		constraints.ipadx = 100; 																	// Internal padding
		constraints.insets = new Insets(0, 6, 0, 0); 							// External padding
		constraints.anchor = GridBagConstraints.NORTHWEST; 											// Anchor to the top-left
		constraints.gridwidth = GridBagConstraints.RELATIVE; 										// End of row
		layout_grid_bag_layout.setConstraints(checkbox_windows, constraints);

		// Set layout constraints for checkbox_linux
		constraints.weightx = 1.0;
		constraints.weighty = 1.0; 																	// Distribute extra vertical space
		constraints.ipadx = 100;
		constraints.insets = new Insets(0, 6, 0, 0);
		constraints.anchor = GridBagConstraints.NORTHWEST;
		constraints.gridwidth = GridBagConstraints.RELATIVE;
		layout_grid_bag_layout.setConstraints(checkbox_linux, constraints);

		// Set layout constraints for checkbox_android
		constraints.weightx = 1.0;
		constraints.weighty = 0.0;
		constraints.ipadx = 0;
		constraints.insets = new Insets(0, 0, 0, 0); 							// Reset external padding
		constraints.anchor = GridBagConstraints.NORTHWEST;
		constraints.gridwidth = GridBagConstraints.REMAINDER; 										// End of row
		layout_grid_bag_layout.setConstraints(checkbox_android, constraints);

		// Set layout constraints for checkbox_mac_os
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;
		constraints.ipadx = 0;
		constraints.insets = new Insets(0, 0, 0, 0);
		constraints.anchor = GridBagConstraints.NORTHWEST;
		constraints.gridwidth = GridBagConstraints.REMAINDER;
		layout_grid_bag_layout.setConstraints(checkbox_mac_os, constraints);

		// Add checkboxes to the frame
		add(checkbox_windows);
		add(checkbox_android);
		add(checkbox_linux);
		add(checkbox_mac_os);

		// Add window listener to handle window closing event
		addWindowListener(new WindowCloser());

		// Set frame properties
		setFont(new Font("Segoe UI", Font.BOLD, 16));
		setVisible(true);
		setSize(new Dimension(300, 205));
	}

	private class WindowCloser extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0); 																	// Exit the application when the window is closed
		}
	}

	public static void main(String[] args) {
		new GridBagLayoutDemo("GridBag layout demo"); 										// Create and display the frame
	}

	@Override
	public void paint(Graphics g) {
		// Draw the current state of checkboxes
		message = "Current state";
		g.drawString(message, 20, 100);

		message = "Windows:" + " ".repeat(13) + checkbox_windows.getState();
		g.drawString(message, 30, 120);

		message = "Android:" + " ".repeat(15) + checkbox_android.getState();
		g.drawString(message, 30, 140);

		message = "Linux:" + " ".repeat(20) + checkbox_linux.getState();
		g.drawString(message, 30, 160);

		message = "Mac OS:" + " ".repeat(16) + checkbox_mac_os.getState();
		g.drawString(message, 30, 180);
	}

	private class ItemStateChanged implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent e) {
			repaint(); 																				// Repaint the frame when a checkbox state changes
		}
	}
}
