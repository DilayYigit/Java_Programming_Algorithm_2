import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import javax.swing.*;
import java.awt.geom.*

public class Graphs2D extends JPanel {

    private Ellipse2D.Double circle =
            new Ellipse2D.Double(10, 10, 350, 350);
    private Rectangle2D.Double square =
            new Rectangle2D.Double(10, 10, 350, 350);

    public void paintComponent(Graphics g) {
        clear(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.fill(circle);
        g2d.draw(square);
    }
    protected void clear(Graphics g) {
        super.paintComponent(g);
    }
    protected Ellipse2D.Double getCircle() {
        return(circle);
    }
}
