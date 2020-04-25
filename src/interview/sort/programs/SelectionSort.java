package interview.sort.programs;

import java.util.Arrays;

public class SelectionSort {

	static int minIndex(int a[], int i, int j) {
		if (i == j)
			return i;
		// Find minimum of remaining elements
		int k = minIndex(a, i + 1, j);
		// Return minimum of current and remaining.
		return (a[i] < a[k]) ? i : k;
	}

	// Recursive selection sort. n is size of a[] and index
	// is index of starting element.
	void sort(int arr[], int size, int index) {
		// Return when starting and size are the same.
		if (index == size)
			return;
        // calling minimum index function for minimum index 
		int min_index = minIndex(arr, index, size - 1);
		// swapping with index and minimum index if they are not same
		if (min_index != index) {
			// swap 
			int temp = arr[min_index];
			arr[min_index] = arr[index];
			arr[index] = temp;
		}
		// Recursively calling selection sort function
		sort(arr, size, index + 1);
	}

	// Driver code to test above
	public static void main(String args[]) {
		SelectionSort ob = new SelectionSort();
		int arr[] = { 64, 25, 12, 22, 11 };
		int min_index = 0; // Bu default always start with 0th index
		ob.sort(arr, arr.length, min_index);
		System.out.println("Sorted array : " + Arrays.toString(arr));
	}
}
