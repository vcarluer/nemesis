package gamers.associate.nemesis.action;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

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
		
		GameItem newTarget = futureWorld.getDynamicItems().get(target.getId());
		
		Director futureDirector = new Director(Map.get(), futureWorld);
		futureDirector.getCameraManager().setFollow(newTarget);
		Rectangle glViewport = futureDirector.getCameraManager().getGlViewport();
		glViewport.width = Gdx.graphics.getWidth() / 3f;
		glViewport.height = Gdx.graphics.getHeight() / 3f;
		glViewport.y = Gdx.graphics.getHeight() - glViewport.height;
		futureDirector.getCameraManager().cam.zoom += 0.5f;		
		
		float step = 0.1f;
		float speed = 1f;
		float gap = 15.0f * speed;
		float duration = 6f;
		for (float delta = 0; delta < gap; delta += step) {
			futureDirector.step(step);
		}
		
		futureDirector.setLifetime(duration);
		futureDirector.setSpeedFactor(speed);
		
		futureDirector.initRenderer();
		NemesisGame.get().setFutureDirector(futureDirector);
	}
}
