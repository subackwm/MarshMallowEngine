package dev.suback.marshmallow.resource;

import java.applet.AudioClip;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class MSSound {

	public Clip clip; // Creates a audio clip to be played

	public MSSound(String path) {
		try {
			URL url = this.getClass().getClassLoader().getResource(path);
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
			clip = AudioSystem.getClip();
			clip.open(audioIn);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void start() {
		clip.start();
	}

	public void stop() {
		clip.stop();
	}

}
