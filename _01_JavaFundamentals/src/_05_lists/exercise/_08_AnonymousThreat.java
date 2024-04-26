package _05_lists.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _08_AnonymousThreat {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<String> stringList = Arrays.stream(scanner	.nextLine()
														.split(" "))
										.collect(Collectors.toList());

		while (true) {
			String command = scanner.nextLine();

			if (command.equals("3:1")) {
				break;
			}

			String[] cammandArgs = command.split("\\s+");

			switch (cammandArgs[0]) {
			case "merge":
				int startIndex = Integer.parseInt(cammandArgs[1]);
				int endIndex = Integer.parseInt(cammandArgs[2]);

				int listSize = stringList.size();
				String mergedElements = "";

				if (startIndex >= -1000 && endIndex <= 1000 && startIndex < endIndex) {

					if (startIndex >= 0 && endIndex < listSize) {
						mergedElements = mergeElements(stringList, startIndex, endIndex, mergedElements);
						stringList.add(startIndex, mergedElements);
					} else if (startIndex >= 0 && startIndex < listSize) {
						mergedElements = mergeElements(stringList, startIndex, listSize - 1, mergedElements);
						stringList.add(startIndex, mergedElements);
					} else if (endIndex >= 0 && endIndex < listSize) {
						mergedElements = mergeElements(stringList, endIndex, listSize - 1, mergedElements);
						stringList.add(endIndex, mergedElements);
					}

				}

				break;

			case "divide":
				int index = Integer.parseInt(cammandArgs[1]);
				int partitions = Integer.parseInt(cammandArgs[2]);

				if (index >= 0 && index < stringList.size() && partitions >= 0 && partitions <= 100) {
					String element = stringList.get(index);

					int subPartitionsLength = element.length() / partitions;
					List<String> dividedElements = new ArrayList<>();
					String appended = "";
					int[] count = new int[] { 0 };

					if (element.length() % partitions == 0) {

						for (int i = 0; i < partitions; i++) {
							String concat = "";
							appended = appendSymbols(element, subPartitionsLength, count, concat);

							dividedElements.add(appended);
						}
					} else {

						for (int i = 0; i < partitions; i++) {
							String concat = "";

							if (i == partitions - 1) {
								appended = appendSymbols(element, element.length(), count, concat);
							} else {
								appended = appendSymbols(element, subPartitionsLength, count, concat);
							}

							dividedElements.add(appended);
						}
					}

					stringList.remove(index);
					stringList.addAll(index, dividedElements);

					break;
				}
			}
		}

		scanner.close();
		
		System.out.println(stringList	.toString()
										.replaceAll("[\\[\\],]", ""));
	}

	private static String appendSymbols(String element, int end, int[] count, String concat) {

		for (int i = 0; i < end; i++) {
			char symbol = element.charAt(count[0]);
			concat += symbol;
			count[0]++;
		}

		return concat;
	}

	private static String mergeElements(List<String> stringList, int startIndex, int endIndex, String mergedElements) {
		int count = startIndex;
		while (count++ <= endIndex) {
			mergedElements += stringList.remove(startIndex);
		}
		return mergedElements;
	}
}
