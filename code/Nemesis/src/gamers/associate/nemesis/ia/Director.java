package gamers.associate.nemesis.ia;

import gamers.associate.nemesis.NemesisGame;
import gamers.associate.nemesis.common.GameItem;
import gamers.associate.nemesis.common.Player;
import gamers.associate.nemesis.map.Map;
import gamers.associate.nemesis.map.World;
import gamers.associate.nemesis.ui.ActionChoiceRenderer;
import gamers.associate.nemesis.ui.BasicShapeRenderer;
import gamers.associate.nemesis.ui.Renderer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;

public class Director {
	private Map map;	
	private World world;
	private Renderer renderer;
	private float age;
	private float lifetime;
	private boolean dead;
	
	public Director(Map map, World world) {		
		this.map = map;
		this.world = world;	
		renderer = new Renderer();
	}
	
	public Director(Map map, World world, float life) {
		this(map, world);
		this.lifetime = life;
	}
		
	public void initFromMap() {
		initNpcs();
		initPlayer();
	}
	
	public void initRenderer() {
		for (Npc npc : world.getNpcs()) {
			Color color = Color.GREEN;
			if (npc.getId().equals("shoty")) {
				color = Color.RED;
			}
			
			BasicShapeRenderer render = new BasicShapeRenderer(npc, color);
			renderer.add(render);	
			ActionChoiceRenderer choiceR = new ActionChoiceRenderer(npc.getActionChoice());
			renderer.add(choiceR);
		}		
	}
	
	public void step(float delta) {
		if (lifetime > 0) {
			age += delta;
			if (age > lifetime) {
				dead = true;
				NemesisGame.get().setFutureDirector(null);				
			}
		}
		
		if (!dead) {
			for (GameItem item : world.getDynamicItems().values()) {
				item.step(delta);
			}
		}
	}
	
	private void initNpcs() {
		Vector2 pos = this.map.getPlayerStart();
		Npc shoty = new Npc(pos.x, pos.y, 0.5f, 1f, Color.GREEN, "shoty");		
		shoty.create();
		world.addNpc(shoty);
	}
	
	private void initPlayer() {
		Vector2 pos = this.map.getPlayerStart();
		Player silk = new Player(pos.x, pos.y, 1f, 1f, Color.RED, "silk");		
		world.setPlayer(silk);
	}
	
	public Renderer getRenderer() {
		return renderer;
	}

	public void render(ShapeRenderer shapeRenderer) {
		if (lifetime > 0) {			
			Gdx.gl.glEnable(GL10.GL_BLEND);			
			// Gdx.gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
			Gdx.gl.glBlendFunc(GL10.GL_ONE, GL10.GL_ONE);
			shapeRenderer.begin(ShapeType.Filled);
			shapeRenderer.setColor(new Color(0.4f, 0.4f, 0.4f, 0.3f));
			shapeRenderer.rect(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
			shapeRenderer.end();
			Gdx.gl.glDisable(GL10.GL_BLEND);
		}
	}
}
