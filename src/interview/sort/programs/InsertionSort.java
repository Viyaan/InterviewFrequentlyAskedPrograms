package interview.sort.programs;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int arr[] = { 64, 34, 25, 12, 22, 11, 90, 5, 100, 63 };
		sort(arr, arr.length);
		System.out.println("Sorted array : " + Arrays.toString(arr));
	}

	static void sort(int arr[], int n) {
		for (int i = 1; i < n-1; i++) {
			int key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
	}
}
