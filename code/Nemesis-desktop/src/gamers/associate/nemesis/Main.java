package gamers.associate.nemesis;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Nemesis";
		cfg.useGL20 = false;
		cfg.width = 800;
		cfg.height = 600;
		cfg.addIcon("data/icon.png", Files.FileType.Internal);
		
		new LwjglApplication(new NemesisGame(), cfg);
	}
}
