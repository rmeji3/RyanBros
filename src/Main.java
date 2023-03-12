import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        JFrame window = new JFrame();
        GamePanel gamePanel = new GamePanel();
        ImageIcon icon = new ImageIcon("res/ryan.png");

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("RyanBros");
        window.setIconImage(icon.getImage());

        window.add(gamePanel);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.startGameThread();
    }

}