package _06_class.lab._05_Students;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		List<Student> students = new ArrayList<>();
		String line = scanner.nextLine();

		while (!line.equals("end")) {
			String[] tokens = line.split("\\s+");

			String firstName = tokens[0];
			String lastName = tokens[1];
			int age = Integer.parseInt(tokens[2]);
			String city = tokens[3];

			Student student = new Student(firstName, lastName, age, city);
			students.add(student);

			line = scanner.nextLine();
		}

		String filterCity = scanner.nextLine();
		scanner.close();

		for (Student student : students) {
			if (student	.getCity()
						.equals(filterCity)) {
				System.out.printf(	"%s %s is %d years old.%n", student.getFirstName(), student.getLastName(),
									student.getAge());
			}
		}

	}
}
