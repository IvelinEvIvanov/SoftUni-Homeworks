package advanced.MultiArrays;

import java.util.Scanner;

public class _3_DiagonalDifference {

    public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);

	int n = Integer.parseInt(scan.nextLine());

	int[][] matrix = new int[n][n];
	for (int row = 0; row < matrix.length; row++) {

	    String[] input = scan.nextLine().split(" ");

	    for (int col = 0; col < matrix[row].length; col++) {

		int number = Integer.parseInt(input[col]);
		matrix[row][col] = number;
	    }
	}

	int sumDiagonal_1 = 0;
	int sumDigonal_2 = 0;

	sumDiagonal_1 = getDiagonal_1(matrix);
	sumDigonal_2 = getDiagonal_2(matrix);

	System.out.println(Math.abs(sumDiagonal_1 - sumDigonal_2));
    }

    private static int getDiagonal_2(int[][] matrix) {

	int sum = 0;
	int diagonal = matrix.length - 1;

	for (int row = 0; row < matrix.length; row++) {
	    sum += (matrix[row][diagonal--]);
	}

	return sum;
    }

    private static int getDiagonal_1(int[][] matrix) {

	int sum = 0;
	int diagonal = 0;

	for (int row = 0; row < matrix.length; row++) {
	    sum += (matrix[row][diagonal++]);
	}

	return sum;

    }

}
