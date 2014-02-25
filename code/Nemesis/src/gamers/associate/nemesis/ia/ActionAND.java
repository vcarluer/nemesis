package gamers.associate.nemesis.ia;

public class ActionAND extends ActionThinkActions {

	public ActionAND(Npc npc, Action parentAction) {
		super(npc, parentAction);
	}
	
	@Override
	protected void action() {
		for (Action action : possibleActions) {
			childActions.add(action);
		}	
	}
}
