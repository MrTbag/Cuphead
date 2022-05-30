package Cuphead.Controller;

import javafx.scene.Parent;
import javafx.scene.effect.ColorAdjust;

public class ColorController extends Controller{
    public static boolean grayScale = false;

    public static void setGrayScale(Parent root){
        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setSaturation(-1);
        root.setEffect(colorAdjust);
    }

    public static void removeGrayScale(Parent root){
        root.setEffect(null);
    }
}
