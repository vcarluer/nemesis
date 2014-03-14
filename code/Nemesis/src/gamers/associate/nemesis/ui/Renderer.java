package gamers.associate.nemesis.ui;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Renderer {
	private List<BasicShapeRenderer> renderers;
	private static Renderer instance;
	
	public static Renderer get() {
		if (instance == null) {
			instance = new Renderer();
		}
		
		return instance;
	}
	
	protected Renderer() {
		renderers = new ArrayList<BasicShapeRenderer>();
	}
	
	public void render(ShapeRenderer renderer) {
		for (BasicShapeRenderer rend : renderers) {
			rend.render(renderer);
		}
	}
	
	public void add(BasicShapeRenderer renderer) {
		renderers.add(renderer);
	}
}
