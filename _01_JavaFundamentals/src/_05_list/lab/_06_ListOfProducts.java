package _05_list.lab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class _06_ListOfProducts {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = Integer.parseInt(scanner.nextLine());
		List<String> products = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			String currentProduct = scanner.nextLine();
			products.add(currentProduct);
		}

		scanner.close();

		Collections.sort(products);

		for (int i = 0; i < products.size(); i++) {
			System.out.printf("%d.%s%n", i + 1, products.get(i));
		}
	}
}
