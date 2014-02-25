package gamers.associate.nemesis.common;

import gamers.associate.nemesis.ia.Action;
import gamers.associate.nemesis.ia.ActionMove;
import gamers.associate.nemesis.ia.Npc;
import gamers.associate.nemesis.map.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

public class Player extends Npc implements  InputProcessor {

	public Player(float x, float y, float width, float height, Color color,
			String name) {
		super(x, y, width, height, color, name);
		// TODO Auto-generated constructor stub
		Gdx.input.setInputProcessor(this);
		
		writeChoices = true;
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	private Action rightClickAction;
	
	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		
		float posX;		
		float posY;
		if(button == Buttons.RIGHT){
            posX = (screenX - this.getWidth()/2)/ Map.TILE_SIZE;
            posY = (Gdx.graphics.getHeight() - screenY - this.getHeight()/2)/Map.TILE_SIZE;

            
            if (rightClickAction != null) {
            	rightClickAction.cancelAction();
            }
            
            rightClickAction = new ActionMove(this, rootAction, new Vector2(posX, posY));						
    		rootAction.addAction(rightClickAction);
    		
        }
        
        return false;
	}
	
	@Override
	public void notifyActionEnd(Action action) {
		super.notifyActionEnd(action);
		if (action == rightClickAction) {
			rightClickAction = null;
		}
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
	

		
}
