package interview.array.programs;

/**
 * @author Viyaan
 * 
 *         You are given a list of n-1 integers and these integers are in the
 *         range of 1 to n. There are no duplicates in the list. One of the
 *         integers is missing in the list. 
 *
 */
public class MissingNumber {
	public static void main(String args[]) {
		int arr[] = { 1, 2, 4, 5, 6 };
		
		int n = arr.length +1;
		int sum = (n*(n+1))/2;
		for (int i =0;i<arr.length;i++) {
			sum = sum - arr[i];
		}
		System.out.println(" Missing number is "+sum);
	}
}
