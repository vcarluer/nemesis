package gamers.associate.nemesis.map;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Map {
	private List<Room> rooms;
	
	public Map()
	{
		rooms = new ArrayList<Room>();
		build();
	}
	
	public void render(ShapeRenderer renderer) {
		for (Room room : rooms) {
			room.render(renderer);
		}
	}
	
	private void build() {
		Room room1 = new Room(0, 0, 50, 100, Color.RED);
		Room room2 = new Room(50, 50, 100, 50, Color.BLUE);
		
		rooms.add(room1);
		rooms.add(room2);
	}		
}
