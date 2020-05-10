package interview.sort.programs;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {

		int arr[] = { 14, 33, 27, 10, 35, 19, 42, 44, -6 };
		sort(arr, 0, arr.length - 1);
		System.out.println("Sorted array : " + Arrays.toString(arr));
	}

	private static int[] sort(int[] arr, int start, int end) {
		int piIndex = 0;
		if (start < end) {
			piIndex = partition(arr, start, end);
			sort(arr, start, piIndex - 1);
			sort(arr, piIndex + 1, end);
		}
		return arr;
	}

	public static int partition(int[] array, int start, int end) {
		int pivot = array[end];
		int index = start;
		for (int j = start; j < end; j++) {
			if (array[j] <= pivot) {
				swap(array, index, j);
				index++;
			}
		}
		swap(array, index, end);
		return index;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
