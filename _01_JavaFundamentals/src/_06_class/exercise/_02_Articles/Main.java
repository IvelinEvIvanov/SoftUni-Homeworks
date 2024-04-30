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
		String title = inputTokens.get(0);
		String content = inputTokens.get(1);
		String author = inputTokens.get(2);

		Article article = new Article(title, content, author);

		for (int i = 0; i < n; i++) {
			String[] tokens = scanner	.nextLine()
										.split(":");

			switch (tokens[0]) {
			case "Edit":
				content = tokens[1];
				article.edit(content);
				break;

			case "ChangeAuthor":
				author = tokens[1];
				article.changeAuthor(author);
				break;

			case "Rename":
				title = tokens[1];
				article.rename(title);
				break;
			}
		}

		scanner.close();

		System.out.println(article.toString());
	}
}
