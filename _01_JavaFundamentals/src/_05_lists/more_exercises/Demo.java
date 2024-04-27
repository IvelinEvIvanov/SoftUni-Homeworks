package _05_lists.more_exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Demo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Integer> numbers = Arrays	.stream(scanner	.nextLine()
														.split(" "))
										.map(Integer::parseInt)
										.collect(Collectors.toList());
		
		scanner.close();

		
		System.out.println(numbers	.toString()
									.replaceAll("[\\[\\],]", ""));
	}

}
