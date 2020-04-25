package interview.sort.programs;

import java.util.Arrays;

public class BubbleSort {
	
	private static void sortString(String[] arr, int length) {
		if(length ==1)
			return;
		for(int i =0; i <length-1; i++) {
			if (arr[i].compareTo(arr[i+1]) > 0) {
				String temp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1]= temp;
			}
			sortString(arr,length-1);
		}
	}

	// A function to implement bubble sort
	static void sort(int arr[], int n) {
		if (n == 1)
			return;
		for (int i = 0; i < n - 1; i++)
			if (arr[i] > arr[i + 1]) {
				int temp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = temp;
			}
		// Largest element is fixed,recur for remaining array
		sort(arr, n - 1);
	}
	// Driver Method
	public static void main(String[] args) {
		int arr[] = { 64, 34, 25, 12, 22, 11, 90 };
		sort(arr, arr.length);
		System.out.println("Sorted array : " + Arrays.toString(arr));
		
		String str[] = { "sun", "kite", "rat", "van", "nanny"};
		sortString(str, str.length);
		System.out.println("Sorted array : " + Arrays.toString(str));
	}
}
