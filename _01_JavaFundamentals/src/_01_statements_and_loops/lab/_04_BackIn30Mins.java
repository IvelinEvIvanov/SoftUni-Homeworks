package _01_statements_and_loops.lab;

import java.util.Scanner;

public class _04_BackIn30Mins {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int hours = sc.nextInt();
		int minutes = sc.nextInt() + 30;

		if (minutes > 59) {
			hours += 1;
			minutes -= 60;
		}
		
		if (hours > 23) {
			hours = 0;
		}
		
		if (minutes < 10) {
			System.out.printf("%d:%02d%n", hours, minutes);
		} else {
			System.out.printf("%d:%d", hours, minutes);
		}
		
		sc.close();
	}

}
