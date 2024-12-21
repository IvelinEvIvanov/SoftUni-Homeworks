package advanced.MultiArraysSolutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralForm_1 {
    // Function to print in spiral order
    public static List<Integer> spiralOrder(int[][] matrix) {

	List<Integer> result = new ArrayList<Integer>();

	if (matrix.length == 0) {
	    return result;
	}

	final int ROW_SIZE = matrix.length;
	final int COL_SIZE = matrix[0].length;

	boolean[][] seen = new boolean[ROW_SIZE][COL_SIZE];

	int[] directionRow = { 0, 1, 0, -1 };
	int[] directionCol = { 1, 0, -1, 0 };

	int row = 0;
	int col = 0;
	int direction = 0;

	// Iterate from 0 to R * C - 1
	for (int i = 0; i < ROW_SIZE * COL_SIZE; i++) {

	    result.add(matrix[row][col]);

	    seen[row][col] = true;
	    int currentRow = row + directionRow[direction];
	    int currentCol = col + directionCol[direction];

	    if ((0 <= currentRow && currentRow < ROW_SIZE) && (0 <= currentCol && currentCol < COL_SIZE)
		    && !seen[currentRow][currentCol]) {

		row = currentRow;
		col = currentCol;
	    } else {
		direction = (direction + 1) % 4;
		row += directionRow[direction];
		col += directionCol[direction];
	    }
	}

	return result;
    }

    // Driver Code
    public static void main(String[] args) {
	int arr[][] = { { 1, 2, 3, 4, 5 }, { 5, 6, 7, 8, 10 }, { 9, 10, 11, 12, 15 } };

	for (int row = 0; row < arr.length; row++) {
	    System.out.println(Arrays.toString(arr[row]));
	}

	System.out.println();

	System.out.println(spiralOrder(arr));
    }

}
