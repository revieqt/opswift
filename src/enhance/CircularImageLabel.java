package enhance;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class CircularImageLabel extends JLabel {
    private Image image;

    public CircularImageLabel(String imagePath) {
        this.image = new ImageIcon(imagePath).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            Graphics2D g2d = (Graphics2D) g.create();

            // Enable antialiasing for better image quality
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

            int diameter = Math.min(getWidth(), getHeight());
            Ellipse2D.Double clip = new Ellipse2D.Double(0, 0, diameter, diameter);
            g2d.setClip(clip);
            g2d.drawImage(image, 0, 0, diameter, diameter, this);

            g2d.dispose();
        }
    }

    // Method to set the image path
    public void setImagePath(String imagePath) {
        this.image = new ImageIcon(imagePath).getImage();
        repaint();
    }
}