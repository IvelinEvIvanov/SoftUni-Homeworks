package _06_class.exercise._04_Articles_v2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());

		String title = "";
		String content = "";
		String author = "";

		List<Article> articles = new ArrayList<>();
		Article article = null;

		for (int i = 0; i < n; i++) {
			String[] tokens = scanner	.nextLine()
										.split(", ");

			title = tokens[0];
			content = tokens[1];
			author = tokens[2];

			article = new Article(title, content, author);
			articles.add(article);

		}

		String compareWord = scanner.nextLine();

		switch (compareWord) {
		case "title":
			Collections.sort(articles, (t1, t2) -> t1	.getTitle()
														.compareTo(t2.getTitle()));
			break;

		case "content":
			Collections.sort(articles, (t1, t2) -> t1	.getContent()
														.compareTo(t2.getContent()));
			break;

		case "author":
			Collections.sort(articles, (t1, t2) -> t1	.getAuthor()
														.compareTo(t2.getAuthor()));
			break;
		}

		scanner.close();

		articles.forEach(a -> System.out.println(a.toString()));
	}
}
