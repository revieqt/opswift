/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enhance;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JPasswordField;
import javax.swing.border.Border;

public class CustomPF extends JPasswordField {
    
    private Color defaultBorderColor = new Color(52, 73, 85);
    private Color errorBorderColor = Color.RED;
    
    public CustomPF() {
        super();
        setBorder(new RoundedBorder(defaultBorderColor, 10)); // 10 is the radius of the rounded corners
        
        // Add focus listener to handle border color change
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                setBorder(new RoundedBorder(defaultBorderColor, 10));
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (!isValidInput()) {
                    setBorder(new RoundedBorder(errorBorderColor, 10));
                }
            }
        });
    }
    
    // Method to validate input
    private boolean isValidInput() {
        // Example validation (You can replace this with your own validation logic)
        String text = getText();
        return !text.isEmpty();
    }
    
    // Custom border class to create rounded borders
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