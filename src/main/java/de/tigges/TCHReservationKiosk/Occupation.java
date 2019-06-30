package de.tigges.TCHReservationKiosk;

import lombok.Data;

@Data
public class Occupation {
	private long id;

	private String text;
	private Long date;
	private Long start;
	private int duration;

	private int court;
	private int lastCourt;

	private long systemConfigId;
}
