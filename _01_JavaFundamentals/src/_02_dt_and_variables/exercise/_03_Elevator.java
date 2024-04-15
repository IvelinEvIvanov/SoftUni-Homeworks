package _02_dt_and_variables.exercise;

import java.util.Scanner;

public class _03_Elevator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int persons = scanner.nextInt();
		int capacity = scanner.nextInt();

		int cources = (int) Math.ceil((double) persons / capacity);
		scanner.close();

		System.out.println(cources);
	}
}
