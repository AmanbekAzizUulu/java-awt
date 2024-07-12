package complete_reference_examples.using_adapter_class;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


/*
		Как видно в программе, отсутствие необходимости реализовывать все ме­тоды,
     	определенные интерфейсами
	  	- MouseMotionListener,
	  	- MouseListener и
	  	- MouseWheelListener,
 		экономит значительные усилия и предотвращает за­громождение кода пустыми методами
 */
public class AdapterDemo extends Frame {

    private String message = "";

    public AdapterDemo(String title) {
        super(title);
        setLayout(new FlowLayout());
        addWindowListener(new WindowCloser());
        addMouseListener(new MyMouseAdapter(this));
        addMouseMotionListener(new MyMouseAdapter(this));
        setVisible(true);
        setSize(new Dimension(355, 215));
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(message, this.getWidth() / 2 - this.message.length() * 3, this.getHeight() / 2);
        setBackground(Color.CYAN);
    }

    private class WindowCloser extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new AdapterDemo("Adapter classes");
    }

    // adapter class
    private class MyMouseAdapter extends MouseAdapter {

        private final AdapterDemo adapterDemo;

        public MyMouseAdapter(AdapterDemo adapterDemo) {
            this.adapterDemo = adapterDemo;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            adapterDemo.message = "Mouse's clicked";
            adapterDemo.repaint();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            adapterDemo.message = "Mouse's dragging";
            repaint();
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            adapterDemo.message = "Mouse's moving x=" + e.getX() + " y=" + e.getY();
            repaint();
        }
    }

}
