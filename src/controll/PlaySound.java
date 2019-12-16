package controll;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;

public class PlaySound {

    public static final int STATUS_PLAY = 1;
    public static final int STATUS_STOP = 2;
    public static final String SOUND_ON = "Sound on";
    public static final String SOUND_OFF = "Sound off";

    private static final String URL = "C:\\Users\\LAptop\\IdeaProjects\\GamePokemon\\audio\\sound.mp3";
    private boolean status;
    private Media mMedia;
    private MediaPlayer mMediaPlayer;

    public PlaySound(){
        status = false;
        File file = new File("sound.mp3");

        try {
            String uri = file.toURI().toString();
            System.out.println(uri);
            mMedia = new Media(uri);
        } catch (Exception e){
            System.err.println("1");
            System.err.println(e.getMessage());
        }

        try {
            mMediaPlayer = new MediaPlayer(mMedia);
        } catch (Exception e){
            System.err.println("2");
            System.err.println(e.getMessage());
        }

    }

    public String changeStatus(){
        if(status){
            // Status on
            stopSound();
        } else {
            playSound();
        }

        status = !status;
        if (status){
            // Status off
            return SOUND_ON;
        } else {
            return SOUND_OFF;
        }
    }

    public void playSound(){
        mMediaPlayer.play();
    }

    public void stopSound(){
        mMediaPlayer.stop();
    }

    public void restartSound(){
        mMediaPlayer.seek(new Duration(0));
        mMediaPlayer.play();
    }
}