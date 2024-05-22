/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enhance;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import javax.swing.UIManager;

public class CustomJDate extends JDateChooser {

    public CustomJDate() {
        super();
        customizeAppearance();
    }

    private void customizeAppearance() {
        // Set the background color
        UIManager.put("Calendar.background", new Color(44,88,110));
        UIManager.put("DateChooser.background", new Color(44,88,110));
        UIManager.put("DateChooser.headerBackground", new Color(44,88,110));

        // Set the foreground (text) color
        UIManager.put("Calendar.foreground", Color.WHITE);
        UIManager.put("DateChooser.foreground", Color.WHITE);
        UIManager.put("DateChooser.headerForeground", Color.WHITE);
    }
}
