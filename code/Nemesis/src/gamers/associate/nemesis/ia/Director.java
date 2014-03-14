package gamers.associate.nemesis.ia;

import gamers.associate.nemesis.common.Player;
import gamers.associate.nemesis.map.Map;
import gamers.associate.nemesis.map.World;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class Director {
	private List<Npc> npcs;
	private Map map;
	private Npc shoty;
	private Player silk;
	
	public Director(Map map) {
		npcs = new ArrayList<Npc>();
		this.map = map;
		initNpcs();
		initPlayer();
	}
	
	public void step(float delta) {
		for (Npc npc : npcs) {
			npc.step(delta);
		}
		silk.step(delta);
	}
	
	public void render(ShapeRenderer renderer) {
		for (Npc npc : npcs) {
			npc.render(renderer);
		}
		silk.render(renderer);
	}
	
	private void initNpcs() {
		Vector2 pos = this.map.getPlayerStart();
		shoty = new Npc(pos.x, pos.y, 0.5f, 1f, Color.GREEN, "shoty");
		shoty.create();
		World.get().addNpc(shoty);
		npcs.add(shoty);
		
	}
	
	private void initPlayer() {
		Vector2 pos = this.map.getPlayerStart();
		silk = new Player(pos.x, pos.y, 1f, 1f, Color.RED, "silk");
		World.get().setPlayer(silk);
		//npcs.add(shoty);
	}

	public void render(SpriteBatch batch) {
		for (Npc npc : npcs) {
			npc.render(batch);
		}	
		silk.render(batch);
	}
}
