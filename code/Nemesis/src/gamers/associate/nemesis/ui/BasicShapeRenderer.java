package gamers.associate.nemesis.ui;

import gamers.associate.nemesis.common.BasicShape;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class BasicShapeRenderer {
	private BasicShape basicShape;
	private Color color;
	
	public BasicShapeRenderer(BasicShape shape, Color color) {
		this.color = color;
		basicShape = shape;
	}
	
	public void render(ShapeRenderer renderer) {
		basicShape.getRect().x = basicShape.getX() - basicShape.getRect().width / 2f;		
		basicShape.getRect().y = basicShape.getY() - basicShape.getRect().height / 2f;
		
		Color renderColor = new Color(color);
		if (basicShape.isTargeted()) {
			renderColor.b = 0.3f;
		}
		
		renderer.setColor(renderColor);
		renderer.rect(basicShape.getRect().x, basicShape.getRect().y, basicShape.getRect().width, basicShape.getRect().height);
	}
}
