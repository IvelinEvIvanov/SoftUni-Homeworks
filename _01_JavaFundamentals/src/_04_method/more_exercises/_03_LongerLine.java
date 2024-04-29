package _04_method.more_exercises;

import java.util.Scanner;

public class _03_LongerLine {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] lineA = new int[4];
		int[] lineB = new int[4];

		initLine(lineA, scanner);
		initLine(lineB, scanner);
		scanner.close();

		int sumLineA = sumLine(lineA);
		int sumLineB = sumLine(lineB);

		int sumPointA = 0;
		int sumPointB = 0;

		if (sumLineA >= sumLineB) {
			sumPointA = sumPointCordinate(lineA[0], lineA[1]);
			sumPointB = sumPointCordinate(lineA[2], lineA[3]);

			if (sumPointA <= sumPointB) {
				printLine(lineA[0], lineA[1]);
				printLine(lineA[2], lineA[3]);
			} else {
				printLine(lineA[2], lineA[3]);
				printLine(lineA[0], lineA[1]);
			}
		} else {
			sumPointA = sumPointCordinate(lineB[0], lineB[1]);
			sumPointB = sumPointCordinate(lineB[2], lineB[3]);

			if (sumPointA <= sumPointB) {
				printLine(lineB[0], lineB[1]);
				printLine(lineB[2], lineB[3]);
			} else {
				printLine(lineB[2], lineB[3]);
				printLine(lineB[0], lineB[1]);
			}
		}
	}

	private static void printLine(int x, int y) {
		System.out.printf("(%d, %d)", x, y);
	}

	private static int sumPointCordinate(int x, int y) {
		return Math.abs(x) + Math.abs(y);
	}

	private static int sumLine(int[] line) {
		int sum = 0;
		for (int i = 0; i < line.length; i++) {
			sum += Math.abs(line[i]);
		}
		return sum;
	}

	private static void initLine(int[] line, Scanner scanner) {
		for (int i = 0; i < line.length; i++) {
			line[i] = Integer.parseInt(scanner.nextLine());
		}
	}
}
