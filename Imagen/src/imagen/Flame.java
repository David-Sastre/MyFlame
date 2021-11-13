/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagen;


import java.awt.image.BufferedImage;



/**
 *
 * @author David
 */
public class Flame extends BufferedImage implements Runnable{
//    int width = 100;
//    int height = 100;
//    int imageType = TYPE_INT_ARGB;
    BufferedImage imagen = null;
   
    private int [][] matriz;
    
    public Flame (int width, int height, int imageType){
        super(width, height, imageType);
//        this.width = width;
//        this.height = height;
//        this.imageType = TYPE_INT_ARGB;
        matriz = new int [1000][1000];
    }
    //Creamos las Sparks
    public void createSparks(){
        System.out.println("Se crean las chispas");
       for (int i=0; i < matriz.length; i++){
           int aux = (int) (Math.random()*200);
           if (aux >=120){
               matriz[i][matriz[0].length-1]=255;
           }
       }          
    }
    //Creamos los puntos fríos
    public void createCool(){
        System.out.println("Se crean los puntos frios");
        for (int i=0; i < matriz.length; i++){
           int aux = (int) (Math.random()*200);
           if (aux <=75){
               matriz[i][matriz[0].length-1]=0;
           }
       }          
    }
    //EvolveTemperature
    public void EvolveTemperature(){
        int increment = (int) 0.9d;
        System.out.println("Evolución del fuego");
        for (int j=matriz[0].length-2; j>=0; j--){
            for (int i=1; i < matriz.length-1; i++){
                matriz[i][j]=(matriz[i][j+1] + matriz[i+1][j+1] + matriz[i-1][j+1])/3 + increment;
            }
        }
    }
    //CreateFlameImage
    public void createFlameImage (){
        System.out.println("Creamos las llamas");
        for (int i = 0; i < matriz.length; i++)
        {
            for (int j = 0; j < matriz[i].length; j++)
            {
                int a = 255; 
                int r = matriz[i][j];
                int g = 0;
                int b = 0;
                int p = (a<<24) | (r<<16) | (g<<8) | b;
                this.setRGB(i, j, p);
           }
        }
    }
    
    @Override
    public void run() {
        while (true){
            try{
                Thread.sleep(50);
            }catch(InterruptedException e)
                    {
                       e.printStackTrace();
                    }
            //Sparks
            this.createSparks();
            //CreateCool
            this.createCool();
            //EvolveTemperature
            this.EvolveTemperature();
            //CreateFlameImage
            this.createFlameImage();
        }    
    }
}