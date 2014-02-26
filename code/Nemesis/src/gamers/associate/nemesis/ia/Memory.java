package gamers.associate.nemesis.ia;

import java.util.ArrayList;
import java.util.List;

public class Memory {
	private List<MemoryItem> items;
	private int memorySize;

	public Memory(int size) {
		items = new ArrayList<MemoryItem>();
		memorySize = size;
	}
	
	public void addItem(MemoryItem item) {
		items.add(0, item);
		if (items.size() > memorySize) {
			items.remove(items.size() - 1);
		}
	}	
}
