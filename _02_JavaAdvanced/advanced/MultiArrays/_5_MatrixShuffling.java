package advanced.MultiArrays;

import java.util.*;

public class _5_MatrixShuffling {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String[] tokens = scan.nextLine().split(" ");

		int n = Integer.parseInt(tokens[0]);
		int m = Integer.parseInt(tokens[1]);
		String[][] matrix = new String[n][m];

		fillMatrix(matrix, scan);

		String[] commandTokens = scan.nextLine().split(" ");
		String command = commandTokens[0];

		while (!command.equals("END")) {
			switch (command) {
			case "swap":
				if (commandTokens.length < 5 || commandTokens.length > 5) {
					System.out.println("Invalid input!");
				} else {
					int row1 = Integer.parseInt(commandTokens[1]);
					int col1 = Integer.parseInt(commandTokens[2]);

					int row2 = Integer.parseInt(commandTokens[3]);
					int col2 = Integer.parseInt(commandTokens[4]);

					try {
						String swap = matrix[row1][col1];
						matrix[row1][col1] = matrix[row2][col2];
						matrix[row2][col2] = swap;

						printMatrix(matrix);
					} catch (IndexOutOfBoundsException e) {
						System.out.println("Invalid input!");
					}
				}
				break;

			default:
				System.out.println("Invalid input!");
				break;
			}

			commandTokens = scan.nextLine().split(" ");
			command = commandTokens[0];
		}

	}

	private static void printMatrix(String[][] matrix) {
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				System.out.printf("%s ", matrix[row][col]);
			}

			System.out.println();
		}

	}

	private static void fillMatrix(String[][] matrix, Scanner scan) {

		for (int row = 0; row < matrix.length; row++) {
			String[] tokens = scan.nextLine().split(" ");

			for (int col = 0; col < matrix[row].length; col++) {
				matrix[row][col] = tokens[col];
			}
		}
	}

}
