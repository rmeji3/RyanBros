import javax.imageio.ImageIO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class TileManager {

    GamePanel gamePanel;

    public final int totalBits = 16;
    public final int bit = (int)Math.sqrt(totalBits);

    Tile[][] tileMap = new Tile[bit][bit];
    Tile[] tileList = new Tile[10];

    String mapFile = "C:\\Users\\Wafa\\IdeaProjects\\RyanBros\\res\\map1.txt";

    public TileManager(GamePanel gamePanel){
        this.gamePanel = gamePanel;

        setTiles();
        loadTileList();
        loadMap(mapFile);
    }

    private void setTiles(){
        for (int row = 0; row < bit; row++) {
            for (int col = 0; col < bit; col++) {
                Tile tile = new Tile();
                    tile.row = row;
                    tile.col = col;

                tileMap[row][col] = tile;
            }
        }
    }

    private void loadTileList() {
        try {
            tileList[0] = new Tile();
            tileList[0].image = ImageIO.read(new File(("res\\grass.png")));
            tileList[0].textureNumber = 0;

            tileList[1] = new Tile();
            tileList[1].image = ImageIO.read(new File(("res\\dirt.jpg")));
            tileList[1].textureNumber = 1;

            tileList[2] = new Tile();
            tileList[2].image = ImageIO.read(new File(("res\\amr.png")));
            tileList[2].textureNumber = 2;
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    private void loadMap(String mapFile) {
        try {
            FileReader fileReader = new FileReader(mapFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            for (int tileRow = 0; tileRow < bit; tileRow++) {
                String line = bufferedReader.readLine();
                String[] numbers = line.split(" ");

                for (int tileCol = 0; tileCol < bit; tileCol++) {
                    int textureNumber = Integer.parseInt(numbers[tileCol]);
                    tileMap[tileRow][tileCol].textureNumber = textureNumber;
                    tileMap[tileRow][tileCol].image = tileList[textureNumber].image;
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}