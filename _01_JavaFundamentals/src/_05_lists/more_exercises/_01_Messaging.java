package _05_lists.more_exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _01_Messaging {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Integer> numbers = Arrays	.stream(scanner	.nextLine()
														.split(" "))
										.map(Integer::parseInt)
										.collect(Collectors.toList());

		String strInput = scanner.nextLine();
		scanner.close();

		int strLength = strInput.length();
		String result = "";

		for (Integer number : numbers) {
			int sum = 0;
			while (number != 0) {
				int lastDigit = number % 10;
				number /= 10;
				sum += lastDigit;
			}

			if (sum > strLength) {
				result += strInput.charAt(1);
			} else {
				result += strInput.charAt(sum);
				strInput = updateString(strInput, sum, sum, strInput.length());
			}
		}

		System.out.println(result);
	}

	private static String updateString(String strInput, int leftiIndex, int rightIndex, int strLength) {
		String leftSubStr = strInput.substring(0, rightIndex);
		String rightSubStr = strInput.substring(leftiIndex + 1, strLength);

		return leftSubStr + rightSubStr;
	}
}
