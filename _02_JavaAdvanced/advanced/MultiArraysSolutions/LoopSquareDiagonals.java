package advanced.MultiArraysSolutions;

import java.util.Scanner;

public class LoopSquareDiagonals {

    public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);

	String[] tokens = scan.nextLine().split(" ");

	int sizeRow = Integer.parseInt(tokens[0]);
	int sizeCol = Integer.parseInt(tokens[1]);

	int[][] arr = new int[sizeRow][sizeCol];

	// fill array
	for (int i = 0; i < arr.length; i++) {
	    tokens = scan.nextLine().split(" ");
	    for (int j = 0; j < tokens.length; j++) {
		arr[i][j] = Integer.parseInt(tokens[j]);
	    }
	}

	int length = arr.length;
	int diagonalLines = (length + length) - 1;
	int midPoint = (diagonalLines / 2) + 1;
	int itemsInDiagonal = 0;

	for (int i = 1; i <= diagonalLines; i++) {
	    int rowIndex;
	    int columnIndex;

	    if (i <= midPoint) {
		itemsInDiagonal++;
		for (int j = 0; j < itemsInDiagonal; j++) {
		    rowIndex = (i - j) - 1;
		    columnIndex = j;

		    System.out.print(arr[rowIndex][columnIndex] + " ");
		}
		System.out.println();
	    } else {
		itemsInDiagonal--;
		for (int j = 0; j < itemsInDiagonal; j++) {
		    rowIndex = (length - 1) - j;
		    columnIndex = (i - length) + j;

		    System.out.print(arr[rowIndex][columnIndex] + " ");
		}
		System.out.println();
	    }
	}

    }

}
