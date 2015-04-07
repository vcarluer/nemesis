package gamers.associate.nemesis.ui;

import gamers.associate.nemesis.action.ActionFuture;
import gamers.associate.nemesis.action.IAction;
import gamers.associate.nemesis.common.BasicShape;
import gamers.associate.nemesis.common.Player;
import gamers.associate.nemesis.ia.Action;
import gamers.associate.nemesis.ia.ActionMove;
import gamers.associate.nemesis.ia.Director;
import gamers.associate.nemesis.map.Map;
import gamers.associate.nemesis.map.World;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class InputManager implements  InputProcessor {
	private Director director;

	private boolean isSelectMode;
	private IAction currentAction;
	private BasicShape target;
	private float rotationSpeed;	
	
    public InputManager(Director director) {
    	this.director = director;
    	Gdx.input.setInputProcessor(this);
    	rotationSpeed = 0.3f;
    }
    
    public void step() {
        handleInput();  
    }

    private void handleInput() {
        if(Gdx.input.isKeyPressed(Input.Keys.A)) {
            director.getCameraManager().cam.zoom += 0.02;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.Q)) {
        	director.getCameraManager().cam.zoom -= 0.02;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            if (director.getCameraManager().cam.position.x > 0)
            	director.getCameraManager().cam.translate(-3, 0, 0);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            if (director.getCameraManager().cam.position.x < 1024)
            	director.getCameraManager().cam.translate(3, 0, 0);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            if (director.getCameraManager().cam.position.y > 0)
            	director.getCameraManager().cam.translate(0, -3, 0);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
            if (director.getCameraManager().cam.position.y < 1024)
            	director.getCameraManager().cam.translate(0, 3, 0);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.W)) {
        	director.getCameraManager().cam.rotate(-rotationSpeed, 0, 0, 1);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.E)) {
        	director.getCameraManager().cam.rotate(rotationSpeed, 0, 0, 1);
        }        
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
	
	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {		
		if(button == Buttons.RIGHT){
			Player player = director.getWorld().getPlayer();
			
            Vector2 pos = director.getWorldPos(screenX, screenY);            
            player.moveTo(pos);
        }
		
		if (button == Buttons.LEFT) {
			if (this.target != null) {
				this.target.setTargeted(false);
			}
			
			Vector2 targetPos = director.getWorldPos(screenX, screenY);
			this.target = director.getWorld().getTarget(targetPos);
			if (this.target != null) {
				this.target.setTargeted(true);
				if (this.currentAction != null) {
					this.currentAction.Do(this.target);
				}
			}					
		}
        
        return false;
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
