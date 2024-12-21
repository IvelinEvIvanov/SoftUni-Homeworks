package advanced.MultiArrays;

import java.util.*;

public class _2_MatrixOfPalindromes {

    public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	String[] input = scan.nextLine().split(" ");

	int rows = Integer.parseInt(input[0]);
	int cols = Integer.parseInt(input[1]);

	String[][] matrix = new String[rows][cols];

	for (int col = 0; col < matrix[0].length; col++) {

	    for (int row = 0; row < matrix.length; row++) {
		matrix[row][col] = "" + (char) ('a' + row) + (char) ('a' + (row + col)) + (char) ('a' + row);
	    }
	}

	printMatrix(matrix);
    }

    static void printMatrix(String pMatrix[][]) {
	for (int row = 0; row < pMatrix.length; row++) {
	    for (int col = 0; col < pMatrix[row].length; col++) {
		System.out.print(pMatrix[row][col] + " ");
	    }
	    System.out.println();
	}
    }

}
