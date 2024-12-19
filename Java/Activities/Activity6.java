
public class Activity6 {

	public static void main(String[] args) throws InterruptedException {
		
		Plane plane=new Plane(10);
		
		plane.onBoard("John");
		plane.onBoard("Max");
		plane.onBoard("Julie");
		plane.onBoard("Kyle");
		
		System.out.println("Takeoff Time is: "+plane.takeOff());
		
		System.out.println("List of passengers: "+plane.getPassengers());
		
		Thread.sleep(5000);

		plane.land();
		
		System.out.println("Landed Time is: "+plane.getLastTimeLanded());
		
	}

}
