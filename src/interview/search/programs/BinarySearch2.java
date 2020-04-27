package interview.search.programs;

import java.io.*;

class BinarySearch2 {
	/*
	 * if x is present in arr[] then returns the index of FIRST occurrence of x in
	 * arr[0..n-1], otherwise returns -1
	 */
	public static int first(int arr[], int low, int high, int x) {
		if (high >= low) {
			int mid = low + (high - low) / 2;
			if ((mid == 0 || x > arr[mid - 1]) && arr[mid] == x)
				return mid;
			else if (x > arr[mid])
				return first(arr, (mid + 1), high, x);
			else
				return first(arr, low, (mid - 1), x);
		}
		return -1;
	}

	/*
	 * if x is present in arr[] then returns the index of LAST occurrence of x in
	 * arr[0..n-1], otherwise returns -1
	 */
	public static int last(int arr[], int low, int high, int x, int n) {
		if (high >= low) {
			int mid = low + (high - low) / 2;
			if ((mid == n - 1 || x < arr[mid + 1]) && arr[mid] == x)
				return mid;
			else if (x < arr[mid])
				return last(arr, low, (mid - 1), x, n);
			else
				return last(arr, (mid + 1), high, x, n);
		}
		return -1;
	}

	public static void main(String[] args) {

		int arr[] = { 1, 2, 2, 2, 2, 3, 4, 7, 8, 8 };
		int n = arr.length;
		int x = 8;
		System.out.println("First Occurrence = " + first(arr, 0, n - 1, x));
		System.out.println("Last Occurrence = " + last(arr, 0, n - 1, x, n));
		int i = first(arr, 0, n - 1, x);
		int j = last(arr, 0, n - 1, x, n);
		System.out.println("Element " + x + " Occurs =" + Integer.valueOf(j - i + 1) + " times");

	}
}
