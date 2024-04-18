package _03_arrays.exercise;

import java.util.Scanner;

public class _09_KaminoFactory {

	static int findTotalSum(String[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals("1")) {
				sum++;
			}
		}

		return sum;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int dnaLength = Integer.parseInt(scan.nextLine());
		String endCommand = "Clone them!";
		String dnaSequences = "";
		String sequence = "";
		while (!endCommand.equals(sequence)) {
			sequence = scan.nextLine();
			if (!sequence.equals(endCommand)) {
				dnaSequences += sequence + "-";
			}
		}

		scan.close();

		String[] arrStrings = dnaSequences.split("-");
		String[] nextDna = arrStrings[0].split("!");

		// Global variables to keep values for best DNA
		int totalSum = 0;
		int longestSequence = 0;
		int leftmostIndex = 0;
		int bestDNASampleIndex = 0;
		boolean isSameLeftIndex = false;

		// Temporal variables for single DNA
		int tempCounter = 0;
		int tempSum = 0;
		// Loop first DNA for
		// LongestSequence,LeftmostIndex,Sum(longestSequence),TotalSum;
		for (int i = 0; i < nextDna.length - 1; i++) {
			if (nextDna[i].equals("1") && nextDna[i + 1].equals("1")) {
				while (nextDna[i].equals("1")) {
					tempCounter++;
					i++;
				}
			}
			if (tempCounter > longestSequence) {
				longestSequence = tempCounter;
				leftmostIndex = i - tempCounter;
				bestDNASampleIndex = 0;
			}

		}

		totalSum = findTotalSum(nextDna);

		// Loop next DNA Samples
		for (int i = 1; i < arrStrings.length; i++) {
			String[] nextDnaSample = arrStrings[i].split("!");

			tempCounter = 0;
			tempSum = 0;
			for (int j = 0; j < nextDnaSample.length - 1; j++) {
				if (nextDnaSample[j].equals("1") && nextDnaSample[j + 1].equals("1")) {
					while (nextDnaSample[j].equals("1")) {
						tempCounter++;
						j++;
					}
				}
				if (tempCounter > longestSequence) {
					longestSequence = tempCounter;
					leftmostIndex = j - tempCounter;
					bestDNASampleIndex = i;
				} else if (tempCounter == longestSequence) {
					if (leftmostIndex > j - tempCounter) {
						leftmostIndex = j - tempCounter;
						bestDNASampleIndex = i;
					} else if (leftmostIndex == j - tempCounter) {
						isSameLeftIndex = true;

						tempSum = findTotalSum(nextDnaSample);
						if (tempSum > totalSum) {
							totalSum = tempSum;
							bestDNASampleIndex = i;
						}
					}
				}

			} // INNER LOOP

		} // LOOP

		String[] bestDna = arrStrings[bestDNASampleIndex].split("!");
		if (isSameLeftIndex) {
			System.out.printf("Best DNA sample %d with sum: %d.%n", bestDNASampleIndex + 1, totalSum);
		} else {
			System.out.printf("Best DNA sample %d with sum: %d.%n", bestDNASampleIndex + 1, longestSequence);
		}

		for (int i = 0; i < bestDna.length; i++) {
			System.out.print(bestDna[i] + " ");
		}

	}
}
