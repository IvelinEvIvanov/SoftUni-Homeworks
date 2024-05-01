package _06_class.exercise._05_Students;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());

		List<Student> students = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			String[] tokens = scanner	.nextLine()
										.split("\\s+");

			String firstName = tokens[0];
			String lastName = tokens[1];
			double grade = Double.parseDouble(tokens[2]);

			students.add(new Student(firstName, lastName, grade));
		}
		scanner.close();

		Collections.sort(students, (s1, s2) -> Double.compare(s2.getGrade(), s1.getGrade()));

		students.forEach(student -> System.out.println(student.toString()));
	}
}
