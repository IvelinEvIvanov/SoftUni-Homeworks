package advanced.MultiArraysSolutions;

import java.util.ArrayDeque;
import java.util.Arrays;

public class PossiblePath {

    // to find the path from
    // top left to bottom right
    static boolean isPath(int arr[][]) {
	// set arr[0][0] = 1
	arr[0][0] = 1;

	// Mark reachable (from top left) nodes
	// in first row and first column.
	for (int col = 1; col < 5; col++) {

	    if (arr[0][col] != -1) {
		arr[0][col] = arr[0][col - 1];
	    }
	}

	for (int row = 1; row < 5; row++) {

	    if (arr[row][0] != -1) {
		arr[row][0] = arr[row - 1][0];
	    }
	}

	// Mark reachable nodes in
	// remaining matrix.
	for (int row = 1; row < 5; row++) {
	    for (int col = 1; col < 5; col++) {

		if (arr[row][col] != -1) {
		    arr[row][col] = Math.max(arr[row][col - 1], arr[row - 1][col]);
		}
	    }
	}

	// return yes if right
	// bottom index is 1
	return (arr[5 - 1][5 - 1] == 1);
    }

    // Driver code
    public static void main(String[] args) {
	// Given array
	int arr[][] = { { 0, 0, 0, -1, 0 }, { -1, 0, 0, -1, -1 }, { 0, 0, 0, -1, 0 }, { -1, 0, -1, 0, -1 },
		{ 0, 0, -1, 0, 0 } };

	for (int row = 0; row < arr.length; row++) {
	    System.out.println(Arrays.toString(arr[row]));
	}

	// path from arr[0][0]
	// to arr[row][col]
	if (isPath(arr)) {
	    System.out.println("Yes");
	} else {
	    System.out.println("No");
	}

	System.out.println();

	for (int row = 0; row < arr.length; row++) {
	    System.out.println(Arrays.toString(arr[row]));
	}
    }

}
