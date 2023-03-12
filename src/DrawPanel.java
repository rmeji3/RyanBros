import java.awt.*;

public class DrawPanel {

    GamePanel gamePanel;
    TileManager tileManager;

    public DrawPanel(GamePanel gamePanel, TileManager tileManager){
        this.gamePanel = gamePanel;
        this.tileManager = tileManager;
    }

    public void drawGrass(Graphics g){
        int height = gamePanel.screenHeight / 3;
        int y = gamePanel.screenHeight - height;

        g.setColor(new Color(132,192,17));
        g.fillRect(0, y, gamePanel.screenWidth, height);
    }

    public void drawTiles(Graphics g){
        int x = 0;
        int y = 0;
        int width = gamePanel.screenWidth / tileManager.bit;
        int height = gamePanel.screenHeight / tileManager.bit;

        for(int r = 0; r < tileManager.tileMap.length; r++) {
            for(int c = 0; c < tileManager.tileMap[r].length; c++){
                Image img = tileManager.tileMap[r][c].image;
                g.drawImage(img, x, y, width, height, null);
                x += width;
            }
            x = 0;
            y += height;
        }

    }

//-----------------------------------GRAPHICS CHECK-----------------------------------\\

    int x = 100;
    int speed = 10;

    public void graphicCheck(Graphics g){

        g.setColor(Color.black);
        g.fillRect(x,100,100,100);

        x += speed;
    }

}
