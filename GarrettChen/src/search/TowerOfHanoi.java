package search;

public class TowerOfHanoi {
	
	static int disks = 3;
	static String diskTower = "";

	public static void main(String[] args) {
		for(int i = 0; i < disks; i++) {
			diskTower += i + 1;
		}
		towerSolution(3, diskTower, "", "");
	}

	public static void towerSolution(int n, String start, String helper, String end) {
		if(n == 1) {
			start = "";
			end += n;
		}else {
			towerSolution(n - 1, start, end, helper);
			String a = start.substring(start.length() - 1);
			start = start.substring(0, start.length() - 1);
			end += a;
			towerSolution(n - 1, helper, start, end);
		}
	}

}
