package gamers.associate.nemesis.ia;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public abstract class ActionThinkActions extends ActionSustained {
	protected List<Action> possibleActions;
	protected int thinkComplexity;
	
	public ActionThinkActions(Npc npc, Action parentAction) {
		super(npc, parentAction);
		possibleActions = createPossibleActions();
		
		bodyConstraints = EnumSet.of(BodyConstraint.Head);
		
		thinkComplexity = definePossibleActionThinkTime();
		animationValue = possibleActions.size() * thinkComplexity;
	}
	
	protected int definePossibleActionThinkTime() {
		// 500 ms per possible action
		return 500;
	}
	
	@Override
	public void notifyActionEnd(Action action) {
		super.notifyActionEnd(action);
		childActions.remove(action);
		if (childActions.size() == 0) {
			notifyEndToParent();
		}
	}

	@Override
	protected EnumSet<BodyConstraint> createBodyConstraints() {
		return EnumSet.of(BodyConstraint.Head);
	}
	
	@Override
	protected float getSpeed() {
		return npc.getThinkSpeed(); 
	}
	
	protected List<Action> createPossibleActions() {
		return new ArrayList<Action>();
	}
	
	public void addAction(Action action) {
		possibleActions.add(action);
	}
}
