package gamers.associate.nemesis.ia;

public class ActionMultiplexer extends ActionThinkActions {

	public ActionMultiplexer(Npc npc, Action parentAction) {
		super(npc, parentAction);
		animationValue = 0;
	}

	@Override
	public void addAction(Action action) {
		childActions.add(0, action);
	}

	@Override
	protected void action() {
	}

	@Override
	public void notifyActionEnd(Action action) {
		super.notifyActionEnd(action);
		npc.notifyActionEnd(action);
	}
}
