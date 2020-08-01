import java.util.Arrays;

/**
 * This class is my solution to challenge #1 of the Senior Software Engineer
 * Application.
 * 
 * Prompt: Given two sorted arrays (arr1, arr2) and a number, k, create a
 * method, sortArrays that returns a sorted array of the first k elements.
 * 
 * @author benbarzvi
 * 
 *    08/01/2020
 *
 */

public class Challenge1 {
	/**
	 * This method receives two sorted arrays of type integer, and returns a sorted
	 * array of the first k elements.
	 * 
	 * @param k    - size of the array returned.
	 * @param arr1 - the first array given.
	 * @param arr2 - the second array given
	 * @return a sorted array of the first k elements. Time Complexity: O(n). Space
	 *         Complexity: O(n).
	 */

	public static int[] sortArrays(int[] arr1, int[] arr2, int k) {
		if (arr1.length + arr2.length < k) {
			k = arr1.length + arr2.length;
		}
		int[] result = new int[k];

		int arr1Index = 0, arr2Index = 0, resIndex = 0;

		while (resIndex < k && arr1Index < arr1.length && arr2Index < arr2.length) {
			if (arr1[arr1Index] < arr2[arr2Index]) {
				result[resIndex] = arr1[arr1Index];
				resIndex++;
				arr1Index++;
			} else {
				result[resIndex] = arr2[arr2Index];
				resIndex++;
				arr2Index++;
			}
		}
		while (resIndex < k && arr1Index < arr1.length) {
			result[resIndex] = arr1[arr1Index];
			resIndex++;
			arr1Index++;
		}
		while (resIndex < k && arr2Index < arr2.length) {
			result[resIndex] = arr2[arr2Index];
			resIndex++;
			arr2Index++;
		}

		return result;
	}
	/**
	 * This is the main method of the class.
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr1 = { 1, 3, 5, 8 };
		int[] arr2 = {};
		int k = 10;
		int[] res = sortArrays(arr1, arr2, k);

		for (int i = 0; i < res.length; i++) {

			System.out.print(res[i]);
			if (i != res.length - 1) {
				System.out.print(",");
			}
		}

	}
}
