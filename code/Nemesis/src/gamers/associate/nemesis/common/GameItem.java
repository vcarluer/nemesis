package gamers.associate.nemesis.common;

import java.io.Serializable;

import com.badlogic.gdx.math.Vector2;

public class GameItem implements Serializable {
	private String id;
	private Vector2 pos;
	
	public GameItem(float x, float y) {
		pos = new Vector2();
		setX(x);
		setY(y);
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public float getX() {
		return pos.x;
	}
	public void setX(float x) {
		this.pos.x = x;
	}
	public float getY() {
		return pos.y;
	}
	public void setY(float y) {
		this.pos.y = y;
	}
	
	public Vector2 getPos() {
		return pos;
	}
	
	public void step(float delta) {
	}
}
