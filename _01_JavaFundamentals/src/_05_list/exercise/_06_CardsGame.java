package _05_list.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _06_CardsGame {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Integer> deckOne = Arrays	.stream(scanner	.nextLine()
														.split(" "))
										.map(Integer::parseInt)
										.collect(Collectors.toList());

		List<Integer> deckTwo = Arrays	.stream(scanner	.nextLine()
														.split(" "))
										.map(Integer::parseInt)
										.collect(Collectors.toList());

		scanner.close();

		while (deckOne.size() > 0 && deckTwo.size() > 0) {
			Integer cardOne = deckOne.remove(0);
			Integer cardTwo = deckTwo.remove(0);

			if (cardOne > cardTwo) {
				deckOne.add(cardOne);
				deckOne.add(cardTwo);
			} else if (cardTwo > cardOne) {
				deckTwo.add(cardTwo);
				deckTwo.add(cardOne);
			}
		}

		int sum = 0;
		if (deckOne.size() != 0) {
			sum = sumCards(deckOne, sum);
			System.out.println("First player wins! Sum: " + sum);
		} else {
			sum = sumCards(deckTwo, sum);
			System.out.println("Second player wins! Sum: " + sum);
		}
	}

	private static int sumCards(List<Integer> deck, int sum) {
		for (Integer card : deck) {
			sum += card;
		}
		return sum;
	}
}
