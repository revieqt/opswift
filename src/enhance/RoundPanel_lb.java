package enhance;
import java.awt.Color;    
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class RoundPanel_lb extends JPanel {
    
    private Color backgroundColor = new Color(120, 160, 131); // Default color is white

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        repaint(); // Ensure the panel is repainted with the new color
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Enable anti-aliasing for smoother edges
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        int width = getWidth();
        int height = getHeight();
        int cornerRadius = 20; // Adjust this value to change the roundness
        g2d.setColor(backgroundColor);
        // Draw the rounded rectangle
        g2d.fillRoundRect(0, 0, width, height, cornerRadius, cornerRadius);
        
        g2d.dispose();
    }

}