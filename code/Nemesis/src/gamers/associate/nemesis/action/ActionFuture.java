package gamers.associate.nemesis.action;

import gamers.associate.nemesis.common.Cloner;
import gamers.associate.nemesis.common.GameItem;
import gamers.associate.nemesis.map.World;

public class ActionFuture implements IAction {

	public ActionFuture() {
	}

	public void Do(GameItem target) {
		World base = World.get();
		World world = Cloner.copy(base);
	}

}
