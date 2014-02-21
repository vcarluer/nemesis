package gamers.associate.nemesis.ia;

public class ActionChoice {
	private Action positionAction;
	private Action handsAction;
	private Action headAction;
	public Action getPositionAction() {
		return positionAction;
	}
	public void setPositionAction(Action positionAction) {
		this.positionAction = positionAction;
	}
	public Action getHandsAction() {
		return handsAction;
	}
	public void setHandsAction(Action handsAction) {
		this.handsAction = handsAction;
	}
	public Action getHeadAction() {
		return headAction;
	}
	public void setHeadAction(Action headAction) {
		this.headAction = headAction;
	}
	
	public boolean isChoiceDone() {
		return positionAction != null && handsAction != null && headAction != null;
	}
}
