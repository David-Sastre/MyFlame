/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagen;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 *
 * @author David
 */
public class MyFlame extends JFrame{
    
//    FondoPanel fondo = new FondoPanel();
//    Flame fuego = new Flame(100,100,2);
    
    Viewer viewer;
    Thread thread;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        MyFlame app = new MyFlame();
        
    }
    
    public MyFlame (){
        super("Fuego");
        this.setLayout(new GridLayout());
        JPanel j = new JPanel();
        j.setLayout(new GridLayout());
        viewer = new Viewer();
        j.add(viewer);
        this.add (j);
//        f.add(new ControlPanel());
        this.setSize(462,435);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        //this.setContentPane(fondo);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        thread = new Thread(viewer);
        thread.start();

    }
}

//    public class FondoPanel extends JPanel {
//        public Image imagen;
//        @Override
//        public void paint(Graphics g){
//            imagen = new ImageIcon(getClass().getResource("/imagen/Chimenea.jpg")).getImage();
//            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
//            setOpaque(false);
//            
//            super.paint(g);
//        }
//    } 
//}
