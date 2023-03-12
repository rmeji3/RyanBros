import javax.swing.*;
import java.awt.*;


public class GamePanel extends JPanel implements Runnable {

    public int screenWidth = 800;
    public int screenHeight = 800;

    public int gameRefreshRate = 165; // Number of times the game refreshes per second
    public int FPS;

    Thread gameThread;

    KeyHandler keyHandler = new KeyHandler();

    TileManager tileManager = new TileManager(this);
    DrawPanel drawPanel = new DrawPanel(this, tileManager);

    Player player = new Player(keyHandler);

    SoundPlayer soundPlayer = new SoundPlayer(keyHandler);

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(new Color(135,206,235));
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);

        player.movePlayer();
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        drawPanel.drawTiles(g);
        player.drawPlayer(g);

        g.dispose();
    }

    public void run(){
        System.out.println("Thread is running");

        double drawInterval = 1000000000 / gameRefreshRate;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while(gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if(delta >= 1) {
                updateGame();
                repaint();
                delta--;
                drawCount++;
            }

            if(timer >= 1000000000) {
                FPS = drawCount;
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void updateGame(){
        player.movePlayer();
        soundPlayer.playMsBode();
    }
}