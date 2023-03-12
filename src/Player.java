import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player {
    BufferedImage playerImage;
    KeyHandler keyHandler;

    int playerSpeed = 5;
    int playerX = 0;
    int playerY = 440;
    int playerWidth = 100;
    int playerHeight = 100;

    public Player(KeyHandler keyHandler){
        this.keyHandler = keyHandler;

        try {
            playerImage = ImageIO.read(new File(("res\\huzi.png")));
        } catch (IOException ex) {
            System.err.println("Error loading image.");
        }
    }

    public void movePlayer(){
        if(keyHandler.rightPressed){
            playerX += playerSpeed;
        }
        if(keyHandler.leftPressed){
            playerX -= playerSpeed;
        }
        if(keyHandler.upPressed){
            playerY -= playerSpeed;
        }
        if(keyHandler.downPressed){
            playerY += playerSpeed;
        }

    }

    public void drawPlayer(Graphics g){
        g.drawImage(playerImage, playerX, playerY, playerWidth, playerHeight, null);
    }
}
