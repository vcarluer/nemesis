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
		float speed = 8f;
		float gap = 0.0f * speed;
		float duration = 3f;
		for (float delta = 0; delta < gap; delta += step) {
			futureDirector.step(step);
		}
		
		futureDirector.setLifetime(duration);
		futureDirector.setSpeedFactor(speed);
		
		futureDirector.initRenderer();
		NemesisGame.get().setFutureDirector(futureDirector);
	}
}
