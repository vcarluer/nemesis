package gamers.associate.nemesis.ui;

import gamers.associate.nemesis.ia.ActionChoice;
import gamers.associate.nemesis.map.Map;
import gamers.associate.nemesis.ui.CameraManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ActionChoiceRenderer {
	private ActionChoice choice;
	private BitmapFont bitmapFont;
	private static String fontName = "baveuse";
	
	public ActionChoiceRenderer(ActionChoice actionChoice) {
		choice = actionChoice;
		bitmapFont = new BitmapFont(
				Gdx.files.internal("data/" + fontName + ".fnt"), 
				Gdx.files.internal("data/" + fontName + ".png"), 
				false);
		
		// Should instead use dedicated font at proper size?
		bitmapFont.setUseIntegerPositions(false);
		bitmapFont.setScale(1 / Map.TILE_SIZE);
	}
	
	public void render(SpriteBatch batch) {
		
		if (choice.getPositionAction() != null) {
			bitmapFont.draw(batch, "Move: " + choice.getPositionAction().getId(), 0, CameraManager.get().cam.viewportHeight);
		}
		
		if (choice.getHandsAction() != null) {
			bitmapFont.draw(batch, "Hand: " + choice.getHandsAction().getId(), 0, CameraManager.get().cam.viewportHeight - 1);
		}
		
		if (choice.getHeadAction() != null) {
			bitmapFont.draw(batch, "Head: " + choice.getHeadAction().getId(), 0, CameraManager.get().cam.viewportHeight - 2);
		}
				
	}
}
