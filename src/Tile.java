import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {
    public BufferedImage image;
    public Color color;
    public int textureNumber;
    public int row, col;
    public boolean collision = false;
    public boolean isOverlay = false;
}