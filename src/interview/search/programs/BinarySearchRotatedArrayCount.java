package interview.search.programs;

public class BinarySearchRotatedArrayCount {

	// Returns count of rotations for an array
	// which is first sorted in ascending order,
	// then rotated
	static int countRotations(int arr[], int low, int high) {
		// This condition is needed to handle
		// the case when array is not rotated
		// at all
		if (high < low)
			return 0;

		// If there is only one element left
		if (high == low)
			return low;

		// Find mid
		// /*(low + high)/2;*/
		int mid = low + (high - low) / 2;

		// Check if element (mid+1) is minimum
		// element. Consider the cases like
		// {3, 4, 5, 1, 2}
		if (arr[mid + 1] < arr[mid])
			return (mid + 1);

		// Check if mid itself is minimum element
		// {4 ,5, 1, 2, 3}
		if (arr[mid] < arr[mid - 1])
			return mid;

		// Decide whether we need to go to left
		// half or right half
		// {5, 1, 2, 3, 4}
		if (arr[high] > arr[mid])
			return countRotations(arr, low, mid - 1);

		return countRotations(arr, mid + 1, high);
	}
	static int minIndex(int a[], int l, int h) {
		if (l == h)
			return l;
		// Find minimum of remaining elements
		int k = minIndex(a, l + 1, h);
		// Return minimum of current and remaining.
		return (a[l] < a[k]) ? l : k;
	}

	// Driver program to test above functions
	public static void main(String[] args) {
		int arr[] = { 13, 14, 15, 18, 2, 3, 6, 12 };
		int n = arr.length;

		//Binary Search way, Time Complexity
		System.out.println(countRotations(arr, 0, n - 1));
		
		//Linear Search way, Time Complexity O(n)
		System.out.println(minIndex(arr, 0, n - 1));
	}

}
