package gamers.associate.nemesis.ia;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class ActionThinkActions extends ActionSustained {
	protected List<Action> possibleActions;
	private ActionOperator childActionsOperator;
	protected int thinkComplexity;
	
	public ActionThinkActions(Npc npc, Action parentAction) {
		super(npc, parentAction);
		possibleActions = createPossibleActions();
		setChildActionsOperator(ActionOperator.AND);
		
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
	protected void action() {
		if (possibleActions.size() > 0) {
			if (getChildActionsOperator() == ActionOperator.AND) {
				for (Action action : possibleActions) {
					childActions.add(action);
				}
			}
			
			if (getChildActionsOperator() == ActionOperator.OR) {
				// for now we take always the first strategy
				childActions.add(possibleActions.get(0));
			}
		}	
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

	public ActionOperator getChildActionsOperator() {
		return childActionsOperator;
	}

	public void setChildActionsOperator(ActionOperator childActionsOperator) {
		this.childActionsOperator = childActionsOperator;
	}
}
