package _01_statements_and_loops.more_exercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class _1_SortNumbers {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int number1 = Integer.parseInt(scan.nextLine());
		int number2 = Integer.parseInt(scan.nextLine());
		int number3 = Integer.parseInt(scan.nextLine());

		List<Integer> list = Arrays.asList(number1, number2, number3);
		Collections.sort(list);

		for (int i = list.size() - 1; i >= 0; i--) {
			System.out.println(list.get(i));
		}

		scan.close();
	}

}
