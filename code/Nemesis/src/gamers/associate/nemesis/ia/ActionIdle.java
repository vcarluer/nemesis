package gamers.associate.nemesis.ia;

import java.util.EnumSet;

public class ActionIdle extends Action {

	public ActionIdle(Npc npc) {
		super(npc);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void step(float delta) {		
	}

	@Override
	protected EnumSet<BodyConstraint> createBodyConstraints() {
		return EnumSet.of(BodyConstraint.Position, BodyConstraint.Hands, BodyConstraint.Head);
	}

}
