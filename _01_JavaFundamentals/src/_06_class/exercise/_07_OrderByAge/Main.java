package _06_class.exercise._07_OrderByAge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		List<Person> persons = new ArrayList<>();

		while (true) {
			String line = scanner.nextLine();
			if (line.equals("End")) {
				break;
			}

			String[] tokens = line.split(" ");

			String firstName = tokens[0];
			String id = tokens[1];
			Integer age = Integer.parseInt(tokens[2]);

			persons.add(new Person(firstName, id, age));
		}

		scanner.close();

		Collections.sort(persons, (p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()));

		persons.forEach(person -> System.out.println(person.toString()));
	}
}
