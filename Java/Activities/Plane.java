import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Plane {
	
	private int maxPassengers;
	private List<String> passengers;
	private Date lastTimeTookOff;
    private Date lastTimeLanded;
	
	public Plane(int maxpassengers){
		this.maxPassengers=maxPassengers;
		this.passengers=new ArrayList<>();
	}
	
	public void onBoard(String passenger) {
		this.passengers.add(passenger);
	}
	
	public Date takeOff() {
		this.lastTimeTookOff=new Date();
		return lastTimeTookOff;
	}
	public void land() {
        this.lastTimeLanded = new Date();
        this.passengers.clear();
    }

    public Date getLastTimeLanded() {
        return lastTimeLanded;
    }

    public List<String> getPassengers() {
        return passengers;
    }

}
