package advanced.MultiArrays;

import java.util.Iterator;
import java.util.Scanner;

public class _4_MaximalSum {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String[] input = scan.nextLine().split(" ");

		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);

		if (n >= 3 && m >= 3) {
			int[][] matrix = new int[n][m];

			fillMatrix(matrix, scan);

			int maxRow = 0;
			int maxCol = 0;
			int maxSum = 0;

			for (int row = 0; row < matrix.length - 2; row++) {
				for (int col = 0; col < matrix[0].length - 2; col++) {
					int sum = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2];
					sum += matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2];
					sum += matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];

					if (maxSum < sum) {
						maxSum = sum;
						maxRow = row;
						maxCol = col;
					}
				}
			}

			System.out.println("Sum = " + maxSum);
			printMatrix(matrix, maxRow, maxCol);
		}

	}

	private static void printMatrix(int[][] matrix, int maxRow, int maxCol) {
		for (int i = maxRow; i < maxRow + 3; i++) {
			for (int j = maxCol; j < maxCol + 3; j++) {
				System.out.printf("%d ", matrix[i][j]);
			}

			System.out.println();
		}

	}

	private static void fillMatrix(int[][] matrix, Scanner scan) {

		for (int row = 0; row < matrix.length; row++) {
			String[] tokens = scan.nextLine().split(" ");

			for (int col = 0; col < matrix[row].length; col++) {
				matrix[row][col] = Integer.parseInt(tokens[col]);
			}
		}
	}

}
