
public class Car {
	
	String color;
	String transmission;
	int make;
	int tyres;
	int doors;
	
	public Car() {
		this.tyres=4;
		this.doors=4;		
	}
	
	public void displayCharacterstics() {
		System.out.println("Color of the car: "+color);
		System.out.println("Transmission of the car: "+transmission);
		System.out.println("Make of the car: "+make);
		System.out.println("No. of tyres on car: "+tyres);
		System.out.println("No. of doors on car: "+doors);	
	}
	
	public void accelerate() {	
		System.out.println("Car is moving forward");	
	}
	
	public void brake() {	
		System.out.println("Car has stopped");
	}

}
