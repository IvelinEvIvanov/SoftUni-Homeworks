package advanced.SetsAndMaps;

import java.util.*;

public class _7_FixEmails {

    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	Map<String, String> mails = new LinkedHashMap<String, String>();

	while (true) {
	    String input = scanner.nextLine();

	    if (input.equals("stop")) {
		break;
	    }

	    String name = input;
	    String email = scanner.nextLine().toLowerCase();

	    StringBuilder sufix = new StringBuilder();
	    for (int i = email.length() - 1; email.charAt(i) != '.'; i--) {
		sufix.append(email.charAt(i));
	    }

	    sufix = sufix.reverse();

	    if (sufix.toString().equals("bg")) {
		mails.put(name, email);
	    }

	}

	for (String key : mails.keySet()) {
	    System.out.printf("%s -> %s%n", key, mails.get(key));
	}

    }

}
