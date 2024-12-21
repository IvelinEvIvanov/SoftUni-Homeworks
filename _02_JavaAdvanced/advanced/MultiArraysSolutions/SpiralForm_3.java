package advanced.MultiArraysSolutions;

import java.util.Arrays;

public class SpiralForm_3 {
    static int ROW_SIZE = 4;
    static int COL_SIZE = 4;

    // Function for printing matrix in spiral
    // form row, col: Start index of matrix, ROW_SIZE
    // and column respectively ROW_SIZE, COL_SIZE: End index
    // of matrix ROW_SIZE and column respectively
    static void print(int arr[][], int row, int col, int ROW_SIZE, int COL_SIZE) {
	// If row or col lies outside the matrix
	if (row >= ROW_SIZE || col >= COL_SIZE) {
	    return;
	}

	// Print First ROW_SIZE
	for (int itr = row; itr < COL_SIZE; itr++) {
	    System.out.print(arr[row][itr] + " ");
	}

	// Print Last Column
	for (int itr = row + 1; itr < ROW_SIZE; itr++) {
	    System.out.print(arr[itr][COL_SIZE - 1] + " ");
	}

	// Print Last ROW_SIZE, if Last and
	// First ROW_SIZE are not same
	if ((ROW_SIZE - 1) != row) {
	    for (int itr = COL_SIZE - 2; itr >= col; itr--) {
		System.out.print(arr[ROW_SIZE - 1][itr] + " ");
	    }
	}

	// Print First Column, if Last and
	// First Column are not same
	if ((COL_SIZE - 1) != col) {
	    for (int itr = ROW_SIZE - 2; itr > row; itr--) {
		System.out.print(arr[itr][col] + " ");
	    }
	}
	print(arr, row + 1, col + 1, ROW_SIZE - 1, COL_SIZE - 1);
    }

    // Driver Code
    public static void main(String[] args) {
	int arr[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

	for (int ROW_SIZE = 0; ROW_SIZE < arr.length; ROW_SIZE++) {
	    System.out.println(Arrays.toString(arr[ROW_SIZE]));
	}

	System.out.println();

	int ROW_SIZE = arr.length;
	int COL_SIZE = arr[0].length;

	// Function Call
	print(arr, 0, 0, ROW_SIZE, COL_SIZE);
    }

}
