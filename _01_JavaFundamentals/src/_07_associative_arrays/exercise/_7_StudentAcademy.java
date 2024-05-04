package _07_associative_arrays.exercise;

import java.util.*;

public class _7_StudentAcademy {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = Integer.parseInt(scanner.nextLine());
		Map<String, List<Double>> students = new LinkedHashMap<String, List<Double>>();

		for (int i = 0; i < n; i++) {
			String student = scanner.nextLine();

			if (!students.containsKey(student)) {
				students.put(student, new ArrayList<Double>());

				double grade = Double.parseDouble(scanner.nextLine());
				students.get(student)
						.add(grade);
			} else {
				double grade = Double.parseDouble(scanner.nextLine());
				students.get(student)
						.add(grade);
			}
		}

		scanner.close();

		Map<String, Double> result = new HashMap<String, Double>();
		students.entrySet()
				.stream()
				.forEach((entry) -> {
					double averageGrade = entry	.getValue()
												.stream()
												.mapToDouble(d -> d)
												.average()
												.getAsDouble();
					if (averageGrade >= 4.5) {
						result.put(entry.getKey(), averageGrade);
					}
				});

		result	.entrySet()
				.stream()
				.sorted((e1, e2) -> e2	.getValue()
										.compareTo(e1.getValue()))
				.forEach(entry -> System.out.printf("%s -> %.2f%n", entry.getKey(), entry.getValue()));
	}
}
