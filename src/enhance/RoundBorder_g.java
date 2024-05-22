package enhance;
import java.awt.Color;    
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class RoundBorder_g extends JPanel {

    public RoundBorder_g() {
        super();
        setBorder(new RoundedBorder(new Color(120, 160, 131), 20)); // 10 is the radius of the rounded corners
        
    }
    
private class RoundedBorder implements Border {
        private Color color;
        private int radius;

        public RoundedBorder(Color color, int radius) {
            this.color = color;
            this.radius = radius;
        }

        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
        }

        public boolean isBorderOpaque() {
            return true;
        }

        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.setColor(this.color);
            g.drawRoundRect(x, y, width-1, height-1, radius, radius);
        }
    }

}