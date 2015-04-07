package gamers.associate.nemesis.ui;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Renderer {
	private List<BasicShapeRenderer> renderers;
	private List<ActionChoiceRenderer> choiceRenderers;
		
	public Renderer() {
		renderers = new ArrayList<BasicShapeRenderer>();
		choiceRenderers = new ArrayList<ActionChoiceRenderer>();
	}
	
	public void render(ShapeRenderer renderer) {
		for (BasicShapeRenderer rend : renderers) {
			rend.render(renderer);
		}
	}
	
	public void render(SpriteBatch batch, CameraManager cameraManager) {
		for (ActionChoiceRenderer choice : choiceRenderers) {
			choice.render(batch, cameraManager);
		}
	}
	
	public void add(BasicShapeRenderer renderer) {
		renderers.add(renderer);
	}
	
	public void add(ActionChoiceRenderer renderer) {
		choiceRenderers.add(renderer);
	}
}
