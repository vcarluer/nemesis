package gamers.associate.nemesis.record;

import gamers.associate.nemesis.common.GameItem;
import gamers.associate.nemesis.map.World;

import java.util.HashMap;

public class Recorder {
	private HashMap<Long, Record> records;
	
	public Recorder() {
		records = new HashMap<Long, Record>();
	}
	
	public void addRecord(long timems, Record record) {
		records.put(timems, record);
	}
	
	public void Record(World world) {		
		for (GameItem item : world.getDynamicItems().values()) {
			Record record = new Record(item.getId());
			record.getPosRecord().setPos(item.getPos());
		}
	}
}
