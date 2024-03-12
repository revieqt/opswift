package enhance;
    import java.awt.Color;    
    import java.awt.Graphics;
    import java.awt.Graphics2D;
    import java.awt.RenderingHints;
    import javax.swing.JPanel;

    public class RoundPanel extends JPanel {
    
    private Color backgroundColor = new Color(255, 255, 255);

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
        
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        int width = getWidth();
        int height = getHeight();
        int cornerRadius = 20; 

        g2d.setColor(backgroundColor);
        g2d.fillRoundRect(0, 0, width - 6, height - 6, cornerRadius, cornerRadius);
        
        g2d.dispose();
    }
}

