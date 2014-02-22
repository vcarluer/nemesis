package gamers.associate.nemesis.ia;

import gamers.associate.nemesis.map.Map;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class Director {
	private List<Npc> npcs;
	private Map map;
	private Npc shoty;
	
	public Director(Map map) {
		npcs = new ArrayList<Npc>();
		this.map = map;
		initNpcs();
	}
	
	public void step(float delta) {
		for (Npc npc : npcs) {
			npc.step(delta);
		}
	}
	
	public void render(ShapeRenderer renderer) {
		for (Npc npc : npcs) {
			npc.render(renderer);
		}
	}
	
	private void initNpcs() {
		Vector2 pos = this.map.getPlayerStart();
		shoty = new Npc(pos.x, pos.y, 0.5f, 1f, Color.GREEN, "shoty");
		npcs.add(shoty);
	}
}
