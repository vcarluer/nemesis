package gamers.associate.nemesis.ia;

import gamers.associate.nemesis.common.GameItem;

// Memory item is a snapshot of GameItem
public class MemoryItem {
	private String id;
	private long memoryStamp;
	private float memorizedX;
	private float memorizedY;
	private GameItem targetItem; // live item so be careful to now unnowable properties
	
	public GameItem getItem() {
		return targetItem;
	}
	public void setItem(GameItem item) {
		this.targetItem = item;
	}
	public long getMemoryStamp() {
		return memoryStamp;
	}
	public void setMemoryStamp(long memoryStamp) {
		this.memoryStamp = memoryStamp;
	}
}
