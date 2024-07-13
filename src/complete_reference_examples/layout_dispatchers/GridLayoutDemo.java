package complete_reference_examples.layout_dispatchers;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GridLayoutDemo extends Frame {
	private final int num_of_rows_columns = 4;

	GridLayoutDemo(String title) throws HeadlessException {
		super(title);

		for (int i = 0; i < num_of_rows_columns; i++) {
			for (int j = 0; j < num_of_rows_columns; j++) {
				int k = i * num_of_rows_columns + j;
				if (k > 0) {
					add(new Button("" + k));
				}
				if (k == 15) {
					add(new Button("16"));
				}
			}
		}

		addWindowListener(new WindowCloser());

		setLayout(new GridLayout(num_of_rows_columns, num_of_rows_columns, 5, 5));
		setFont(new Font("SansSerif", Font.BOLD, 24));
		setSize(new Dimension(300, 220));
		setVisible(true);
	}

	private class WindowCloser extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new GridLayoutDemo("Grid Layout Demo");
	}
}
