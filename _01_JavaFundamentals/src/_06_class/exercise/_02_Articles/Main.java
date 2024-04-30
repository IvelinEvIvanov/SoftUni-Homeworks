package _06_class.exercise._02_Articles;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<String> inputTokens = Arrays	.stream(scanner	.nextLine()
															.split(",\\s+"))
											.collect(Collectors.toList());

		int n = Integer.parseInt(scanner.nextLine());
		Article article = new Article(inputTokens.get(0), inputTokens.get(1), inputTokens.get(2));

		for (int i = 0; i < n; i++) {
			String[] tokens = scanner	.nextLine()
										.split(":");

			switch (tokens[0]) {
			case "Edit":
				article.edit(tokens[1]);
				break;

			case "ChangeAuthor":
				article.changeAuthor(tokens[1]);
				break;

			case "Rename":
				article.rename(tokens[1]);
				break;
			}
		}

		scanner.close();

		System.out.println(article.toString());
	}
}
