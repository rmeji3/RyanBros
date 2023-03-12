import javax.swing.*;
import java.awt.*;


public class GamePanel extends JPanel implements ActionListener {
    private Timer timer;

    KeyHandler keyHandler = new KeyHandler();
    Player player = new Player(keyHandler);

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(new Color(135,206,235));
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.addKeyListener(keyHandler);

        int delay = 1; // delay in milliseconds
        timer = new Timer(delay, this);
        timer.start();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timer) {
            run();
            repaint();
        }
    }

    public void drawGrass(Graphics g){
        g.setColor(new Color(132,192,17));
        g.fillRect(0, 520, 1280, 200);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        this.drawGrass(g);
        player.drawPlayer(g);

        g.dispose();
    }

    public void run(){
        player.movePlayer();
    }
}