package gamers.associate.nemesis.common;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;

public abstract class BasicShape extends GameItem {
	private Rectangle rect;	
	private boolean isTargeted;

	public BasicShape(float x, float y, float width, float height) { 
		super(x, y);
		
		setRect(new Rectangle(x, y, width, height));
	}
	
	public float getWidth(){
		return this.getRect().width;
	}
	
	public float getHeight(){
		return this.getRect().height;
	}

	public Rectangle getRect() {
		return rect;
	}

	public void setRect(Rectangle rect) {
		this.rect = rect;
	}

	public boolean isTargeted() {
		return isTargeted;
	}

	public void setTargeted(boolean isTargeted) {
		this.isTargeted = isTargeted;
	}
}
