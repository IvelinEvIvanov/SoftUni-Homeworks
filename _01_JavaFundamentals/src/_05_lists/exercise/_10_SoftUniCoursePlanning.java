package _05_lists.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _10_SoftUniCoursePlanning {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<String> courseSchedule = Arrays.stream(scanner	.nextLine()
															.split(",\\s+"))
											.collect(Collectors.toList());

		final String EXERCISE = "-Exercise";

		while (true) {
			String command = scanner.nextLine();
			if (command.equals("course start")) {
				break;
			}

			String[] commandTokens = command.split(":");
			String lessonTitle = "";

			switch (commandTokens[0]) {

			case "Add":
				lessonTitle = commandTokens[1];
				if (!doesLessonExist(courseSchedule, lessonTitle)) {
					courseSchedule.add(lessonTitle);
				}
				break;
			case "Insert":
				lessonTitle = commandTokens[1];
				int index = Integer.parseInt(commandTokens[2]);

				if (!doesLessonExist(courseSchedule, lessonTitle)) {
					courseSchedule.add(index, lessonTitle);
				}
				break;
			case "Remove":
				lessonTitle = commandTokens[1];

				if (doesLessonExist(courseSchedule, lessonTitle)) {
					courseSchedule.remove(lessonTitle);
				}

				if (doesExerciseExist(courseSchedule, lessonTitle)) {
					courseSchedule.remove(lessonTitle + EXERCISE);
				}
				break;
			case "Swap":
				String lessonTitleOne = commandTokens[1];
				String lessonTitleTwo = commandTokens[2];

				if (doesLessonExist(courseSchedule, lessonTitleOne)
						&& doesLessonExist(courseSchedule, lessonTitleTwo)) {

					boolean hasLessonTitleOneExecise = doesExerciseExist(courseSchedule, lessonTitleOne);
					boolean hasLessonTitleTwoExecise = doesExerciseExist(courseSchedule, lessonTitleTwo);

					int lessonTitleOneIndex = courseSchedule.indexOf(lessonTitleOne);
					int lessonTitleTwoIndex = courseSchedule.indexOf(lessonTitleTwo);

					courseSchedule.set(lessonTitleOneIndex, lessonTitleTwo);
					courseSchedule.set(lessonTitleTwoIndex, lessonTitleOne);

					if (hasLessonTitleOneExecise) {
						courseSchedule.remove(lessonTitleOneIndex + 1);
						courseSchedule.add(lessonTitleTwoIndex + 1, lessonTitleOne + EXERCISE);
					}

					if (hasLessonTitleTwoExecise) {
						courseSchedule.remove(lessonTitleTwoIndex + 1);
						courseSchedule.add(lessonTitleOneIndex + 1, lessonTitleTwo + EXERCISE);
					}
				}
				break;
			case "Exercise":
				lessonTitle = commandTokens[1];
				boolean doesLessonExist = doesLessonExist(courseSchedule, lessonTitle);

				if (doesLessonExist && !doesExerciseExist(courseSchedule, lessonTitle)) {
					int lessonIndex = courseSchedule.indexOf(lessonTitle);
					courseSchedule.add(lessonIndex + 1, lessonTitle + EXERCISE);

				} else if (!doesLessonExist) {
					courseSchedule.add(lessonTitle);
					courseSchedule.add(lessonTitle + EXERCISE);
				}
				break;

			}

		}

		scanner.close();
		int counter = 1;
		for (String item : courseSchedule) {
			System.out.printf("%d.%s%n", counter++, item);
		}

	}

	private static boolean doesLessonExist(List<String> courseSchedule, String lessonTitle) {
		if (courseSchedule.contains(lessonTitle)) {
			return true;
		}
		return false;
	}

	private static boolean doesExerciseExist(List<String> courseSchedule, String lessonTitle) {
		if (courseSchedule.contains(lessonTitle + "-Exercise")) {
			return true;
		}
		return false;
	}
}
