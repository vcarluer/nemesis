package gamers.associate.nemesis.record;

public class Record {
	private String itemId;
	private PositionRecord posRecord;

	public Record(String id) {
		itemId = id;
		posRecord = new PositionRecord();
	}
	
	public PositionRecord getPosRecord() {
		return posRecord;
	}

	public void setPosRecord(PositionRecord posRecord) {
		this.posRecord = posRecord;
	}
}
