package GameMechanics;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class SoundEffect {
	MediaPlayer mediaPlayer;
	
	public void HopSound() {
		String musicFile = "src/resources/sound-frogger-hop.wav";   
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
	    mediaPlayer.play();
	}
	
	public void TimeRunsOut() {
		String musicFile = "src/resources/sound-frogger-time.wav";   
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
	    mediaPlayer.play();
	}
	
	public void squash() {
		String musicFile = "src/resources/sound-frogger-squash.wav";   
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
	    mediaPlayer.play();
	}
}
