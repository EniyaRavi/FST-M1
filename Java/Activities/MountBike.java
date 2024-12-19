
public class MountBike extends Bicycle{

	public int seatHeight;
	
	public MountBike(int gears, int currentSpeed, int startHeight) {
		super(gears, currentSpeed);
		this.seatHeight=startHeight;
	}
	
	public void setHeight(int newValue) {
        seatHeight = newValue;
    }

    public String bicycleDesc() {
        return (super.bicycleDesc()+ "\nSeat height is " + seatHeight);
    }  

}
