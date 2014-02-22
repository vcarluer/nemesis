package gamers.associate.nemesis.ia;

import java.util.EnumSet;

public class ActionIdle extends Action {

	public ActionIdle(Npc npc, Action parentAction) {
		super(npc, parentAction);
		setId("Idle");
	}

	@Override
	public void step(float delta) {		
	}

	@Override
	protected EnumSet<BodyConstraint> createBodyConstraints() {
		return EnumSet.of(BodyConstraint.Position, BodyConstraint.Hands, BodyConstraint.Head);
	}

}
