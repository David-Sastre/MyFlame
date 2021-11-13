/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagen;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author David
 */
public class Viewer extends Canvas implements Runnable{
    private BufferedImage imagen;
    Flame fl;
    

    //Constructor Viewer
    public Viewer (){
        //Al tener la imagen de fondo en Myflame no importa añadirla en el viewer
        try{
        imagen = ImageIO.read(new File("src/imagen/Chimenea.jpg"));
        }catch(IOException e){
        System.out.println("Error al cargar la Imagen");
        }
        
        fl = new Flame (1000, 1000, 2);
        Thread fuego = new Thread (fl);
        fuego.start();
    }
    //Creamos el método Paint
    
    public void paint(){
        BufferStrategy bs = this.getBufferStrategy();
        Graphics g = bs.getDrawGraphics();
        if (bs==null){
            return;
        }
        if (g==null){
            return;
        }
        System.out.println("Se pinta la chimenea");
        g.drawImage(imagen,0,0,null);
        System.out.println("Se Crea la imagen de fondo");
        g.drawImage(fl,130,194,213,175,null);
        bs.show();
        g.dispose();
        //g.drawImage(fl, 0,0, this.getWidth(), this.getHeight(), null);
    } 

    @Override
    public void run() {
        JPanel panel= new JPanel();
        
        createBufferStrategy(2);

        while (true){

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.paint();        

        }
    }
}

