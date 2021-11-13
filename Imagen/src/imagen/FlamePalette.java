/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagen;

import java.awt.Color;

/**
 *
 * @author David
 */
public class FlamePalette {
    private final int colordepth = 255;
    private Color fireColor [];//Array que contiene los colores de la paleta.
    matriz = new int matriz[1000][1000];
    
    public void addTargetColor (Color color, Integer pos){
            pos = 
            int a = colordepth; 
            int r = color.getRed();
            int g = color.getGreen();
            int b = color.getBlue();
            int p = (a<<24) | (r<<16) | (g<<8) | b;
            this.setRGB();
    }
    //Crear paleta (Dentro de Viewer)
//    private void createFireTwo (){
//        FirePalette fo = new FeirPalette();
//        fp.addTargetColor(new Color(0,0,0,4),0);
//    }
}
