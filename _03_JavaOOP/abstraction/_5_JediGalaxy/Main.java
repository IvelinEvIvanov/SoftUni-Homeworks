package abstraction._5_JediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);

	int[] dimestions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
	int x = dimestions[0];
	int y = dimestions[1];

	int[][] matrix = new int[x][y];

	int value = 0;
	buildMatrix(matrix, x, y, value);

	String command = scanner.nextLine();
	long sum = 0;
	while (!command.equals("Let the Force be with you")) {
	    int[] ivoS = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
	    int[] evil = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
	    int xE = evil[0];
	    int yE = evil[1];

	    moveEvil(matrix, xE, yE);

	    int xI = ivoS[0];
	    int yI = ivoS[1];

	    sum = moveIvo(matrix, xI, yI, sum);

	    command = scanner.nextLine();
	}

	System.out.println(sum);

    }

    static void buildMatrix(int[][] matrix, int x, int y, int value) {
	for (int i = 0; i < x; i++) {
	    for (int j = 0; j < y; j++) {
		matrix[i][j] = value++;
	    }
	}
    }

    static void moveEvil(int matrix[][], int xE, int yE) {
	while (xE >= 0 && yE >= 0) {
	    if (xE >= 0 && xE < matrix.length && yE >= 0 && yE < matrix[0].length) {
		matrix[xE][yE] = 0;
	    }
	    xE--;
	    yE--;
	}
    }

    public static long moveIvo(int matrix[][], int xI, int yI, long sum) {

	while (xI >= 0 && yI < matrix[1].length) {
	    if (xI >= 0 && xI < matrix.length && yI >= 0 && yI < matrix[0].length) {
		sum += matrix[xI][yI];
	    }

	    yI++;
	    xI--;
	}

	return sum;
    }

}
