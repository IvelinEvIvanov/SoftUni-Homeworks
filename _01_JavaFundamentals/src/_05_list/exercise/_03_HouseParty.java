package _05_list.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _03_HouseParty {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int lines = Integer.parseInt(scanner.nextLine());

		List<String> inputList = new ArrayList<>();
		List<String> guests = new ArrayList<>();

		for (int i = 0; i < lines; i++) {
			inputList = Arrays	.stream(scanner	.nextLine()
												.split("\\s+"))
								.collect(Collectors.toList());

			String guestName = inputList.get(0);
			boolean isNotGoing = inputList.contains("not");
			boolean isInTheGuestList = guests.contains(guestName);

			if (isNotGoing && !isInTheGuestList) {
				System.out.println(guestName + " is not in the list!");
			}

			if (isNotGoing && isInTheGuestList) {
				guests.remove(guestName);
			}

			if (!isNotGoing && !isInTheGuestList) {
				guests.add(guestName);
			}

			if (!isNotGoing && isInTheGuestList) {
				System.out.println(guestName + " is already in the list!");
			}

		}
		scanner.close();

		for (String guestName : guests) {
			System.out.println(guestName);
		}
	}
}
