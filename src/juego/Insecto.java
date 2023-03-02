package juego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

public class Insecto {
    public static int x= 10, y =10;
    public void paint(Graphics g){
        ImageIcon hoyo = new ImageIcon(getClass().getResource("../images/hoyo.png"));
        g.drawImage(hoyo.getImage(),500,500,150,150,null);

        ImageIcon arana = new ImageIcon(getClass().getResource("../images/araña.png"));
        g.drawImage(arana.getImage(),x,y, 100, 100, null);
    }

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
    public Ellipse2D getBoundsBicho(){
        return new Ellipse2D.Double(x+10,y+30,80,50);
    }

    public boolean llegaFinal(){
        Rectangle cuadrado = new Rectangle(520,520,110,110);
        Area cuadradoArea=new Area(cuadrado);
        return cuadradoArea.contains(getBoundsBicho().getBounds());
    }
}
/*
# Codigo refactorizado por IA
public void keyPressed(KeyEvent e){
    int key = e.getKeyCode();

    switch (key) {
        case KeyEvent.VK_LEFT:
            x = Math.max(0, x - 20);
            break;
        case KeyEvent.VK_RIGHT:
            x = Math.min(580, x + 20);
            break;
        case KeyEvent.VK_UP:
            y = Math.max(0, y - 20);
            break;
        case KeyEvent.VK_DOWN:
            y = Math.min(580, y + 20);
            break;
        default:
            break;
    }
}
 */