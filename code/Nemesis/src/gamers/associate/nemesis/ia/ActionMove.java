package gamers.associate.nemesis.ia;

import java.util.EnumSet;

import com.badlogic.gdx.math.Vector2;

public class ActionMove extends ActionSustained {

	public ActionMove(Npc npc, Vector2 target) {
		super(npc);
	}
	
	@Override
	protected float getSpeed() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected void action() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected EnumSet<BodyConstraint> createBodyConstraints() {
		// TODO Auto-generated method stub
		return null;
	}

}
