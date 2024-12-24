
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Activity1 {

	static ArrayList<String> list;
	
	@BeforeEach
	void setUp() throws Exception {
		list=new ArrayList<String>();
		list.add("Alpha");
		list.add("Beta");
		
		for(String lists: list) {
			System.out.println(lists);
		}
	}
	
	@Test
	public void insertTest() {
		System.out.println("List: "+list.size());
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		
		
		assertEquals(2,list.size(),"Wrong Size");
		list.add(2, "Charlie");
		assertEquals(3,list.size(),"Wrong Size");
		System.out.println(list.get(0));
		assertEquals("Alpha",list.get(0),"Wrong Element");
		assertEquals("Beta",list.get(1),"Wrong Element");
		assertEquals("Charlie",list.get(2),"Wrong Element");
	}
	
	@Test
	public void replaceTest() {
		
		list.set(1, "Harry");
		assertEquals(2,list.size(),"Wrong Size");
		assertEquals("Alpha",list.get(0),"Wrong Element");
		assertEquals("Harry",list.get(1),"Wrong Element");
		
	}

}
