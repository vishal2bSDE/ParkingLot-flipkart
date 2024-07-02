package main.java.service;

import java.util.Map;

import main.java.domain.Floor;
import main.java.domain.ParkingLot;
import main.java.domain.Vehicle;
import main.java.domain.VehicleType;

public class ParkingLotService {

	private ParkingLot parkingLot;

	public ParkingLotService() {}
	
	public void createParkingLot(String parkingLotName, int floors, int slots) {
		parkingLot=new ParkingLot(parkingLotName, floors, slots);
	}
	
	public String assignSlot(Vehicle vehicle) {
		Map<Integer, Floor> floors = parkingLot.getFloors();
		String ticketNumber = "";
		for(Floor floor:floors.values()) {
			if(slotAvailable(vehicle.getType(), floor)) {
				ticketNumber = parkingLot.getId() +"_"+ floor.getFloorNo()+"_"+ floor.getSlotsAvailable().get(vehicle.getType()).poll();
				floor.getVehiclesParked().put(ticketNumber, vehicle);
				break;
			}
		}
		return ticketNumber;
	}
	
	private boolean slotAvailable(VehicleType type, Floor floor) {
		if(floor.getVehicleCapacityMap().get(type)>floor.getVehicleSlotUsed().get(type)) {
			floor.getVehicleSlotUsed().put(type, floor.getVehicleSlotUsed().get(type)+1);
			return true;
		}
		
		return false;
	}

	public void unparkVehicle(String ticketNumber) {
		String[] ticketSec=ticketNumber.split("_");
		int floor=Integer.parseInt(ticketSec[1]);
		int slot=Integer.parseInt(ticketSec[2]);
		if(!parkingLot.getFloors().containsKey(floor) || !parkingLot.getFloors().get(floor).getVehiclesParked().containsKey(ticketNumber)) {
			System.out.println("Ticket is invalid");
			return;
		}
		
		parkingLot.getFloors().get(floor).getVehiclesParked().remove(ticketNumber);
		System.out.println("Vehicle is removed, "+ticketNumber);
	}
	
}
