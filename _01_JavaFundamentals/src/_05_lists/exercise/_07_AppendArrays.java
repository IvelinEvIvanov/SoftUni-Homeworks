package _05_lists.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _07_AppendArrays {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<String> input = Arrays	.stream(scanner	.nextLine()
													.split("\\|"))
									.collect(Collectors.toList());
		scanner.close();

		List<Integer> numbers = new ArrayList<>();
		List<Integer> resultList = new ArrayList<>();

		for (int i = input.size() - 1; i >= 0; i--) {
			numbers = Arrays.stream(input	.get(i)
											.split("\\s+"))
							.filter(e -> !e.equals(""))
							.map(e -> Integer.parseInt(e))
							.collect(Collectors.toList());

			resultList.addAll(numbers);
		}

		System.out.println(resultList	.toString()
										.replaceAll("[\\[\\],]", ""));
	}
}
