package _06_class.lab._06_Students_v2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import _06_class.lab._05_Students.Student;

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

			if (isStudentExisting(students, firstName, lastName)) {
				Student student = getStudent(students, firstName, lastName);

				student.setFirstName(firstName);
				student.setLastName(lastName);
				student.setAge(age);
				student.setCity(city);
			} else {
				Student student = new Student(firstName, lastName, age, city);
				students.add(student);
			}

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

	private static boolean isStudentExisting(List<Student> students, String firstName, String lastName) {
		for (Student student : students) {
			if (student	.getFirstName()
						.equals(firstName)
					&& student	.getLastName()
								.equals(lastName))
				return true;
		}

		return false;
	}

	private static Student getStudent(List<Student> students, String firstName, String lastName) {
		Student existingStudent = null;

		for (Student student : students) {
			if (student	.getFirstName()
						.equals(firstName)
					&& student	.getLastName()
								.equals(lastName)) {

				return student;
			}
		}

		return existingStudent;
	}

}
