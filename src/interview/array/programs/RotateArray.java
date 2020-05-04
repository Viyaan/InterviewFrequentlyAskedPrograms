package interview.array.programs;

class RotateArray {

	public static int[] bubbleRotate(int[] arr, int order) {
		if (arr == null || order < 0) {
			throw new IllegalArgumentException("Illegal argument!");
		}
		for (int i = 0; i < order; i++) {
			for (int j = arr.length - 1; j > 0; j--) {
				int temp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = temp;
				System.out.println(java.util.Arrays.toString(arr));
			}
		}
		return arr;
	}

	// Driver program to test above functions
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6 };
		int rotationCount =2;
		System.out.println(java.util.Arrays.toString(bubbleRotate(arr, rotationCount)));
	}
}