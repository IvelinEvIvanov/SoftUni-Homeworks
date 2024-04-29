package _05_list.more_exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _03_TakeSkipRope {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String strInput = scanner.nextLine();

		List<Character> charList = new ArrayList<>();

		// Make Character List
		for (int i = 0; i < strInput.length(); i++) {
			charList.add(strInput.charAt(i));
		}
		scanner.close();

		List<Character> digitList = new ArrayList<>();
		List<Character> symbolList = new ArrayList<>();

		// Fill Digit List
		for (Character character : charList) {

			if (Character.isDigit(character)) {
				digitList.add(character);
			} else {
				symbolList.add(character);
			}
		}

		List<Integer> takeList = new ArrayList<>();
		List<Integer> skipList = new ArrayList<>();

		// Fill Odd-Even List
		for (int i = 0; i < digitList.size(); i++) {
			String digit = "" + digitList.get(i);

			if (i % 2 == 0) {
				takeList.add(Integer.parseInt(digit));
			} else {
				skipList.add(Integer.parseInt(digit));
			}
		}

		String result = "";
		int currentIndex = 0;
		for (int i = 0; i < takeList.size(); i++) {

			int takeCount = takeList.get(i);
			if (takeCount > 0) {
				for (int j = takeCount; j > 0 && currentIndex < symbolList.size(); j--) {
					result += "" + symbolList.get(currentIndex++);
				}
			}

			int skipCount = skipList.get(i);
			currentIndex += skipCount;
		}

		System.out.println(result);
	}
}
