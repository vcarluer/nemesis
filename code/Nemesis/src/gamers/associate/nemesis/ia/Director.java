package gamers.associate.nemesis.ia;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Director {
	private List<Npc> npcs;
	
	public Director() {
		npcs = new ArrayList<Npc>();
		initNpcs();
	}
	
	public void render(ShapeRenderer renderer) {
		for (Npc npc : npcs) {
			npc.render(renderer);
		}
	}
	
	private void initNpcs() {
		Npc shoty = new Npc(25, 25, 16, 32, Color.GREEN, "shoty");
		npcs.add(shoty);
	}
}
