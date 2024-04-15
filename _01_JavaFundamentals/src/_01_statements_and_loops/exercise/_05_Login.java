package _01_statements_and_loops.exercise;

import java.util.Scanner;

public class _05_Login {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String userName = scan.nextLine();
		String pass = "";

		for (int i = userName.length() - 1; i >= 0; i--) {
			pass += userName.charAt(i);
		}

		for (int i = 1; i <= 4; i++) {
			String tryPass = scan.nextLine();

			if (tryPass.equals(pass)) {
				System.out.println("User " + userName + " logged in.");
				break;
			} else if (i == 4) {
				System.out.println("User " + userName + " blocked!");
			} else if (!tryPass.equals(pass)) {
				System.out.println("Incorrect password. Try again.");
			}
		}

		scan.close();
	}
}
