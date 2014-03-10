package gamers.associate.nemesis.map;

import gamers.associate.nemesis.common.GameItem;

import java.util.ArrayList;
import java.util.List;

public class World {
	private List<GameItem> items;
	private List<Boolean> walls;
	
	
	private static World world;
	
	public static World get() {
		if (world == null) {
			world = new World();
		}
		
		return world;
	}
	
	private World() {
		items = new ArrayList<GameItem>();
	}

}
