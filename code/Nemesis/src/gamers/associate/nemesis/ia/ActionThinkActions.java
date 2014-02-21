package gamers.associate.nemesis.ia;

import java.util.EnumSet;
import java.util.List;

public abstract class ActionThinkActions extends ActionSustained {
	protected List<Action> possibleActions;
	protected ActionOperator childActionsOperator;
	
	public ActionThinkActions() {
		possibleActions = createPossibleActions();
		childActionsOperator = ActionOperator.AND;
		
		bodyConstraints = EnumSet.of(BodyConstraint.Head);
		
		// by default 1 second by possible actions
		animationValue = possibleActions.size() * 1000;
	}
	
	@Override
	protected EnumSet<BodyConstraint> createBodyConstraints() {
		return EnumSet.of(BodyConstraint.Head);
	}
	
	@Override
	protected void action() {
		if (possibleActions.size() > 0) {
			if (childActionsOperator == ActionOperator.AND) {
				for (Action action : possibleActions) {
					childActions.add(action);
				}
			}
			
			if (childActionsOperator == ActionOperator.OR) {
				// for now we take always the first strategy
				childActions.add(possibleActions.get(0));
			}
		}	
	}

	@Override
	protected float getSpeed() {
		return npc.getThinkSpeed(); 
	}
	
	protected abstract List<Action> createPossibleActions();
}
