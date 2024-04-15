package _02_dt_and_variables.lab;

import java.util.Scanner;

public class _04_TownInfo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String town = sc.nextLine();
		int population = sc.nextInt();
		int area = sc.nextInt();

		sc.close();

		System.out.printf("Town %s has population of %d and area %d square km.", town, population, area);
	}

}
