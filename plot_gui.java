import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class plot_gui {

    public plot_gui (ArrayList<circlePoint> interior, ArrayList<circlePoint> exterior) {
        JFrame frame = new JFrame("Plot Points");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new MyPanel(interior, exterior));
        frame.pack();
        frame.setVisible(true);
    }
}

class MyPanel extends JPanel {

    ArrayList<circlePoint> interior;
    ArrayList<circlePoint> exterior;

    public MyPanel(ArrayList<circlePoint> interior, ArrayList<circlePoint> exterior) {
        this.interior = interior;
        this.exterior = exterior;
    }

    public Dimension getPreferredSize() {
        return new Dimension(400,400);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawOval(0,0,400,400);

        g.setColor(Color.RED);
        for (int len = 0; len < this.interior.size(); len ++) {
                if (len % 3 == 0) {
                circlePoint temp = interior.get(len);
                int x = (int)(temp.x * this.getWidth()/2);
                int y = (int)(temp.y * this.getHeight()/2);
                g.drawLine(200+x,200+y,200+x,200+y);
            }
        }

        g.setColor(Color.BLUE);
        for (int len = 0; len < this.exterior.size(); len ++) {
            if (len % 3 == 0) {
                circlePoint temp = exterior.get(len);
                int x = (int)(temp.x * this.getWidth()/2);
                int y = (int)(temp.y * this.getHeight()/2);
                g.drawLine(200+x,200+y,200+x,200+y);
            }
        }
    }
}
