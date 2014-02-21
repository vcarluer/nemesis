package gamers.associate.nemesis.ia;

import com.badlogic.gdx.graphics.Color;

import gamers.associate.nemesis.common.BasicShape;

public class Npc extends BasicShape {
	private String name;	
	private float thinkSpeed;
	private float moveSpeed;
	
	private Action rootAction;
	private ActionChoice actionChoice;
	
	public Npc(float x, float y, float width, float height, Color color, String name) {
		super(x, y, width, height, color);
		this.name = name;
		rootAction = new ActionIdle(this);
		actionChoice = new ActionChoice();
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
}
