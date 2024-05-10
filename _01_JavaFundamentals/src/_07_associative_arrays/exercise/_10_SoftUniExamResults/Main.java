package _07_associative_arrays.exercise._10_SoftUniExamResults;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Map<String, Student> mapStudent = new LinkedHashMap<>();
		Map<String, Integer> mapSubmission = new LinkedHashMap<>();

		while (true) {
			String line = scanner.nextLine();
			if (line.equals("exam finished")) {
				break;
			}

			String studentName;
			String programLanguage;
			Integer points;

			String[] tokens = line.split("-");
			if (tokens.length == 3) {
				studentName = tokens[0];
				programLanguage = tokens[1];
				points = Integer.parseInt(tokens[2]);

				if (!mapStudent.containsKey(studentName)) {
					Student newStudent = new Student(studentName, programLanguage, points);
					mapStudent.put(studentName, newStudent);
				} else {
					mapStudent	.get(studentName)
								.addSubmission(programLanguage, points);
				}
			} else {
				studentName = tokens[0];
				countSubmissions(mapStudent, mapSubmission, studentName);

				mapStudent.remove(studentName);
			}

		}
		scanner.close();

		System.out.println("Results:");
		mapStudent	.entrySet()
					.stream()
					.sorted((entry1, entry2) -> {
						int result = entry2	.getValue()
											.getMaxPoint()
								- entry1.getValue()
										.getMaxPoint();

						if (result == 0) {
							result = entry1	.getValue()
											.getName()
											.compareTo(entry2	.getValue()
																.getName());
						}

						return result;
					})
					.forEach(entry -> System.out.println(entry	.getValue()
																.toString()));

		countSubmissions(mapStudent, mapSubmission);

		System.out.println("Submissions:");
		mapSubmission	.entrySet()
						.stream()
						.sorted((entry1, entry2) -> {
							int result = entry2.getValue() - entry1.getValue();

							if (result == 0) {
								result = entry1	.getKey()
												.compareTo(entry2.getKey());
							}

							return result;
						})
						.forEach(entry -> System.out.println(entry.getKey() + " - " + entry.getValue()));
	}

	private static void countSubmissions(Map<String, Student> mapStudent, Map<String, Integer> mapSubmission) {

		String programLanguage;

		for (Entry<String, Student> entry : mapStudent.entrySet()) {

			for (Submission submission : mapStudent	.get(entry.getKey())
													.getSubmissions()) {

				programLanguage = submission.getProgramLanguage();

				if (!mapSubmission.containsKey(programLanguage)) {
					mapSubmission.put(programLanguage, 1);
				} else {
					mapSubmission.put(programLanguage, mapSubmission.get(programLanguage) + 1);
				}
			}
		}
	}

	private static void countSubmissions(Map<String, Student> mapStudent, Map<String, Integer> mapSubmission,
			String studentName) {

		String programLanguage;

		for (Submission submission : mapStudent	.get(studentName)
												.getSubmissions()) {

			programLanguage = submission.getProgramLanguage();

			if (!mapSubmission.containsKey(programLanguage)) {
				mapSubmission.put(programLanguage, 1);
			} else {
				mapSubmission.put(programLanguage, mapSubmission.get(programLanguage) + 1);
			}
		}
	}
}
