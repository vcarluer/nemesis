package gamers.associate.nemesis.ia;

public abstract class ActionSustained extends Action {
	public ActionSustained(Npc npc) {
		super(npc);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void step(float delta) {
		currentValue = delta * getSpeed();
		if (currentValue > animationValue) {
			action();
		}
	}		

	protected abstract float getSpeed();
	
	protected abstract void action();
}
