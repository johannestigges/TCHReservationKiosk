package de.tigges.TCHReservationKiosk;

public class Occupation {
	private long id;

	private String text;
	private Long date;
	private Long start;
	private int duration;

	private int court;
	private int lastCourt;

	private long systemConfigId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Long getDate() {
		return date;
	}

	public void setDate(Long date) {
		this.date = date;
	}

	public Long getStart() {
		return start;
	}

	public void setStart(Long start) {
		this.start = start;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getCourt() {
		return court;
	}

	public void setCourt(int court) {
		this.court = court;
	}

	public int getLastCourt() {
		return lastCourt;
	}

	public void setLastCourt(int lastCourt) {
		this.lastCourt = lastCourt;
	}

	public long getSystemConfigId() {
		return systemConfigId;
	}

	public void setSystemConfigId(long systemConfigId) {
		this.systemConfigId = systemConfigId;
	}

}
