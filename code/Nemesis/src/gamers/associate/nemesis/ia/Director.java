package gamers.associate.nemesis.ia;

import gamers.associate.nemesis.map.Map;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Director {
	private List<Npc> npcs;
	private Map map;
	
	public Director(Map map) {
		npcs = new ArrayList<Npc>();
		this.map = map;
		initNpcs();
	}
	
	public void render(ShapeRenderer renderer) {
		for (Npc npc : npcs) {
			npc.render(renderer);
		}
	}
	
	private void initNpcs() {
		Node pos = this.map.getPlayerStart();
		Npc shoty = new Npc(pos.x, pos.y, 0.5f, 1f, Color.GREEN, "shoty");
		npcs.add(shoty);
	}
}
