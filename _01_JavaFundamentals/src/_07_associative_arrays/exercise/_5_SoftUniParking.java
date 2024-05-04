package _07_associative_arrays.exercise;

import java.util.*;

public class _5_SoftUniParking {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());

		Map<String, String> users = new LinkedHashMap<String, String>();
		String kUserName = "";
		String vLicensePlateNumber = "";

		for (int i = 0; i < n; i++) {
			String[] tokens = scanner	.nextLine()
										.split("\\s+");

			if (tokens.length == 3) {
				kUserName = tokens[1];
				vLicensePlateNumber = tokens[2];

				if (!users.containsKey(kUserName)) {
					users.put(kUserName, vLicensePlateNumber);
					System.out.printf("%s registered %s successfully%n", kUserName, vLicensePlateNumber);
				} else {
					System.out.println("ERROR: already registered with plate number " + vLicensePlateNumber);
				}
			} else if (tokens.length == 2) {
				kUserName = tokens[1];
				if (users.containsKey(kUserName)) {
					users.remove(kUserName);
					System.out.printf("%s unregistered successfully%n", kUserName);
				} else {
					System.out.printf("ERROR: user %s not found%n", kUserName);
				}
			}
		}
		
		scanner.close();

		users.forEach((k, v) -> System.out.println(k + " => " + v));
	}
}
