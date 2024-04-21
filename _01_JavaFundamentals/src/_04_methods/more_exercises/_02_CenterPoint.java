package _04_methods.more_exercises;

import java.util.Scanner;

public class _02_CenterPoint {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		int x1 = scanner.nextInt();
		int y1 = scanner.nextInt();
		scanner.close();

		int sumPointA = sumPointCordinate(x, y);
		int sumPointB = sumPointCordinate(x1, y1);

		if (sumPointA <= sumPointB) {
			System.out.printf("(%d, %d)", x, y);
		} else {
			System.out.printf("(%d, %d)", x1, y1);
		}
	}

	private static int sumPointCordinate(int x, int y) {
		return Math.abs(x) + Math.abs(y);
	}
}
