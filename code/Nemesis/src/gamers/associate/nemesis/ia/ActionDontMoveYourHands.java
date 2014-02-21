package gamers.associate.nemesis.ia;

import java.util.EnumSet;

public class ActionDontMoveYourHands extends Action {

	@Override
	public void step(float delta) {	
	}

	@Override
	protected EnumSet<BodyConstraint> createBodyConstraints() {
		return EnumSet.of(BodyConstraint.Hands);
	}

}
