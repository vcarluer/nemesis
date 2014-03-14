package gamers.associate.nemesis.action;

import gamers.associate.nemesis.NemesisGame;
import gamers.associate.nemesis.common.Cloner;
import gamers.associate.nemesis.common.GameItem;
import gamers.associate.nemesis.ia.Director;
import gamers.associate.nemesis.map.Map;
import gamers.associate.nemesis.map.World;

public class ActionFuture implements IAction {

	public ActionFuture() {
	}

	public void Do(GameItem target) {
		World base = World.get();
		World futureWorld = Cloner.copy(base);
		Director futureDirector = new Director(Map.get(), futureWorld);
		float step = 0.1f;
		for (float delta = 0; delta < 8.0f; delta += step) {
			futureDirector.step(step);
		}
		
		futureDirector.setLifetime(4f);
		
		futureDirector.initRenderer();
		NemesisGame.get().setFutureDirector(futureDirector);
	}
}
