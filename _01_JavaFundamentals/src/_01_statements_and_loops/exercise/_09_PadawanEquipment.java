package _01_statements_and_loops.exercise;

import java.util.Scanner;

public class _09_PadawanEquipment {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		double cash = Double.parseDouble(scan.nextLine());
		int students = Integer.parseInt(scan.nextLine());
		double sabrePrice = Double.parseDouble(scan.nextLine());
		double robePrice = Double.parseDouble(scan.nextLine());
		double beltPrice = Double.parseDouble(scan.nextLine());

		double totalSum = (students * sabrePrice) + (students * robePrice) + (students * beltPrice);

		int moreSabres = (int) Math.ceil(students * 0.1);
		totalSum = totalSum + (moreSabres * sabrePrice);

		double beltDiscount = (students / 6) * beltPrice;
		totalSum -= beltDiscount;

		cash -= totalSum;
		if (cash >= 0) {
			System.out.printf("The money is enough - it would cost %.2flv.%n", totalSum);
		} else {
			cash = Math.abs(cash);
			System.out.printf("Ivan Cho will need %.2flv more.", cash);
		}

		scan.close();
	}
}
