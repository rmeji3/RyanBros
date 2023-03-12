import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SoundPlayer {

    KeyHandler keyHandler;

    public SoundPlayer(KeyHandler keyHandler){
        this.keyHandler = keyHandler;
    }

    public void playSound(String filePath) {
        try {
            File soundFile = new File(filePath);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void playMsBode(){
        if(keyHandler.upPressed) {
            playSound("res\\mrsBode.wav");
        }
    }
}