import java.util.HashSet;

public class Activity10 {

	public static void main(String[] args) {
		
		HashSet<String> hs=new HashSet<>();
		hs.add("Apple");
		hs.add("Mango");
		hs.add("Banana");
		hs.add("Guava");
		hs.add("Chikku");
		hs.add("Starwberry");
		
		System.out.println("Size of the HashSap is: "+hs.size());
		
		System.out.println("Removing Chikku: " +hs.remove("Chikku"));
		
		if(hs.remove("Orange")) {
			System.out.println("Orange is removed from the Set");
		}
		else{
			System.out.println("Orange is not available in the Set");
		}
		
		System.out.println("Is Guava available in the HashSet: "+hs.contains("Guava"));
		System.out.println("The Updated Set is: "+hs);
	}

}
