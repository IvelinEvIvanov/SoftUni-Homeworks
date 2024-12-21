package advanced.MultiArrays;

import java.util.*;

public class _1_FillTheMatrix {

    public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);

	String[] tokens = scan.nextLine().split(",\\s+");
	int n = Integer.parseInt(tokens[0]);
	String pattern = tokens[1];

	int[][] matrix = new int[n][n];

	if (pattern.equals("A")) {
	    fillPatternA(matrix);
	    printMatrix(matrix);
	} else if (pattern.equals("B")) {
	    fillPatternB(matrix);
	    printMatrix(matrix);
	}

    }

    static void fillPatternA(int matrix[][]) {

	int number = 0;

	for (int col = 0; col < matrix[0].length; col++) {
	    for (int row = 0; row < matrix.length; row++) {
		matrix[row][col] = ++number;
	    }
	}
    }

    static void fillPatternB(int matrix[][]) {

	int number = 0;
	int row = 0;

	for (int col = 0; col < matrix[0].length; col++) {

	    if (col % 2 == 0) {
		row = 0;
		for (; row < matrix.length; row++) {
		    matrix[row][col] = ++number;
		}
	    } else {
		row = matrix.length - 1;
		for (; row >= 0; row--) {
		    matrix[row][col] = ++number;
		}
	    }

	}

    }

    static void printMatrix(int matrix[][]) {
	for (int row = 0; row < matrix.length; row++) {
	    for (int col = 0; col < matrix[row].length; col++) {
		System.out.print(matrix[row][col] + " ");
	    }
	    System.out.println();
	}
    }

}
