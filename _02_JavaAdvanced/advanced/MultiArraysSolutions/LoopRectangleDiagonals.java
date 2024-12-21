package advanced.MultiArraysSolutions;

import java.util.Arrays;
import java.util.Scanner;

public class LoopRectangleDiagonals {
    public static void main(String[] args) {

	/*
	 * Scanner scan = new Scanner(System.in);
	 * 
	 * String[] tokens = scan.nextLine().split(" ");
	 * 
	 * int sizeRow = Integer.parseInt(tokens[0]); int sizeCol =
	 * Integer.parseInt(tokens[1]);
	 * 
	 * int[][] arr = new int[sizeRow][sizeCol];
	 * 
	 * for (int i = 0; i < arr.length; i++) {
	 * 
	 * // enter row tokens = scan.nextLine().split(" ");
	 * 
	 * for (int j = 0; j < tokens.length; j++) { arr[i][j] =
	 * Integer.parseInt(tokens[j]); } }
	 */

	int arr[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 }, };
	int sizeRow = arr.length;
	int sizeCol = arr[0].length;

	printMatrix(arr);
	System.out.println();

	printDiagonals(arr, sizeRow, sizeCol);

    }

    private static void printDiagonals(int[][] arr, int height, int width) {

	for (int row = 0; row < height; row++) {

	    System.out.print(arr[row][0] + " ");

	    int previousRow = row - 1;
	    int nextCol = 1;

	    while (isValid(previousRow, nextCol, width, height)) {

		System.out.print(arr[previousRow][nextCol] + " ");

		previousRow--;
		nextCol++;
	    }

	    System.out.println("");
	}

	// Last row, first column is reached,so nextColumn+1,nextRow-1.
	for (int col = 1; col < width; col++) {

	    System.out.print(arr[height - 1][col] + " ");

	    int previousRow = height - 2;
	    int nextCol = col + 1;

	    while (isValid(previousRow, nextCol, width, height)) {

		System.out.print(arr[previousRow][nextCol] + " ");

		previousRow--;
		nextCol++;
	    }

	    System.out.println("");
	}
    }

    static boolean isValid(int row, int col, int width, int height) {

	if ((row < 0 || row >= height) || (col >= width || col < 0)) {
	    return false;
	}
	return true;
    }

    static void printMatrix(int arr[][]) {
	for (int row = 0; row < arr.length; row++) {
	    System.out.println(Arrays.toString(arr[row]));
	}
    }

}
