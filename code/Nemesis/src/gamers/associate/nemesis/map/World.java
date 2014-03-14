package gamers.associate.nemesis.map;

import gamers.associate.nemesis.common.BasicShape;
import gamers.associate.nemesis.common.GameItem;
import gamers.associate.nemesis.common.Player;
import gamers.associate.nemesis.ia.Npc;
import gamers.associate.nemesis.ui.CameraManager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class World implements Serializable {
	private List<GameItem> items;
	private Player player;
	private List<Npc> npcs;	
	private HashMap<String, GameItem> dynamicItems;
	private List<BasicShape> targetableItems;
	
	private static World world;
	
	public static World get() {
		if (world == null) {
			world = new World();
		}
		
		return world;
	}
	
	private World() {
		items = new ArrayList<GameItem>();
		setNpcs(new ArrayList<Npc>());
		setDynamicItems(new HashMap<String, GameItem>());
		targetableItems = new ArrayList<BasicShape>();
	}
	
	public void addNpc(Npc npc) {
		this.getNpcs().add(npc);
		addItem(npc);
		addTargetableItem(npc);
		addDynamicItem(npc);
	}
	
	public void setPlayer(Player player) {
		this.player = player;
		addNpc(player);
	}
		
	private void addItem(GameItem item) {
		items.add(item);
	}		
	
	private void addDynamicItem(GameItem item) {
		getDynamicItems().put(item.getId(), item);
	}
	
	private void addTargetableItem(BasicShape item) {
		targetableItems.add(item);
	}
	
	public BasicShape getTarget(int screenX, int screenY) {
		Vector2 pos = getWorldPos(screenX, screenY);
		BasicShape target = null;
		for (BasicShape item : targetableItems) {
			if (item.getRect().contains(pos)) {
				target = item;
				break;
			}
		}
		
		return target;
	}
	
	public Vector2 getWorldPos(int screenX, int screenY) {
		Vector2 pos = new Vector2();
		pos.x = CameraManager.get().getX() + (screenX / Map.TILE_SIZE);
		pos.y = CameraManager.get().getY() + ((Gdx.graphics.getHeight() - screenY) / Map.TILE_SIZE);
		return pos;
	}

	public HashMap<String, GameItem> getDynamicItems() {
		return dynamicItems;
	}

	public void setDynamicItems(HashMap<String, GameItem> dynamicItems) {
		this.dynamicItems = dynamicItems;
	}

	public List<Npc> getNpcs() {
		return npcs;
	}

	public void setNpcs(List<Npc> npcs) {
		this.npcs = npcs;
	}
}
