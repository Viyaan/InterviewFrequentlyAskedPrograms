package interview.puzzle.programs;

public class TowerofHanoi {
	// Java recursive function to solve tower of hanoi puzzle
	static void towerOfHanoi(int n, String from_rod, String to_rod, String aux_rod) {
		if (n == 1) {
			System.out.println("Move disk 1 from rod " + from_rod + " to rod " + to_rod);
			return;
		}
		towerOfHanoi(n - 1, from_rod, aux_rod, to_rod);
		System.out.println("Move disk " + n + " from rod " + from_rod + " to rod " + to_rod);
		towerOfHanoi(n - 1, aux_rod, to_rod, from_rod);
	}

	// Driver method
	public static void main(String args[]) {
		int n = 4; // Number of disks
		towerOfHanoi(n, "source", "destination", "aux"); // A, B and C are names of rods
	}
}