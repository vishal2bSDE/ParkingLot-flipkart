package main.java.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Floor {

	private int noOfSlots;
	private int floorNo;
	private Map<VehicleType, Integer> vehicleCapacityMap;
	private Map<VehicleType, Integer> vehicleSlotUsed;
	private Map<String, Vehicle> vehiclesParked;
	private Map<VehicleType, PriorityQueue<Integer>> slotsAvailable;
	public Floor(int floorNo, int noOfSlots) {
		super();
		this.floorNo=floorNo;
		this.noOfSlots = noOfSlots;
		initializeMap(noOfSlots);
	}
	private void initializeMap(int noOfSlots2) {
		int tempCount = noOfSlots2;
		vehicleCapacityMap=new HashMap();
		vehicleSlotUsed=new HashMap();
		vehiclesParked=new HashMap();
		slotsAvailable=new HashMap();
		
		vehicleSlotUsed.put(VehicleType.TRUCK, 0);
		vehicleSlotUsed.put(VehicleType.BIKE, 0);
		vehicleSlotUsed.put(VehicleType.CAR, 0);
		
		vehicleCapacityMap.put(VehicleType.TRUCK, 0);
		if(tempCount>=1) {
			vehicleCapacityMap.put(VehicleType.TRUCK, 1);
			slotsAvailable.put(VehicleType.TRUCK, new PriorityQueue<>(List.of(1)));
			--tempCount;
		}
		if(tempCount>=2) {
			vehicleCapacityMap.put(VehicleType.BIKE, 2);
			slotsAvailable.put(VehicleType.BIKE, new PriorityQueue<>(List.of(1, 2)));
			tempCount-=2;
		} else {
			vehicleCapacityMap.put(VehicleType.BIKE, tempCount);
			if(tempCount==1) {
				slotsAvailable.put(VehicleType.BIKE, new PriorityQueue<>(List.of(1)));
			}
			tempCount=0;
		}
		vehicleCapacityMap.put(VehicleType.CAR, tempCount);
		if(tempCount>0) {
			PriorityQueue<Integer> pq=new PriorityQueue<>();
			while(tempCount>0) {
				pq.add(tempCount);
				--tempCount;
			}
			slotsAvailable.put(VehicleType.CAR, pq);
		}
		
	}
	
	public int getFloorNo() {
		return floorNo;
	}
	public void setFloorNo(int floorNo) {
		this.floorNo = floorNo;
	}
	public Map<VehicleType, PriorityQueue<Integer>> getSlotsAvailable() {
		return slotsAvailable;
	}
	public void setSlotsAvailable(Map<VehicleType, PriorityQueue<Integer>> slotsAvailable) {
		this.slotsAvailable = slotsAvailable;
	}
	public int getNoOfSlots() {
		return noOfSlots;
	}
	public void setNoOfSlots(int noOfSlots) {
		this.noOfSlots = noOfSlots;
	}
	public Map<VehicleType, Integer> getVehicleCapacityMap() {
		return vehicleCapacityMap;
	}
	public void setVehicleCapacityMap(Map<VehicleType, Integer> vehicleCapacityMap) {
		this.vehicleCapacityMap = vehicleCapacityMap;
	}
	public Map<VehicleType, Integer> getVehicleSlotUsed() {
		return vehicleSlotUsed;
	}
	public void setVehicleSlotUsed(Map<VehicleType, Integer> vehicleSlotUsed) {
		this.vehicleSlotUsed = vehicleSlotUsed;
	}
	public Map<String, Vehicle> getVehiclesParked() {
		return vehiclesParked;
	}
	public void setVehiclesParked(Map<String, Vehicle> vehiclesParked) {
		this.vehiclesParked = vehiclesParked;
	}
}
