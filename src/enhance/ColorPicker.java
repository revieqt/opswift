
package enhance;
import java.awt.Color;


public class ColorPicker {
    
    public static Color primaryColor; //SHOULD BE THE LIGHTEST
    public static Color theme1Color; //THEME SHADE 1 (LIGHT)
    public static Color theme2Color; //THEME SHADE 2 (DARK)
    public static Color theme3Color  = new Color(52, 73, 85); //THEME SHADE 3 (DARKEST)
    public static Color text1Color; //TEXT SHADE 1 (LIGHT)
    public static Color text2Color; //TEXT SHADE 2 (DARK)
    public static Color text3Color; //TEXT SHADE 3 (DARKEST)
    
    public void verdantTheme(){
        this.primaryColor = new Color(246,244,235);
        this.theme1Color = new Color(120, 160, 131);
        this.theme2Color = new Color(80, 114, 123);
        this.theme3Color = new Color(52, 73, 85);
        this.text1Color = new Color(255, 255, 255);
        this.text2Color = new Color(120, 160, 131);
        this.text3Color = new Color(53, 55, 75);
    }
    
    public void twilightTheme(){
        this.primaryColor = new Color(246,244,235);
        this.theme1Color = new Color(120, 160, 131);
        this.theme2Color = new Color(80, 114, 123);
        this.theme3Color = new Color(52, 73, 85);
        this.text1Color = new Color(255, 255, 255);
        this.text2Color = new Color(120, 160, 131);
        this.text3Color = new Color(53, 55, 75);
    }
    
}
