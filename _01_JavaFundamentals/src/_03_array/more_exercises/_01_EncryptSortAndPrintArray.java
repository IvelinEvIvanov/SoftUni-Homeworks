package _03_array.more_exercises;

import java.util.Arrays;
import java.util.Scanner;

public class _01_EncryptSortAndPrintArray {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		final int n = Integer.parseInt(scanner.nextLine());

		String[] inputArr = new String[n];
		int[] outputArr = new int[n];

		for (int i = 0; i < n; i++) {
			inputArr[i] = scanner.nextLine();
		}

		// loop items
		for (int i = 0; i < inputArr.length; i++) {
			String item = inputArr[i];
			int itemLength = item.length();

			int sum = 0;

			// loop item characters
			for (int j = 0; j < itemLength; j++) {
				char symbol = item.charAt(j);
				sum += encryptSymbol(symbol, itemLength);
			}

			outputArr[i] = sum;
		}

		scanner.close();

		Arrays.sort(outputArr);

		for (int item : outputArr) {
			System.out.println(item);
		}
	}

	private static int encryptSymbol(char symbol, int itemLength) {
		switch (symbol) {
		case 'a':
		case 'e':
		case 'i':
		case 'o':
		case 'u':
		case 'A':
		case 'E':
		case 'I':
		case 'O':
		case 'U':
			return (int) symbol * itemLength;
		default:
			return (int) symbol / itemLength;
		}
	}
}
