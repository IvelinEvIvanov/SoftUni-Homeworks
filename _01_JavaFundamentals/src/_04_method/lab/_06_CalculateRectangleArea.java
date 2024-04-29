package _04_method.lab;

import java.util.Scanner;

public class _06_CalculateRectangleArea {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double width = Double.parseDouble(scanner.nextLine());
		double height = Double.parseDouble(scanner.nextLine());
		scanner.close();

		double area = getRectangleArea(width, height);
		System.out.println(area);
	}

	private static double getRectangleArea(double width, double height) {
		return width * height;
	}
}
