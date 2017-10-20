package arrs2d;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * increases the element in arr at index psn
	 * and decreases the elements at psn - 1 and psn + 1,
	 * if they exist
	 * 
	 * THIS idea is another major topic in AP CSA.
	 * It is the isea of avoiding an ArrayIndexOutOfBoundsException
	 * you will see it on quizzes, tests, and project rubrics
	 * SO ALWAYS BE MINDFUL!
	 * @param arr
	 * @param psn
	 */
	public static void changeNeighbors(int[] arr, int psn) {
		arr[psn]++;
		if(psn - 1 >= 0) {
			arr[psn - 1]--;
		}
		if(psn + 1 <= arr.length - 1) {
			arr[psn + 1]--;
		}
	}

}
