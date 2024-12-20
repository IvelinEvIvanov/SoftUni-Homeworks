package _05_list.lab;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _07_RemoveNegativesAndReverse {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Integer> nums = Arrays	.stream(scanner	.nextLine()
													.split(" "))
									.map(Integer::parseInt)
									.collect(Collectors.toList());
		scanner.close();

		for (int i = 0; i < nums.size(); i++) {
			if (nums.get(i) < 0) {
				nums.remove(i--);
			}
		}

		Collections.reverse(nums);

		if (nums.size() == 0) {
			System.out.println("empty");
		} else {
			System.out.println(nums	.toString()
									.replaceAll("[\\[\\],]", ""));
		}

	}
}
