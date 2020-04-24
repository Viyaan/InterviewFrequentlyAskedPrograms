package interview.sort.programs;

import java.util.Arrays;

public class SelectionSort {

	void sort(int arr[], int n, int index) {
		// Return when starting and size are the same.
		if (index == n)
			return;
		int k = minIndex(arr, index, n - 1);
		// swapping with index and minimum index are not same
		if (k != index) {
			System.out.println("swap  : " + arr[k] + " "+ arr[index]);
			int temp = arr[k];
			arr[k] = arr[index];
			arr[index] = temp;
		}
		System.out.println("Sorted array : " + Arrays.toString(arr));
		sort(arr, n, index + 1);
	}

	private int minIndex(int[] arr, int index, int i) {
		if (index == i)
			return index;
		int k = minIndex(arr, index + 1, i);
		return (arr[index] < arr[k] ? index : k);
	}

	// Driver code to test above
	public static void main(String args[]) {
		SelectionSort ob = new SelectionSort();
		int arr[] = { 64, 25, 12, 22, 11 };
		ob.sort(arr, arr.length, 0);
		System.out.println("Sorted array : " + Arrays.toString(arr));
	}
}
