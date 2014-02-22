package gamers.associate.nemesis.ia;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import gamers.associate.nemesis.common.BasicShape;
import gamers.associate.nemesis.map.Map;

public class Npc extends BasicShape {
	private String name;	
	private float thinkSpeed;
	private float moveSpeed;
	
	private Action rootAction;
	private ActionChoice actionChoice;
	
	private Memory memory;
	
	public Npc(float x, float y, float width, float height, Color color, String name) {
		super(x, y, width, height, color);
		this.name = name;
		
		thinkSpeed = 1000; // 2 actions per second
		moveSpeed = 5f; // 1 tile per second
		
		// To be replace by dedicated class behavior
		// If rootAction is a think action actionchoice will return only head behavior (not a pb)
		ActionThinkActions think = new ActionThinkActions(this, null);
		ActionMove move = new ActionMove(this, think, Map.get().getPlayerTarget());
		ActionIdle idle = new ActionIdle(this, think);						
		think.addAction(move);		
		think.addAction(idle);
		rootAction = think;
		actionChoice = new ActionChoice();
		
		memory = new Memory();
	}
	
	
	
	public void step(float delta) {
		actionChoice.reset();
		if (rootAction != null) {
			rootAction.choiceActions(actionChoice);
		}
		
		actionChoice.step(delta);
	}

	public float getThinkSpeed() {
		return thinkSpeed;
	}

	public void setThinkSpeed(float thinkSpeed) {
		this.thinkSpeed = thinkSpeed;
	}

	public float getMoveSpeed() {
		return moveSpeed;
	}

	public void setMoveSpeed(float moveSpeed) {
		this.moveSpeed = moveSpeed;
	}

	public void render(SpriteBatch batch) {
		actionChoice.render(batch);
	}	
}
