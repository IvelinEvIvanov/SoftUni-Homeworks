package advanced.MultiArrays;

import java.util.Scanner;

public class _11_ReverseMatrixDiagonals {

    public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);

	String[] tokens = scan.nextLine().split(" ");

	int sizeRow = Integer.parseInt(tokens[0]);
	int sizeCol = Integer.parseInt(tokens[1]);

	int[][] arr = new int[sizeRow][sizeCol];
	for (int i = 0; i < arr.length; i++) {

	    // enter row
	    tokens = scan.nextLine().split(" ");

	    for (int j = 0; j < tokens.length; j++) {
		arr[i][j] = Integer.parseInt(tokens[j]);
	    }
	}

	printDiagonals(arr, sizeRow, sizeCol);

    }

    private static void printDiagonals(int[][] arr, int height, int width) {

	for (int col = width - 1; col >= 0; col--) {

	    System.out.print(arr[height - 1][col] + " ");

	    int previousRow = height - 2;
	    int nextCol = col + 1;

	    while (isValid(previousRow, nextCol, width, height)) {

		System.out.print(arr[previousRow][nextCol] + " ");

		previousRow--;
		nextCol++;
	    }

	    System.out.println("");
	} // for

	for (int row = height - 2; row >= 0; row--) {

	    System.out.print(arr[row][0] + " ");

	    int previousRow = row - 1;
	    int nextCol = 1;

	    while (isValid(previousRow, nextCol, width, height)) {

		System.out.print(arr[previousRow][nextCol] + " ");

		previousRow--;
		nextCol++;
	    }

	    System.out.println("");
	} // for

    }

    public static boolean isValid(int row, int col, int width, int height) {
	if ((row < 0 || row >= height) || (col >= width || col < 0)) {
	    return false;
	}
	return true;
    }

}
