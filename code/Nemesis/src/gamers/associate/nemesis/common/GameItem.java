package gamers.associate.nemesis.common;

public class GameItem {
	private String id;
	private float x;
	private float y;
	
	public GameItem(float x, float y) {
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
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
}
