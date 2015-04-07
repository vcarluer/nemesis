package gamers.associate.nemesis.common;

import gamers.associate.nemesis.ia.Action;
import gamers.associate.nemesis.ia.ActionMove;
import gamers.associate.nemesis.ia.Npc;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

public class Player extends Npc {


	public Player(float x, float y, float width, float height, Color color,
			String name) {
		super(x, y, width, height, color, name);		
		
		writeChoices = true;
	}	

	@Override
	public void step(float delta) {
		super.step(delta);
	}

	private Action rightClickAction;
	
	@Override
	public void notifyActionEnd(Action action) {
		super.notifyActionEnd(action);
		if (action == rightClickAction) {
			rightClickAction = null;
		}
	}

	public void moveTo(Vector2 pos) {
		if (rightClickAction != null) {
			rightClickAction.cancelAction();
		}
		
		rightClickAction = new ActionMove(this, rootAction, pos);						
		rootAction.addAction(rightClickAction);
	}

}
