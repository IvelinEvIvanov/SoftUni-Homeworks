package advanced.MultiArrays;

import java.util.Scanner;

public class Task_9 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String[] tokens = scan.nextLine().split(" ");
		int n = Integer.parseInt(tokens[0]);
		int m = Integer.parseInt(tokens[1]);

		// fill array
		int[][] arr = new int[n][m];
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[row].length; col++) {
				arr[row][col] = 0;
			}
		}

		String input = scan.nextLine();
		while (!input.equals("stop")) {

			tokens = input.split(" ");
			int z = Integer.parseInt(tokens[0]);
			int r = Integer.parseInt(tokens[1]);
			int c = Integer.parseInt(tokens[2]);

			int counter = 0;
			counter = Math.abs(z - r);
			boolean isFound = false;

			for (int countCol = 1; countCol < m; countCol++) {

				if (isFound) {
					break;
				}

				if (countCol == c) {

					if (arr[r][countCol] == 0) { // if spot is empty

						arr[r][countCol] = 1;
						counter += (c + 1);
						isFound = true;
						break;

					} else if (arr[r][countCol] == 1) { // is spot is not empty, search left

						for (int colLeft = c - 1; colLeft > 0; colLeft--) {

							if (arr[r][colLeft] == 0) {

								arr[r][colLeft] = 1;
								counter += (colLeft + 1);
								isFound = true;
								break;
							}
						}

						if (!isFound) {
							for (int colRight = c + 1; colRight < m; colRight++) { // is spot is not empty, search right

								if (arr[r][colRight] == 0) {

									arr[r][colRight] = 1;
									counter += (colRight + 1);
									isFound = true;
									break;
								}
							}
						}

					}
				}
			} // outer for

			if (!isFound) {
				System.out.println("Row " + r + " full");
			} else {
				System.out.println(counter);
			}

			input = scan.nextLine();

		} // while

		// System.out.println();

	}

}
