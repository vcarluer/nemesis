package gamers.associate.nemesis.ia;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import gamers.associate.nemesis.common.BasicShape;
import gamers.associate.nemesis.map.Map;

public class Npc extends BasicShape {
	private String name;	
	private float thinkSpeed;
	private float moveSpeed;
	
	public ActionMultiplexer rootAction;
	private ActionChoice actionChoice;
	
	private Memory memory;
	
	protected boolean writeChoices;
	protected int memorySize;
	
	public Npc(float x, float y, float width, float height, Color color, String name) {
		super(x, y, width, height);
		this.setId(name);
		this.name = name;
		
		thinkSpeed = 1000; // 2 actions per second
		moveSpeed = 1f; // 1 tile per second
		
		rootAction = new ActionMultiplexer(this, null);
		ActionIdle idle = new ActionIdle(this, rootAction);
		rootAction.addAction(idle);
		
		setActionChoice(new ActionChoice());
		memorySize = 100;
		memory = new Memory(memorySize);
		
	}
	
	public void create(){ 
		ActionMove move = new ActionMove(this, rootAction, Map.get().getPlayerTarget());
		rootAction.addAction(move);
	}
	
	public void notifyActionEnd(Action action) {
		
	}
	
	@Override
	public void step(float delta) {
		getActionChoice().reset();
		if (rootAction != null) {
			rootAction.choiceActions(getActionChoice());
		}
		
		getActionChoice().step(delta);
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

	public ActionChoice getActionChoice() {
		return actionChoice;
	}

	public void setActionChoice(ActionChoice actionChoice) {
		this.actionChoice = actionChoice;
	}
}
