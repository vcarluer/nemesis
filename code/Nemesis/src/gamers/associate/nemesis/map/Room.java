package gamers.associate.nemesis.map;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class Room {
	private Rectangle rect;
	private Color color; 

	public Room(float x, float y, float width, float height, Color color) {
		rect = new Rectangle(x, y, width, height);
		this.color = color;
	}
	
	public void render(ShapeRenderer renderer) {
		renderer.setColor(color);
		renderer.rect(rect.x, rect.y, rect.width, rect.height);
	}
}
