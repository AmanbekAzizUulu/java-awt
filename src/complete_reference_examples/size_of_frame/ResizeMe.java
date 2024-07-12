package complete_reference_examples.size_of_frame;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ResizeMe extends Frame {

    private final int increment = 25;
    private final int max = 500;
    private final int min = 200;
    private Dimension dimension;

    public ResizeMe(String title) {
        super(title);
        addMouseListener(new MouseReleased(this));
        addWindowListener(new WindowCloser());

		setSize(new Dimension(200, 200));
        setAlwaysOnTop(true);
        setVisible(true);
    }

    @Override
    public void paint(Graphics drawer) {
        Insets inset = this.getInsets();

        dimension = this.getSize();

        drawer.drawLine(inset.left, inset.top, dimension.width - inset.right, dimension.height - inset.bottom);
        drawer.drawLine(inset.left, dimension.height - inset.bottom, dimension.width - inset.right, inset.top);

    }

    private class WindowCloser extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }

    private class MouseReleased extends MouseAdapter {

        private final ResizeMe mainFrame;

        public MouseReleased(ResizeMe resizeMe) {
            this.mainFrame = resizeMe;
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            int width = (dimension.width + increment) > max ? min : (dimension.width + increment);
            int height = (dimension.height + increment) > max ? min : (dimension.height + increment);
            mainFrame.setSize(new Dimension(width, height));
        }
    }

    public static void main(String[] args) {
        new ResizeMe("Press to resize");
    }
}
