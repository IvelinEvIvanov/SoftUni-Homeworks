package _03_array.exercise;

import java.util.Scanner;

public class _01_Train {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int n = Integer.parseInt(scan.nextLine());
		int[] wagons = new int[n];

		for (int i = 0; i < n; i++) {
			wagons[i] = Integer.parseInt(scan.nextLine());
		}

		int sum = 0;

		for (int itr : wagons) {
			System.out.print(itr + " ");
			sum += itr;
		}

		scan.close();

		System.out.println();
		System.out.println(sum);

	}

}
