package main.java.domain;

public class Vehicle {

	private VehicleType type;
	private String regNum;
	private Color color;
	public VehicleType getType() {
		return type;
	}
	public void setType(VehicleType type) {
		this.type = type;
	}
	public String getRegNum() {
		return regNum;
	}
	public void setRegNum(String regNum) {
		this.regNum = regNum;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Vehicle(VehicleType type, String regNum, Color color) {
		super();
		this.type = type;
		this.regNum = regNum;
		this.color = color;
	}
	@Override
	public String toString() {
		return "Vehicle [type=" + type + ", regNum=" + regNum + ", color=" + color + "]";
	}
	
	
}
