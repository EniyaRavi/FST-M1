import java.util.Arrays;

public class Activity2 {
	
	public static boolean result(int[] numbers, int searchNum, int fixedNum) {
		int temp_sum=0;
		for(int number: numbers) {
			if(number==searchNum) {
				temp_sum += searchNum;
			}
			if(temp_sum>fixedNum) {
				break;
			}
		}
		return temp_sum==fixedNum;		
	}
	
	
	public static void main(String[] args) {
		
		int[] numArray= {10, 77, 10, 54, -11, 10};
		System.out.println("Given Array: "+Arrays.toString(numArray));
		
		int searchNum=10;
		int fixedNum=30;
		
		System.out.println("Result: "+result(numArray, searchNum, fixedNum));
	}
	
}
