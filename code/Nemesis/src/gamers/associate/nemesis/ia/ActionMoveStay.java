package gamers.associate.nemesis.ia;

import java.util.EnumSet;

public class ActionMoveStay extends Action {	
	public ActionMoveStay(Npc npc, Action parentAction) {
		super(npc, parentAction);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected EnumSet<BodyConstraint> createBodyConstraints() {
		return EnumSet.of(BodyConstraint.Position);
	}

	@Override
	public void step(float delta) {
	}

}
