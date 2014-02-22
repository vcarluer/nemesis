package gamers.associate.nemesis.ia;

import java.util.ArrayList;
import java.util.List;

public class Memory {
	private List<MemoryItem> items;

	public Memory() {
		items = new ArrayList<MemoryItem>();
	}
	
	public List<MemoryItem> getItems() {
		return items;
	}

	public void setItems(List<MemoryItem> items) {
		this.items = items;
	}
}
