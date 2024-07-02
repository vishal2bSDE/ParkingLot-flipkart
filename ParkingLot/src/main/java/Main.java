package main.java;

import main.java.domain.Color;
import main.java.domain.Vehicle;
import main.java.domain.VehicleType;
import main.java.service.ParkingLotService;

public class Main {

	private static ParkingLotService parkingLotService;
	public static void main(String[] args) {
		System.out.println("Parking Lot started");
		parkingLotService=new ParkingLotService();
		createParkingLot("ParkingLot1", 4, 20);
		
		Vehicle v1=new Vehicle(VehicleType.BIKE, "Reg1", Color.BLACK);
		Vehicle v2=new Vehicle(VehicleType.TRUCK, "Reg1", Color.BLACK);
		Vehicle v3=new Vehicle(VehicleType.CAR, "Reg1", Color.BLACK);
		Vehicle v4=new Vehicle(VehicleType.BIKE, "Reg1", Color.BLACK);
		
		assignSlot(v1);
		
		unparkVehicle("PR1234_1_1");
		unparkVehicle("PR1234_1_1");
		System.out.println("Parking Lot started");
	}

	private static void unparkVehicle(String ticketNumber) {
		System.out.println("Unparking slot, "+ticketNumber);
		parkingLotService.unparkVehicle(ticketNumber);
	}

	private static void assignSlot(Vehicle v1) {
		System.out.println("Assigning slot to, "+v1);
		String ticketNumber = parkingLotService.assignSlot(v1);
		if(ticketNumber.isBlank()) {
			System.out.println("No slots available");
			return;
		}
		System.out.println("Ticket: "+ticketNumber);
	}

	private static void createParkingLot(String parkingLotName, int floors, int slots) {
		System.out.println("Started Creating ParkingLot");
		parkingLotService.createParkingLot(parkingLotName, floors, slots);		
		System.out.println("Successfully Created ParkingLot");
	}

}
