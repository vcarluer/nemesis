package gamers.associate.nemesis.common;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public abstract class BasicShape extends GameItem {
	private Rectangle rect;
	private Color color; 
	private boolean isTargeted;

	public BasicShape(float x, float y, float width, float height, Color color) { 
		super(x, y);
		
		setRect(new Rectangle(x, y, width, height));
		this.color = color;
	}
	
	public void render(ShapeRenderer renderer) {
		getRect().x = this.getX() - getRect().width / 2f;		
		getRect().y = this.getY() - getRect().height / 2f;
		
		Color renderColor = new Color(color);
		if (this.isTargeted) {
			renderColor.b = 0.3f;
		}
		
		renderer.setColor(renderColor);
		renderer.rect(getRect().x, getRect().y, getRect().width, getRect().height);
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
