package _06_class.exercise._03_OpinionPoll;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		List<Person> listPerson = new ArrayList<Person>();

		int n = Integer.parseInt(scanner.nextLine());

		for (int i = 0; i < n; i++) {
			String[] tokens = scanner	.nextLine()
										.split("\\s+");

			String name = tokens[0];
			int age = Integer.parseInt(tokens[1]);

			Person person = new Person(name, age);
			listPerson.add(person);
		}

		listPerson = listPerson	.stream()
								.filter(p -> p.getAge() > 30)
								.collect(Collectors.toList());

		Comparator<Person> cmpByName = (Person p1, Person p2) -> {
			return p1	.getName()
						.compareTo(p2.getName());

		};

		Collections.sort(listPerson, cmpByName);

		for (Person person : listPerson) {
			System.out.println(person);
		}

	}

}
