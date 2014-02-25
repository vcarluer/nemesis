package gamers.associate.nemesis.common;

import gamers.associate.nemesis.map.Map;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public abstract class BasicShape extends GameItem {
	private Rectangle rect;
	private Color color; 

	public BasicShape(float x, float y, float width, float height, Color color) { 
		super(x, y);
		
		rect = new Rectangle(x, y, width, height);
		this.color = color;
	}
	
	public void render(ShapeRenderer renderer) {
		rect.x = this.getX() - rect.width / 2f;		
		rect.y = this.getY() - rect.height / 2f;
		
		renderer.setColor(color);
		renderer.rect(rect.x, rect.y, rect.width, rect.height);
	}
	
	public float getWidth(){
		return this.rect.width;
	}
	
	public float getHeight(){
		return this.rect.height;
	}
}
