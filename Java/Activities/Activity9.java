import java.util.ArrayList;

public class Activity9 {

	public static void main(String[] args) {
		ArrayList<String> myList=new ArrayList<String>();
		myList.add("Jack");
		myList.add("John");
		myList.add("Amy");
		myList.add("Michael");
		myList.add("Harry");
		
		for(String name:myList) {
			System.out.println(name);
		}
		
		System.out.println("3rd name in Array List is: "+myList.get(2));
		System.out.println("Is Michael available in the List: "+myList.contains("Michael"));
		System.out.println("Size of myList is: "+myList.size());
		myList.remove(1);
		System.out.println("1 Name is removed");
		System.out.println("Size of myList is: "+myList.size());
		
	}

}
