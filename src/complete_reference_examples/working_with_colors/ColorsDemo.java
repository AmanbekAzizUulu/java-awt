package complete_reference_examples.working_with_colors;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ColorsDemo extends Frame {

    public ColorsDemo(String title) {
        super(title);
        addWindowListener(new WindowCloser());

		setVisible(true);
		setSize(new Dimension(340, 260));
    }

    private class WindowCloser extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }

    @Override
    public void paint(Graphics g) {
        Color color_1 = new Color(255, 100, 100);
        Color color_2 = new Color(100, 255, 100);
        Color color_3 = new Color(100, 100, 255);

        g.setColor(color_1);
        g.drawLine(20, 40, 100, 100);
        g.drawLine(20, 100, 100, 20 ) ;

		g.setColor(color_2);
        g.drawLine(40 , 45 , 250, 180 ) ;
		g.drawLine(75 , 90, 400, 400 ) ;

		g.setColor(color_3);
        g.drawLine(20 , 150 , 400, 40 ) ;
		g.drawLine(25 , 290 , 80 , 19) ;

		g.setColor(Color.red);
        g.drawOval(20, 40, 50, 50);
        g.fillOval(70 ,90,140, 100) ;

		g.setColor(Color.BLUE);
        g.drawOval(190, 40 , 90, 60) ;
		g.drawRect(40 , 40 , 55, 50 ) ;

		g.setColor(Color.CYAN);
        g.fillRect(100, 40, 60 , 70 ) ;
		g.drawRoundRect(190, 40, 60, 60, 15, 15);
	}

	public static void main(String[] args) {
		new ColorsDemo("Color demo");
	}
}
