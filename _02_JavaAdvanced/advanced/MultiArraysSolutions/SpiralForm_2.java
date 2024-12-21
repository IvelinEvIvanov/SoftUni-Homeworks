package advanced.MultiArraysSolutions;

import java.util.Arrays;

public class SpiralForm_2 {

    // Function print matrix in spiral form
    static void spiralPrint(int ROW_SIZE, int COL_SIZE, int arr[][]) {

	int itr;
	int row = 0;
	int col = 0;

	/*
	 * row - starting row index ROW_SIZE - ending row index col - starting column
	 * index COL_SIZE -ending column index itr - iterator
	 */

	while (row < ROW_SIZE && col < COL_SIZE) {
	    // Print the first row from the remaining rows
	    for (itr = col; itr < COL_SIZE; ++itr) {
		System.out.print(arr[row][itr] + " ");
	    }
	    row++;

	    // Print the last column from the remaining
	    // columns
	    for (itr = row; itr < ROW_SIZE; ++itr) {
		System.out.print(arr[itr][COL_SIZE - 1] + " ");
	    }
	    COL_SIZE--;

	    // Print the last row from the remaining rows */
	    if (row < ROW_SIZE) {
		for (itr = COL_SIZE - 1; itr >= col; --itr) {
		    System.out.print(arr[ROW_SIZE - 1][itr] + " ");
		}
		ROW_SIZE--;
	    }

	    // Print the first column from the remaining
	    // columns */
	    if (col < COL_SIZE) {
		for (itr = ROW_SIZE - 1; itr >= row; --itr) {
		    System.out.print(arr[itr][col] + " ");
		}
		col++;
	    }
	}
    }

    // Driver Code
    public static void main(String[] args) {

	int arr[][] = { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 }, { 13, 14, 15, 16, 17, 18 } };

	int rowsize = arr.length;
	int colsize = arr[0].length;

	for (int row = 0; row < arr.length; row++) {
	    System.out.println(Arrays.toString(arr[row]));
	}

	System.out.println();

	// Function Call
	spiralPrint(rowsize, colsize, arr);
    }

}
