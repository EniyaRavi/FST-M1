import java.util.HashMap;
import java.util.Map;

public class Activity11 {

	public static void main(String[] args) {
		Map<Integer, String> colours=new HashMap<>();
		colours.put(1, "Pink");
		colours.put(2, "Black");
		colours.put(3, "White");
		colours.put(4, "Blue");
		colours.put(5, "Red");
		System.out.println("HashMap: "+colours);
		
		System.out.println("Removed colour: "+colours.remove(4));
		System.out.println("Updated HashMap: "+colours);
		
		System.out.println("Is Green colour available: "+colours.containsValue("Green"));
		
		System.out.println("Size of the HashMap is: "+colours.size());
	}

}

