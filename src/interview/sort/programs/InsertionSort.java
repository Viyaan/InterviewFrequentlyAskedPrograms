package interview.sort.programs;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int arr[] = { 64, 34, 25, 12, 22, 11, 90, 5, 100, 63, -9, -1 };
		sort(arr, arr.length);
		System.out.println("Sorted array : " + Arrays.toString(arr));
	}

	static void sort(int arr[], int n) {
		for (int i = 0; i < n; i++) {
			int j = i;
			while (j > 0 && arr[j - 1] > arr[j]) {
				int key = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = key;
				j = j - 1;
			}
		}
	}
}
