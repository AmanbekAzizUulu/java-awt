package complete_reference_examples.working_with_labels;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LabelDemonstration extends Frame {
	private final Label label_1;
	private final Label label_2;
	private final Label label_3;

	public LabelDemonstration(String title) throws HeadlessException {
		super(title);

		addWindowListener(new WindowCloser());

		label_1 = new Label("Label_1");
		label_2 = new Label("Label_2");
		label_3 = new Label("Label_3");

		add(label_1);
		add(label_2);
		add(label_3);

		setLayout(new FlowLayout());

		setVisible(true);
		setSize(480, 200);
		setResizable(false);
		setAlwaysOnTop(true);
	}

	private class WindowCloser extends WindowAdapter {

		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}

	}

	public static void main(String[] args) {
		new LabelDemonstration("Working with Label class");
	}
}
