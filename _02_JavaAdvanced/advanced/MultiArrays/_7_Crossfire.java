package advanced.MultiArrays;

import java.util.ArrayList;
import java.util.Scanner;

public class _7_Crossfire {
    public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);

	String[] input = scan.nextLine().split(" ");
	int n = Integer.parseInt(input[0]);
	int m = Integer.parseInt(input[1]);

	// fill array
	ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();

	for (int i = 0; i < n; i++) {
	    matrix.add(new ArrayList<Integer>());
	}

	int counter = 1;
	for (int row = 0; row < matrix.size(); row++) {
	    for (int col = 0; col < m; col++) {
		matrix.get(row).add(counter++);
	    }
	}

	String nextLine = scan.nextLine();
	while (!nextLine.equals("Nuke it from orbit")) {

	    String[] tokens = nextLine.split(" ");
	    int bombRow = Integer.parseInt(tokens[0]);
	    int bombCol = Integer.parseInt(tokens[1]);
	    int bombRadius = Integer.parseInt(tokens[2]);

	    // bomb rows
	    for (int row = bombRow, count = 0; count <= bombRadius; count++) {
		if (isInBounds(row + count, bombCol, matrix)) {
		    matrix.get(row + count).set(bombCol, 0);
		}

		if (isInBounds(row - count, bombCol, matrix)) {
		    matrix.get(row - count).set(bombCol, 0);
		}
	    }

	    // bomb columns
	    for (int col = bombCol, count = 0; count <= bombRadius; count++) {
		if (isInBounds(bombRow, bombCol + count, matrix)) {
		    matrix.get(bombRow).set(bombCol + count, 0);
		}

		if (isInBounds(bombRow, bombCol - count, matrix)) {
		    matrix.get(bombRow).set(bombCol - count, 0);
		}
	    }

	    for (int row = 0; row < matrix.size(); row++) {
		while (matrix.get(row).contains(0)) {
		    matrix.get(row).remove(Integer.valueOf(0));
		}
	    }

	    nextLine = scan.nextLine();
	}

	// print result
	for (int row = 0; row < matrix.size(); row++) {

	    if (matrix.get(row).size() > 0) {
		for (int col = 0; col < matrix.get(row).size(); col++) {
		    System.out.print(matrix.get(row).get(col) + " ");

		}

		System.out.println();
	    }
	}

    }// main

    public static boolean isInBounds(int row, int col, ArrayList<ArrayList<Integer>> matrix) {
	return (row >= 0 && row < matrix.size()) && (col >= 0 && col < matrix.get(row).size());
    }
}
