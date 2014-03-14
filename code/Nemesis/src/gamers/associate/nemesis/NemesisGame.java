package gamers.associate.nemesis;

import java.nio.Buffer;
import java.nio.ByteBuffer;

import gamers.associate.nemesis.ia.Director;
import gamers.associate.nemesis.map.Map;
import gamers.associate.nemesis.map.World;
import gamers.associate.nemesis.ui.CameraManager;
import gamers.associate.nemesis.ui.Renderer;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.ScreenUtils;

public class NemesisGame implements ApplicationListener {
	private CameraManager camera;
	private SpriteBatch batch;
	private ShapeRenderer shapeRenderer;
	private Director director;
	private Director futureDirector;
	
	private static NemesisGame game;
	
	public static NemesisGame get() {
		return game;
	}
		
	@Override
	public void create() {
		game = this;
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		
		
		camera = CameraManager.get();
		
		batch = new SpriteBatch();
			
		shapeRenderer = new ShapeRenderer();
				
		director = new Director(Map.get(), World.get());
		director.initFromMap();
		director.initRenderer();
	}

	@Override
	public void dispose() {
		batch.dispose();
		// texture.dispose();
	}

	@Override
	public void render() {
		
		camera.render();
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
					
		Director dir = director;
		if (futureDirector != null) {
			dir = futureDirector;
		}
		
		dir.step(Gdx.graphics.getDeltaTime());
		batch.setProjectionMatrix(camera.cam.combined);
				
		Map.get().renderFloor(camera.cam);		
		
		shapeRenderer.setProjectionMatrix(camera.cam.combined);
		shapeRenderer.begin(ShapeType.Filled);
		dir.getRenderer().render(shapeRenderer);
		shapeRenderer.end();
		
		Map.get().renderFront();
		
		batch.begin();
		dir.getRenderer().render(batch);
		batch.end();
		
		dir.render(shapeRenderer);		
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	public Director getFutureDirector() {
		return futureDirector;
	}

	public void setFutureDirector(Director futureDirector) {
		this.futureDirector = futureDirector;
	}
}
