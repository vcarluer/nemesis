package gamers.associate.nemesis.common;

import gamers.associate.nemesis.action.ActionFuture;
import gamers.associate.nemesis.action.IAction;
import gamers.associate.nemesis.ia.Action;
import gamers.associate.nemesis.ia.ActionMove;
import gamers.associate.nemesis.ia.Npc;
import gamers.associate.nemesis.map.Map;
import gamers.associate.nemesis.map.World;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

public class Player extends Npc implements  InputProcessor {

	private boolean isSelectMode;
	private IAction currentAction;
	private BasicShape target;

	public Player(float x, float y, float width, float height, Color color,
			String name) {
		super(x, y, width, height, color, name);
		// TODO Auto-generated constructor stub
		Gdx.input.setInputProcessor(this);
		
		writeChoices = true;
	}
	
	

	@Override
	public void step(float delta) {
		this.handleInput();
		super.step(delta);
	}

	private void handleInput() {
		if (Gdx.input.isKeyPressed(Input.Keys.R)) {
        	this.isSelectMode = true;
        	this.currentAction = new ActionFuture();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
        	this.currentAction = null;
        	this.isSelectMode = false;        
        }
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
			
			
            Vector2 pos = World.get().getWorldPos(screenX, screenY);            

            
            if (rightClickAction != null) {
            	rightClickAction.cancelAction();
            }
            
            rightClickAction = new ActionMove(this, rootAction, pos);						
    		rootAction.addAction(rightClickAction);
    		
        }
		
		if (button == Buttons.LEFT) {
			if (this.target != null) {
				this.target.setTargeted(false);
			}
			this.target = World.get().getTarget(screenX, screenY);
			if (this.target != null) {
				this.target.setTargeted(true);
			}
			
			if (this.currentAction != null) {
				this.currentAction.Do(this.target);
			}
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
