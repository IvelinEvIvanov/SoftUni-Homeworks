package _01_statements_and_loops.more_exercises;

import java.util.Scanner;

public class _5_Messages {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		char[][] codeTable = new char[][] { new char[] { ' ' }, new char[' '], new char[] { 'a', 'b', 'c' },
				new char[] { 'd', 'e', 'f' }, new char[] { 'g', 'h', 'i' }, new char[] { 'j', 'k', 'l' },
				new char[] { 'm', 'n', 'o' }, new char[] { 'p', 'q', 'r', 's' }, new char[] { 't', 'u', 'v' },
				new char[] { 'w', 'x', 'y', 'z' } };

		String message = "";
		int n = Integer.parseInt(scan.nextLine());
		
		for (int i = 0; i < n; i++) {
			String sms = scan.nextLine();
			
			if (sms.length() == 1) {
				int code = Integer.parseInt(sms);
				if (code == 0) {
					message += " ";
				} else {
					message += codeTable[code][0];
				}
			} else if (sms.length() == 2) {
				int code = Integer.parseInt(sms);
				int index = code % 10;
				message += codeTable[index][1];
			} else if (sms.length() == 3) {
				int code = Integer.parseInt(sms);
				int index = code % 10;
				message += codeTable[index][2];
			} else if (sms.length() == 4) {
				int code = Integer.parseInt(sms);
				int index = code % 10;
				message += codeTable[index][3];
			}
		}
		
		scan.close();
		System.out.println(message);
	}
}
