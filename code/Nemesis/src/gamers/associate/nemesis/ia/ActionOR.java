package gamers.associate.nemesis.ia;

public class ActionOR extends ActionThinkActions {

	public ActionOR(Npc npc, Action parentAction) {
		super(npc, parentAction);
	}

	@Override
	protected void action() {
		childActions.add(possibleActions.get(0));
	}

}
