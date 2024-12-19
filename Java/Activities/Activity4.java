import java.util.Arrays;

public class Activity4 {

	public static void ascendingSort(int array[]) {
		int size=array.length,i;
		
		for(i=1; i<size;i++) {
			int key=array[i];
			int j=i-1;
			 while(j>=0 && key<array[j]) {
				 array[j+1]=array[j];
				 --j;
			 }
			 array[j+1]=key;
		}
	}
	
	public static void main(String[] args) {
	      int[] data= {4,3,2,10,12,1,5,6,8,9};
	      ascendingSort(data);
	      System.out.println("Ascending Order of the Sorted Array: ");
	      System.out.println(Arrays.toString(data));

	}

}
