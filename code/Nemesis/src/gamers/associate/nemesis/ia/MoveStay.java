package gamers.associate.nemesis.ia;

import java.util.EnumSet;

public class MoveStay extends ActionSustained {
	@Override
	protected float getSpeed() {
		return 0;
	}

	@Override
	protected void action() {		
	}

	@Override
	protected EnumSet<BodyConstraint> createBodyConstraints() {
		return EnumSet.of(BodyConstraint.Position);
	}

}
