import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.URI;
import java.net.URL;

public class Music {
	private File file;
	private URL url;
	private URI uri;
	private AudioClip ac;

	public Music() {
		try {
			file = new File("res/music.mid");
			uri = file.toURI();
			url = uri.toURL();
			ac = Applet.newAudioClip(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		playBgMusic();
	}
	
	public void playBgMusic() {
		ac.loop();
	}

	public void stopBgMusic() {
		ac.stop();
	}
}