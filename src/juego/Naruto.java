package juego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

public class Naruto {
    //"Dibujando imágenes en una ventana gráfica con Java"
    public static int x= 10, y =10;
    public void paint(Graphics g){
        ImageIcon portal = new ImageIcon(getClass().getResource("../images/portal.png"));
        g.drawImage(portal.getImage(),500,500,150,150,null);

        ImageIcon naruto = new ImageIcon(getClass().getResource("../images/naruto.png"));
        g.drawImage(naruto.getImage(),x,y, 100, 100, null);
    }

    //"Control de teclas para mover un objeto en una ventana gráfica"
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode()==37){
            if(x>0){
                x = x-20;
            }
        }
        if(e.getKeyCode()==39){
            if(x<580){
                x = x+20;
            }
        }
        if(e.getKeyCode()==38){
            if(y>0){
                y= y-20;
            }
        }
        if(e.getKeyCode()==40){
            if(y<580){
                y= y+20;
            }
        }

    }

//"Cálculo de colisión en un juego con objetos geométricos"
    public Ellipse2D getBoundsNaruto(){
        return new Ellipse2D.Double(x+10,y+30,80,50);
    }

    public boolean llegaFinal(){
        Rectangle cuadrado = new Rectangle(520,520,110,110);
        Area cuadradoArea=new Area(cuadrado);
        return cuadradoArea.contains(getBoundsNaruto().getBounds());
    }
}
