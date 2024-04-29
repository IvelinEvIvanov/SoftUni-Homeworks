package _04_method.exercise;

import java.util.Scanner;

public class _02_VowelsCount {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String text = scanner.nextLine();
		scanner.close();

		int result = countVowels(text);
		System.out.println(result);
	}

	private static int countVowels(String text) {
		int sum = 0;
		for (int i = 0; i < text.length(); i++) {
			char vowel = text	.toLowerCase()
								.charAt(i);

			switch (vowel) {
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
				sum++;
				break;
			}
		}

		return sum;
	}
}
