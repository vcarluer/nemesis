package gamers.associate.nemesis.ia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public abstract class Action implements Serializable {
	private String id;	
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
	protected Action parentAction;
	
	public Action(Npc npc, Action parentAction) {
		conditions = new ArrayList<IAssert>();	
		exitConditions = new ArrayList<IAssert>();
		childActions = new ArrayList<Action>();
		bodyConstraints = createBodyConstraints();
		this.npc = npc;
		this.parentAction = parentAction;
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
					choice.setPositionAction(new ActionMoveStay(npc, this));
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
	
	public void notifyActionEnd(Action action) {		
	}
	
	protected void notifyEndToParent() {
		if (parentAction != null) {
			parentAction.notifyActionEnd(this);
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public void cancelAction() {
		this.notifyEndToParent();
	}
}
