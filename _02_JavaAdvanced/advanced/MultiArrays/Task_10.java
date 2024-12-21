package advanced.MultiArrays;

import java.util.Scanner;

public class Task_10 {

    public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);

	String[] tokens = scan.nextLine().split(" ");
	int sizeRow = Integer.parseInt(tokens[0]);
	int sizeCol = Integer.parseInt(tokens[1]);

	int playerRow = 0;
	int playerCol = 0;

	char[][] arr = new char[sizeRow][sizeCol];
	char[][] checkingArr = new char[sizeRow][sizeCol];

	// fill array
	for (int row = 0; row < sizeRow; row++) {

	    String input = scan.nextLine();
	    int pIndex = input.indexOf("P");
	    if (pIndex >= 0) {
		playerRow = row;
		playerCol = pIndex;
	    }

	    arr[row] = input.toCharArray();

	}

	String[] commands = scan.nextLine().split("");
	Boolean isDead = false;

	for (int i = 0; i < commands.length; i++) {

	    if (isDead) {
		printDead(arr, playerRow, playerCol);
		return;
	    }

	    String command = commands[i];
	    switch (command) {
	    case "U":
		if (playerRow == 0) {
		    spreadBunnies(arr, checkingArr, isDead);
		    printWon(arr, playerRow, playerCol);
		    return;
		} else if (arr[playerRow - 1][playerCol] == '.') {
		    arr[playerRow][playerCol] = '.';
		    playerRow--;
		    arr[playerRow][playerCol] = 'P';

		    spreadBunnies(arr, checkingArr, isDead);
		    checkingArr = new char[sizeRow][sizeCol];

		}
		break;
	    case "D":
		if (playerRow == arr.length - 1) {
		    spreadBunnies(arr, checkingArr, isDead);
		    printWon(arr, playerRow, playerCol);
		    return;
		} else if (arr[playerRow + 1][playerCol] == '.') {
		    arr[playerRow][playerCol] = '.';
		    playerRow++;
		    arr[playerRow][playerCol] = 'P';

		    spreadBunnies(arr, checkingArr, isDead);
		    checkingArr = new char[sizeRow][sizeCol];

		}

		break;
	    case "L":
		if (playerCol == 0) {
		    spreadBunnies(arr, checkingArr, isDead);
		    printWon(arr, playerRow, playerCol);
		    return;
		} else if (arr[playerRow][playerCol - 1] == '.') {
		    arr[playerRow][playerCol] = '.';
		    playerCol--;
		    arr[playerRow][playerCol] = 'P';

		    spreadBunnies(arr, checkingArr, isDead);
		    checkingArr = new char[sizeRow][sizeCol];

		}
		break;
	    case "R":

		break;

	    }
	}

	System.out.println();

    }

    private static void printDead(char[][] arr, int playerRow, int playerCol) {
	for (char[] itr : arr) {
	    for (char value : itr) {
		System.out.print(value);
	    }

	    System.out.println();
	}

	System.out.println("dead: " + playerRow + " " + playerCol);

    }

    private static void spreadBunnies(char[][] arr, char[][] checkingArr, Boolean isDead) {

	int previuosCol = 0;
	for (int row = 0; row < arr.length; row++) {
	    for (int col = 0; col < arr[row].length; col++) {
		if (row == 0 && col == 0) {
		    if (arr[row][col] == 'B') {
			if (checkingArr[row + 1][col] != 'x' && arr[row + 1][col] == '.') {
			    arr[row + 1][col] = 'B';
			    checkingArr[row + 1][col] = 'x';
			} else if (arr[row + 1][col] == 'P') {
			    isDead = true;
			}

			if (checkingArr[row][col + 1] != 'x' && arr[row][col + 1] == '.') {
			    arr[row][col + 1] = 'B';
			    checkingArr[row][col + 1] = 'x';

			    col++;
			} else if (arr[row + 1][col] == 'P') {
			    isDead = true;
			}
		    }
		} else {
		    if (row != arr.length - 1) {

			if (arr[row][col] == 'B' && checkingArr[row][col] != 'x') {
			    if (checkingArr[row + 1][col] == 0 && arr[row + 1][col] == '.') {
				arr[row + 1][col] = 'B';
				checkingArr[row + 1][col] = 'x';
			    } else if (arr[row + 1][col] == 'P') {
				isDead = true;
			    }

			    if (row > 0) {
				if (checkingArr[row - 1][col] != 'x' && arr[row - 1][col] == '.') {
				    arr[row - 1][col] = 'B';
				    checkingArr[row - 1][col] = 'x';
				}
			    }

			    if (col != arr[row].length - 1) {

				previuosCol = col;
				if (checkingArr[row][col + 1] != 'x' && arr[row][col + 1] == '.') {
				    arr[row][col + 1] = 'B';
				    checkingArr[row][col + 1] = 'x';

				    col++;
				}

				if (previuosCol > 0) {
				    if (checkingArr[row][previuosCol - 1] != 'x' && arr[row][previuosCol - 1] == '.') {
					arr[row][previuosCol - 1] = 'B';
					checkingArr[row][previuosCol - 1] = 'x';

					if (col == previuosCol) {
					    col++;
					}
				    }
				}

			    } else {
				if (checkingArr[row][col - 1] != 'x' && arr[row][col - 1] == '.') {
				    arr[row][col - 1] = 'B';
				    checkingArr[row][col - 1] = 'B';
				}
			    }
			}
		    } else {
			if (col != arr[row].length - 1) {

			    previuosCol = col;
			    if (checkingArr[row][col + 1] != 'x' && arr[row][col + 1] == '.') {
				arr[row][col + 1] = 'B';
				checkingArr[row][col + 1] = 'x';

				col++;
			    }

			    if (previuosCol > 0) {
				if (checkingArr[row][previuosCol - 1] != 'x' && arr[row][previuosCol - 1] == '.') {
				    arr[row][previuosCol - 1] = 'B';
				    checkingArr[row][previuosCol - 1] = 'x';

				    if (col == previuosCol) {
					col++;
				    }
				}
			    }

			} else {
			    if (checkingArr[row][col - 1] != 'x' && arr[row][col - 1] == '.') {
				arr[row][col - 1] = 'B';
				checkingArr[row][col - 1] = 'x';
			    }
			}
		    }
		}
	    }
	}

    }

    private static void printWon(char[][] arr, int playerRow, int playerCol) {
	for (char[] itr : arr) {
	    for (char value : itr) {
		System.out.print(value);
	    }

	    System.out.println();
	}

	System.out.println("won: " + playerRow + " " + playerCol);

    }

}
