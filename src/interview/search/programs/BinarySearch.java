package interview.search.programs;

class BinarySearch {
// Returns index of x if it is present in arr[l..
// h], else return -1
	int binarySearch(int arr[], int l, int h, int x) {
		if (h >= l) {
			int mid = l + (h - l) / 2;

// If the element is present at the
// middle itself
			if (arr[mid] == x)
				return mid;

// If element is smaller than mid, then
// it can only be present in left subarray
			if (arr[mid] > x)
				return binarySearch(arr, l, mid - 1, x);

// Else the element can only be present
// in right subarray
			return binarySearch(arr, mid + 1, h, x);
		}

// We reach here when element is not present
// in array
		return -1;
	}

// Driver method to test above

	public static void main(String args[]) {
		BinarySearch ob = new BinarySearch();
		int arr[] = { 2, 3, 4, 10, 40, 40, 78, 89, 90 };
		int n = arr.length;
		int x = 90;
		int result = ob.binarySearch(arr, 0, n, x);
		if (result == -1)
			System.out.println("Element not present");
		else
			System.out.println("Element found at index " + result);
	}
}
