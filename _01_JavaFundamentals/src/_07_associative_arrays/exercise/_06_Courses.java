package _07_associative_arrays.exercise;

import java.util.*;

public class _06_Courses {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Map<String, List<String>> courses = new LinkedHashMap<>();

		String input = scanner.nextLine();
		while (!input.equals("end")) {
			String[] tokens = input.split("\\s+:\\s+");

			String kCourseName = tokens[0];
			String student = tokens[1];
			if (!courses.containsKey(kCourseName)) {
				List<String> vStudents = new ArrayList<>();
				courses.put(kCourseName, vStudents);
				courses	.get(kCourseName)
						.add(student);
			} else {
				courses	.get(kCourseName)
						.add(student);
			}

			input = scanner.nextLine();
		}

		scanner.close();

		courses	.entrySet()
				.stream()
				.sorted((entry1, entry2) -> {
					int entry1Size = entry1	.getValue()
											.size();
					int entry2Size = entry2	.getValue()
											.size();

					return entry2Size - entry1Size;

				})
				.forEach((entry) -> {
					System.out.println(entry.getKey() + ": " + entry.getValue()
																	.size());
					entry	.getValue()
							.sort((student1, student2) -> student1.compareTo(student2));
					
					entry	.getValue()
							.forEach((student) -> {
								System.out.println("-- " + student);
							});
				});
	}
}
