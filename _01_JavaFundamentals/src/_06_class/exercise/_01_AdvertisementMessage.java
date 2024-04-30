package _06_class.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class _01_AdvertisementMessage {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.close();

		String[] phrases = { "Excellent product.", "Such a great product.", "I always use that product.",
				"Best product of its category.", "Exceptional product.", "I can’t live without this product." };

		String[] events = { "Now I feel good.", "I have succeeded with this product.",
				"Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome.",
				"Try it yourself, I am very satisfied.", "I feel great!" };

		String[] author = { "Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva" };

		String[] cities = { "Burgas", "Sofia", "Plovdiv", "Varna", "Ruse" };

		List<String[]> messageList = new ArrayList<>();

		messageList.add(phrases);
		messageList.add(events);
		messageList.add(author);
		messageList.add(cities);

		Random random = new Random();
		String result = "";

		for (int i = 0; i < messageList.size(); i++) {
			String[] messages = messageList.get(i);

			for (int j = 0; j < n; j++) {
				int randomNumber = random.nextInt(n + 1);
				result += messages[randomNumber];
			}
		}

		System.out.println(result);
	}

}
