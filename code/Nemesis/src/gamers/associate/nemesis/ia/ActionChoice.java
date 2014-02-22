package gamers.associate.nemesis.ia;

import gamers.associate.nemesis.map.Map;
import gamers.associate.nemesis.ui.CameraManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ActionChoice {
	private Action positionAction;
	private Action handsAction;
	private Action headAction;
	private BitmapFont bitmapFont;
	private static String fontName = "baveuse";
	
	public ActionChoice() {		
		bitmapFont = new BitmapFont(
				Gdx.files.internal("data/" + fontName + ".fnt"), 
				Gdx.files.internal("data/" + fontName + ".png"), 
				false);
		
		// Should instead use dedicated font at proper size?
		bitmapFont.setUseIntegerPositions(false);
		bitmapFont.setScale(1 / Map.TILE_SIZE);
	}
	
	public void render(SpriteBatch batch) {
		
		if (positionAction != null) {
			bitmapFont.draw(batch, positionAction.getId(), 0, CameraManager.get().cam.viewportHeight);
		}
				
	}
	
	public Action getPositionAction() {
		return positionAction;
	}
	public void setPositionAction(Action positionAction) {
		this.positionAction = positionAction;
	}
	public Action getHandsAction() {
		return handsAction;
	}
	public void setHandsAction(Action handsAction) {
		this.handsAction = handsAction;
	}
	public Action getHeadAction() {
		return headAction;
	}
	public void setHeadAction(Action headAction) {
		this.headAction = headAction;
	}
	
	public boolean isChoiceDone() {
		return positionAction != null && handsAction != null && headAction != null;
	}
	
	public void reset() {
		positionAction = null;
		handsAction = null;
		headAction = null;
	}
	
	public void step(float delta) {
		if (positionAction != null) {
			positionAction.step(delta);
		}
		
		if (handsAction != null && handsAction != positionAction) {
			handsAction.step(delta);
		}
		
		if (headAction != null && headAction != handsAction && headAction != positionAction) {
			headAction.step(delta);
		}
	}
}
