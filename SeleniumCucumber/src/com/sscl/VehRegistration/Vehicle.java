package com.sscl.VehRegistration;

public class Vehicle {
	public String VRN;
	public String Make;
	public String Colour;
	
	public Vehicle(String VRN, String Make, String Colour) {
		this.VRN = VRN;
		this.Make = Make;
		this.Colour = Colour;
	}
	
	public void addVehicle(String VRN, String Make, String Colour) {
		this.VRN = VRN;
		this.Make = Make;
		this.Colour = Colour;
	}
	
	
}
