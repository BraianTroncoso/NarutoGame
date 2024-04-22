package juego;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

public class Shuriken {
    //"Variables y configuración de inicio""
    public static int xShuriken1 =600, yShuriken1 =700;
    public static int xShuriken2 =700, yShuriken2 =100;
    public static int xShuriken3 =20, yShuriken3 =600;
    public static int xShuriken4 =300, yShuriken4 =20;

    public static int puntos = 0;
    public Juego j;
    public static int nivel=1;
    int incremento = 2;


    Area r1,r2,r3,r4, shurikenArea;

    int inicioY=0;
    int inicioX=0;
    int finX=700;
    int finY=700;

    public Shuriken(Juego j2){
        this.j=j2;
    }

    //"Dibujando objetos en una ventana gráfica"
    public void paint(Graphics g){
        ImageIcon shuriken = new ImageIcon(getClass().getResource("../images/shuriken.png"));
        if (nivel>=1){
            g.drawImage(shuriken.getImage(), xShuriken1, yShuriken1,48,48,null);
        }
        if (nivel>=2){
            g.drawImage(shuriken.getImage(), xShuriken2, yShuriken2,48,48,null);
        }
        if (nivel>=3){
            g.drawImage(shuriken.getImage(), xShuriken3, yShuriken3,48,48,null);
        }
        if (nivel>=4){
            g.drawImage(shuriken.getImage(), xShuriken4, yShuriken4,48,48,null);
        }
    }


    //"Comprobación de colisión entre objetos
    public boolean choque(){
        Area areaPersonaje = new Area(j.naruto.getBoundsNaruto());
        areaPersonaje.intersect(getBoundsPiedra());
        return !areaPersonaje.isEmpty();
    }

    //"Actualización de movimiento y lógica del juego"
    public void mover(){
        if(choque()){
            j.haChocado=true;
        }

        if(j.naruto.llegaFinal()){
            nivel++;
            Naruto.x=10;
            Naruto.y=10;
        }
        if(nivel>=1){
            if(yShuriken1 ==-20){
                yShuriken1 =700;
                xShuriken1 =(int) (Math.random()*(finX-inicioX)+inicioX);
                puntos++;
            }else {
                yShuriken1 = yShuriken1 -incremento;
            }
        }
        if(nivel>=2){
            if(xShuriken2 ==-20){
                xShuriken2 =700;
                yShuriken2 =(int) (Math.random()*(finY-inicioY)+inicioY);
                puntos++;
            }else {
                xShuriken2 = xShuriken2 -incremento;
            }
        }
        if(nivel>=3){
            if(xShuriken3 ==700){
                xShuriken3 =-20;
                yShuriken3 =(int) (Math.random()*(finY-inicioY)+inicioY);
                puntos++;
            }else {
                xShuriken3 = xShuriken3 +incremento;
            }
        }
        if(nivel>=4){
            if(xShuriken4 ==700){
                yShuriken4 =-20;
                xShuriken4 =(int) (Math.random()*(finX-inicioX)+inicioX);
                puntos++;
            }else {
                yShuriken4 = yShuriken4 +incremento;
            }
        }
    }
//"Obtención de límites de áreas de shuriken en juego y puntos de jugador"
    public int obtenerPuntos(){
        return puntos;
    }
    public Area getBoundsPiedra(){
        Ellipse2D piedra1,piedra2,piedra3,piedra4;

        piedra4 = new Ellipse2D.Double(xShuriken1, yShuriken1,48,48);
        r4= new Area(piedra4);
        shurikenArea =r4;

        if(nivel>=1){
            piedra1= new Ellipse2D.Double(xShuriken1, yShuriken1,48,48);
            r1= new Area(piedra1);
            shurikenArea.add(r1);
        }
        if(nivel>=2){
            piedra2= new Ellipse2D.Double(xShuriken2, yShuriken2,48,48);
            r2= new Area(piedra2);
            shurikenArea.add(r2);
        }
        if(nivel>=3){
            piedra3= new Ellipse2D.Double(xShuriken3, yShuriken3,48,48);
            r3= new Area(piedra3);
            shurikenArea.add(r3);
        }
        if(nivel>=4){
            piedra4= new Ellipse2D.Double(xShuriken4, yShuriken4,48,48);
            r4= new Area(piedra4);
            shurikenArea.add(r4);
        }
        return shurikenArea;
    }
}
