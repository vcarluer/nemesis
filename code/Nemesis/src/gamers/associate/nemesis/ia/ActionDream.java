package gamers.associate.nemesis.ia;

import java.util.EnumSet;

public class ActionDream extends Action {

	public ActionDream(Npc npc, Action parentAction) {
		super(npc, parentAction);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void step(float delta) {		
	}

	@Override
	protected EnumSet<BodyConstraint> createBodyConstraints() {
		return EnumSet.of(BodyConstraint.Head);
	}
}
