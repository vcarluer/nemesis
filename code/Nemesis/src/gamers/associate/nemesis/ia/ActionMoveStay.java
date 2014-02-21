package gamers.associate.nemesis.ia;

import java.util.EnumSet;

public class ActionMoveStay extends Action {	
	@Override
	protected EnumSet<BodyConstraint> createBodyConstraints() {
		return EnumSet.of(BodyConstraint.Position);
	}

	@Override
	public void step(float delta) {
	}

}
