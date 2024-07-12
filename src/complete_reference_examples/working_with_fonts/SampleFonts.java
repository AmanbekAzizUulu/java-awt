package complete_reference_examples.working_with_fonts;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SampleFonts extends Frame {

    private int next = 0;
    private Font font;
    private String message;

    public SampleFonts(String title) throws HeadlessException {
        super(title);

        font = new Font("Times New Roman", Font.PLAIN, 14);
        message = "Times New Roman";
        setFont(font);

        addMouseListener(new MousePressedMonitor(this));
        addWindowListener(new WindowCloser());

        setVisible(true);
        setSize(new Dimension(300, 100));
    }

    public void setLocalFont(Font f) {
        this.font = f;
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(message, 30, 60);
    }

    private class MousePressedMonitor extends MouseAdapter {

        private final SampleFonts sampleFonts;

        public MousePressedMonitor(SampleFonts sampleFonts) {
            this.sampleFonts = sampleFonts;
        }

        @Override
        public void mousePressed(MouseEvent e) {
            sampleFonts.next++;

            switch (sampleFonts.next) {
                case 0 -> {
                    sampleFonts.font = new Font("Times New Roman", Font.PLAIN, 16);
                    sampleFonts.message = "Times New Roman";
                }
                case 1 -> {
                    sampleFonts.font = new Font("Segoe UI Black", Font.PLAIN, 16);
                    sampleFonts.message = "Segoe UI Black";
                }
                case 2 -> {
                    sampleFonts.font = new Font("MV Boli", Font.PLAIN, 16);
                    sampleFonts.message = "MV Boli";
                }
                case 3 -> {
                    sampleFonts.font = new Font("Palatino Linotype", Font.PLAIN, 16);
                    sampleFonts.message = "Palatino Linotype";
                }
                case 4 -> {
                    sampleFonts.font = new Font("Lucida Console", Font.PLAIN, 16);
                    sampleFonts.message = "Lucida Console";
                }
            }
            if (sampleFonts.next == 4) {
                sampleFonts.next = -1;
            }
            sampleFonts.setFont(sampleFonts.font);
            sampleFonts.repaint();
        }

    }

    private class WindowCloser extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }

    }

    public static void main(String[] args) {
        new SampleFonts("Sample fonts");
    }
}
