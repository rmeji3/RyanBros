import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public KeyHandler(){

    }

    public boolean rightPressed = false;
    public boolean leftPressed = false;
    public boolean downPressed = false;
    public boolean upPressed = false;


    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_D) {
            rightPressed = true;
            System.out.println("D");
        }

        if(code == KeyEvent.VK_A) {
            leftPressed = true;
            System.out.println("A");
        }

        if(code == KeyEvent.VK_W) {
            upPressed = true;
            System.out.println("W");
        }
        if(code == KeyEvent.VK_S) {
            downPressed = true;
            System.out.println("S");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_D) {
            rightPressed = false;
        }

        if(code == KeyEvent.VK_A) {
            leftPressed = false;
        }
        if(code == KeyEvent.VK_W) {
            upPressed = false;
        }
        if(code == KeyEvent.VK_S) {
            downPressed = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
