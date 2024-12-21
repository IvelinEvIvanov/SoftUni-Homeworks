package advanced.StacksAndQueues;

import java.util.*;

public class _3_MaximumElement {

    public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);

	int commandsNum = Integer.parseInt(scan.nextLine());
	String command = "";

	long number = 0L;

	ArrayDeque<Long> stack = new ArrayDeque<>();

	for (int i = 0; i < commandsNum; i++) {
	    command = scan.nextLine();

	    if (command.charAt(0) == '1') {
		number = Integer.parseInt(command.split(" ")[1]);
		stack.push(number);
	    } else if (command.equals("2")) {
		stack.pop();
	    } else if (command.equals("3")) {
		if (stack.size() >= 2) {
		    // number = stack.stream().max((num1, num2) -> Long.compare(num1, num2)).get();

		    long max = stack.peek();
		    Iterator<Long> it = stack.iterator();

		    while (it.hasNext()) {
			long current = it.next();

			if (max < current) {
			    max = current;
			}
		    }

		    System.out.println(max);
		} else if (!stack.isEmpty()) {
		    System.out.println(stack.peek());
		}
	    }
	}

    }

}
