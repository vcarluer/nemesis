package gamers.associate.nemesis.ia;

import com.badlogic.gdx.graphics.Color;

import gamers.associate.nemesis.common.BasicShape;

public class Npc extends BasicShape {
	private String name;	
	
	public Npc(float x, float y, float width, float height, Color color, String name) {
		super(x, y, width, height, color);
		this.name = name;
	}
	
	public void step(float delta) {
		
	}	
}
