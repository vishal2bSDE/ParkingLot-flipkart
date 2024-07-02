package main.java.domain;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

	private String id;
	private String name;
	private int noOfFloors;
	private Map<Integer, Floor> floors;
	public ParkingLot(String name, int noOfFloors, int noOfSlots) {
		super();
		this.name = name;
		this.noOfFloors = noOfFloors;
		this.id="PR1234";
		initializeTheFLoors(noOfFloors, noOfSlots);
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private void initializeTheFLoors(int noOfFloors2, int noOfSlots) {
		floors=new HashMap();
		for(int i=1;i<=noOfFloors2;i++) {
			floors.put(i, new Floor(i, noOfSlots));
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNoOfFloors() {
		return noOfFloors;
	}
	public void setNoOfFloors(int noOfFloors) {
		this.noOfFloors = noOfFloors;
	}
	public Map<Integer, Floor> getFloors() {
		return floors;
	}
	public void setFloors(Map<Integer, Floor> floors) {
		this.floors = floors;
	}
	
	
}
