package advanced.StacksAndQueues;

import java.util.*;

public class _8_SimpleTextEditor {

    public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);

	short numberOfCommands = Short.parseShort(scan.nextLine());
	if (numberOfCommands >= 1 && numberOfCommands <= 105) {

	    ArrayDeque<String> stackPerformedCommands1Or2 = new ArrayDeque<String>();
	    StringBuilder text = new StringBuilder();

	    for (int i = 0; i < numberOfCommands; i++) {

		String input = scan.nextLine();
		String[] tokens = input.split(" ");
		String command = tokens[0];
		int parameter = 0;
		String textToAdd = "";

		switch (command) {
		case "1":
		    textToAdd = tokens[1];
		    text.append(textToAdd);

		    stackPerformedCommands1Or2.push(textToAdd);
		    break;

		case "2":
		    parameter = Integer.parseInt(tokens[1]);
		    if (text.length() != 0) {
			text.delete(text.length() - parameter, text.length());
		    }

		    stackPerformedCommands1Or2.push(text.toString());
		    break;

		case "3":
		    parameter = Integer.parseInt(tokens[1]);
		    if (text.length() != 0) {
			System.out.println(text.charAt(parameter - 1));
		    }
		    break;

		case "4":
		    if (!stackPerformedCommands1Or2.isEmpty()) {
			stackPerformedCommands1Or2.pop();

			if (!stackPerformedCommands1Or2.isEmpty()) {
			    text = new StringBuilder(stackPerformedCommands1Or2.peek());
			}
		    }
		    break;

		}

	    }
	}

    }

}
