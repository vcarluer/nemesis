package gamers.associate.nemesis.ia;

import gamers.associate.nemesis.common.GameItem;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public abstract class Action {
	protected String id;	
	protected Npc npc;
	protected EnumSet<BodyConstraint> bodyConstraints;
	protected boolean Repeatable;
	protected List<IAssert> conditions;	
	protected List<IAssert> exitConditions;
	protected float preAnimationValue;
	protected float postAnimationValue;
	protected float animationValue; // 0 if instant type
	protected float currentValue;
	protected List<Action> childActions;
	
	public Action(Npc npc) {
		conditions = new ArrayList<IAssert>();	
		exitConditions = new ArrayList<IAssert>();
		childActions = new ArrayList<Action>();
		bodyConstraints = createBodyConstraints();
		this.npc = npc;
	}
	
	// Return true if 
	public abstract void step(float delta);
	
	protected abstract EnumSet<BodyConstraint> createBodyConstraints();
	
	protected void addExitConditions(IAssert condition) {
		exitConditions.add(condition);
	}
	
	public void choiceActions(ActionChoice choice) {
		if (childActions.size() > 0) {
			for (Action action : childActions) {
				if (choice.isChoiceDone()) break;
				action.choiceActions(choice);
			}
		} else {
			if (conditionsOK()) {
				if (choice.getPositionAction() == null && bodyConstraints.contains(BodyConstraint.Position)) {
					choice.setPositionAction(this);
				}
				
				if (choice.getHandsAction() == null && bodyConstraints.contains(BodyConstraint.Hands)) {
					choice.setHandsAction(this);
				}
				
				if (choice.getHeadAction() == null && bodyConstraints.contains(BodyConstraint.Head)) {
					choice.setHeadAction(this);
				}
			} else {
				// If a higher level move to do is known cancel other actions to move
				if (choice.getPositionAction() == null && bodyConstraints.contains(BodyConstraint.Position)) {
					choice.setPositionAction(new ActionMoveStay(npc));
				}
			}
		}
	}
	
	protected boolean conditionsOK() {
		boolean ok = true;
		for (IAssert condition : conditions) {
			ok = condition.Assert();
			if (!ok) break;
		}
		
		return ok;
	}
}
