package advanced.MultiArraysSolutions;

import java.util.ArrayDeque;
import java.util.Arrays;

public class SpiralFormReverse {
    public static void antiSpiralTraversal(int ROW_SIZE, int COL_SIZE, int a[][]) {

	int itr;
	int row = 0;
	int col = 0;
	/*
	 * row - starting row index ROW_SIZE - ending row index col - starting column
	 * index COL_SIZE - ending column index itr - iterator
	 */
	ArrayDeque<Integer> stk = new ArrayDeque<Integer>();

	while (row <= ROW_SIZE && col <= COL_SIZE) {
	    /*
	     * Print the first row from the remaining rows
	     */
	    for (itr = col; itr <= COL_SIZE; ++itr)
		stk.push(a[row][itr]);
	    row++;

	    /*
	     * Print the last column from the remaining columns
	     */
	    for (itr = row; itr <= ROW_SIZE; ++itr)
		stk.push(a[itr][COL_SIZE]);
	    COL_SIZE--;

	    /*
	     * Print the last row from the remaining rows
	     */
	    if (row <= ROW_SIZE) {
		for (itr = COL_SIZE; itr >= col; --itr)
		    stk.push(a[ROW_SIZE][itr]);
		ROW_SIZE--;
	    }

	    /*
	     * Print the first column from the remaining columns
	     */
	    if (col <= COL_SIZE) {
		for (itr = ROW_SIZE; itr >= row; --itr)
		    stk.push(a[itr][col]);
		col++;
	    }
	}

	while (!stk.isEmpty()) {
	    System.out.print(stk.peek() + " ");
	    stk.pop();
	}
    }

    /* Driver program to test above function */
    public static void main(String[] args) {
	int arr[][] = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 } };

	for (int row = 0; row < arr.length; row++) {
	    System.out.println(Arrays.toString(arr[row]));
	}

	System.out.println();

	antiSpiralTraversal(arr.length - 1, arr[0].length - 1, arr);
    }

}
