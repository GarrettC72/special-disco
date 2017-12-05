package search;

public class TowerOfHanoi {

	public static void main(String[] args) {
		towerSolution(5, "A", "B", "C");
	}

	public static void towerSolution(int n, String start, String helper, String end) {
		if(n == 1) {
			System.out.println(start + " to " + end);
		}else {
			towerSolution(n - 1, start, end, helper);
			System.out.println(start + " to " + end);
			towerSolution(n - 1, helper, start, end);
		}
	}

}
