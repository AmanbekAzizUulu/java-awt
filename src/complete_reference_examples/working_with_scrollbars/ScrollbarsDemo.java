package complete_reference_examples.working_with_scrollbars;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Scrollbar;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ScrollbarsDemo extends Frame {
	private String message;

	private final Scrollbar scrollbar_vertical;
	private final Scrollbar scrollbar_horizontal;

	public ScrollbarsDemo(String title) {
		super(title);

		addWindowListener(new WindowCloser());

		scrollbar_vertical = new Scrollbar(Scrollbar.VERTICAL, 0, 1, 0, 201);
		scrollbar_vertical.setPreferredSize(new Dimension(20, 100));

		scrollbar_horizontal = new Scrollbar(Scrollbar.HORIZONTAL, 0, 1, 0, 101);
		scrollbar_horizontal.setPreferredSize(new Dimension(100, 20));

		scrollbar_horizontal.addAdjustmentListener(new ScrollbarDragged());
		scrollbar_vertical.addAdjustmentListener(new ScrollbarDragged());

		add(scrollbar_vertical);
		add(scrollbar_horizontal);
		addMouseListener(new MouseDragged());

		setFont(new Font("Segoe UI", Font.BOLD, 14));
		setVisible(true);
		setLayout(new FlowLayout());
		setSize(new Dimension(400, 200));
	}

	private class WindowCloser extends WindowAdapter {

		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}

	}

	public static void main(String[] args) {
		new ScrollbarsDemo("Scrollbar Demo");
	}

	@Override
	public void paint(Graphics g) {
		message = "Vertical value: " + scrollbar_vertical.getValue();
		g.drawString(message, 20, 160);

		message = "Horizontal value: " + scrollbar_horizontal.getValue();
		g.drawString(message, 20, 180);

		g.drawString("*", scrollbar_horizontal.getValue(), scrollbar_vertical.getValue());
	}

	private class ScrollbarDragged implements AdjustmentListener {

		@Override
		public void adjustmentValueChanged(AdjustmentEvent e) {
			repaint();
		}

	}

	private class MouseDragged extends MouseAdapter {

		@Override
		public void mouseDragged(MouseEvent me) {
			int x = me.getX();
			int y = me.getY();

			scrollbar_vertical.setValue(y);
			scrollbar_horizontal.setValue(x);
			repaint();
		}

	}
}
