package juego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;




public class Juego extends JPanel {

    public static boolean haChocado=false;
    Shuriken shuriken = new Shuriken(this);
    Naruto naruto = new Naruto();
    public Juego(){
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyPressed(KeyEvent e) {
                naruto.keyPressed(e);
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        setFocusable(true);
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);

        ImageIcon tela = new ImageIcon(getClass().getResource("../images/aldea.png"));
        g.drawImage(tela.getImage(),0,0,getWidth(),getHeight(),this);

        Font score = new Font("Arial",Font.BOLD,30);
        g.setFont(score);
        g.setColor(Color.orange);
        g.drawString("PUNTAJE: "+ shuriken.obtenerPuntos(),520,25);

        naruto.paint(g);
        shuriken.paint(g);
        shuriken.mover();
        g.dispose();
    }
    public static void main(String[] args) {
    /*    IconoTest icon = new IconoTest();*/

        JFrame miVentana = new JFrame("NARUTO");
        Juego game = new Juego();
        miVentana.add(game);
        miVentana.setSize(700,700);
        miVentana.setVisible(true);
        miVentana.setResizable(false);
        miVentana.setLocationRelativeTo(null);
        miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true){
            if (haChocado | Shuriken.nivel==5){
                if(Shuriken.nivel==5){JOptionPane.showMessageDialog(null,"¡Ganaste, Dattebayo!");
                    System.exit(0);}
                    int reiniciaJuego=JOptionPane.showConfirmDialog(null,"Haz Perdido, ¡No te des de baja! " +
                            "¿Quieres reiniciar el juego?","¡Perdiste!" ,JOptionPane.YES_NO_OPTION);
                    if (reiniciaJuego==0){
                        reiniciaValores();
                    } else if (reiniciaJuego==1) {
                        System.exit(0);
                    }
            }   try {
                Thread.sleep(10);
            } catch (InterruptedException ex){
                System.out.println(ex.toString());
            }
            game.repaint();
        }
    }
    public static void reiniciaValores(){
        Shuriken.xShuriken1 =600;
        Shuriken.yShuriken1 =700;
        Shuriken.xShuriken2 =700;
        Shuriken.yShuriken2 =100;
        Shuriken.xShuriken3 =-20;
        Shuriken.yShuriken3 =600;
        Shuriken.xShuriken4 =300;
        Shuriken.yShuriken4 =-20;

        Naruto.x=10;
        Naruto.y=10;
        Shuriken.nivel=1;
        haChocado=false;
        Shuriken.puntos=0;
    }
}