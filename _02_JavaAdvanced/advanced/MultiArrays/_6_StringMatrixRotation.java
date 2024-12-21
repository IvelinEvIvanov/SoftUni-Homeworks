package advanced.MultiArrays;

import java.util.*;

public class _6_StringMatrixRotation {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String rotation = scan.nextLine();
		String data = scan.nextLine();

		ArrayList<String> list = new ArrayList<>();

		while (!data.equals("END")) {
			list.add(data);
			data = scan.nextLine();
		}

		int maxRowLenght = list.stream().map(row -> row.length()).max(Integer::compare).get();
		char[][] charArr = new char[list.size()][maxRowLenght];

		for (int row = 0; row < list.size(); row++) {
			charArr[row] = list.get(row).toCharArray();
		}

		int degree = Integer.parseInt(rotation.substring(rotation.indexOf("(") + 1, rotation.length() - 1));
		while (degree >= 360) {
			degree = degree % 360;
		}

		char[][] rotatedArr = new char[maxRowLenght][list.size()];
		if (degree == 0) {
			printArr(charArr);
		} else if (degree == 90) {
			int nextRow = 0;
			int lastCol = rotatedArr[0].length - 1;

			for (int row = 0; row < charArr.length; row++, lastCol--) {
				for (int col = 0; col < charArr[row].length; col++, nextRow++) {
					rotatedArr[nextRow][lastCol] = charArr[row][col];
				}
				nextRow = 0;
			}

			printArr(rotatedArr);
		} else if (degree == 180) {
			for (int i = list.size() - 1; i >= 0; i--) {
				StringBuilder sb = new StringBuilder(list.get(i));
				System.out.println(sb.reverse());
			}
		} else if (degree == 270) {
			int lastRow = rotatedArr.length - 1;
			int nextCol = 0;

			for (int row = 0; row < charArr.length; row++, nextCol++) {
				for (int col = 0; col < charArr[row].length; col++, lastRow--) {
					rotatedArr[lastRow][nextCol] = charArr[row][col];
				}

				lastRow = rotatedArr.length - 1;
			}

			printArr(rotatedArr);
		}

	}

	private static void printArr(char[][] charArr) {
		for (int row = 0; row < charArr.length; row++) {
			for (int col = 0; col < charArr[row].length; col++) {
				if (charArr[row][col] == 0) {
					System.out.print(' ');
				} else {
					System.out.print("" + charArr[row][col]);
				}
			}

			System.out.println();
		}

	}

}
