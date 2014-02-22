package gamers.associate.nemesis;

import gamers.associate.nemesis.ia.Director;
import gamers.associate.nemesis.map.Map;
import gamers.associate.nemesis.map.Room;
import gamers.associate.nemesis.ui.CameraManager;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class NemesisGame implements ApplicationListener {
	private CameraManager camera;
	private SpriteBatch batch;
	/*private Texture texture;
	private Sprite sprite;*/
	private ShapeRenderer shapeRenderer;
	private Director director;
		
	@Override
	public void create() {		
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		
		
		camera = CameraManager.get();
		
		batch = new SpriteBatch();
		
		/*texture = new Texture(Gdx.files.internal("data/libgdx.png"));
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		TextureRegion region = new TextureRegion(texture, 0, 0, 512, 275);
		
		sprite = new Sprite(region);
		sprite.setSize(0.9f, 0.9f * sprite.getHeight() / sprite.getWidth());
		sprite.setOrigin(sprite.getWidth()/2, sprite.getHeight()/2);
		sprite.setPosition(-sprite.getWidth()/2, -sprite.getHeight()/2);*/
		
		shapeRenderer = new ShapeRenderer();
				
		director = new Director(Map.get());
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
	
		director.step(Gdx.graphics.getDeltaTime());
		batch.setProjectionMatrix(camera.cam.combined);
				
		Map.get().renderFloor(camera.cam);
		
		shapeRenderer.setProjectionMatrix(camera.cam.combined);
		shapeRenderer.begin(ShapeType.Filled);
		director.render(shapeRenderer);
		shapeRenderer.end();
		
		Map.get().renderFront();
		
		batch.begin();
		director.render(batch);
		batch.end();		
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
}
