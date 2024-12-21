package advanced.StacksAndQueues;

import java.util.*;

public class _6_BalancedParentheses {

    public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	String[] input = scan.nextLine().split("");

	ArrayDeque<String> dequeu = new ArrayDeque<>();
	for (int i = 0; i < input.length; i++) {
	    dequeu.offer(input[i]);
	}

	boolean isBalanced = true;
	String lastElement = "";

	if (dequeu.size() == 1 || dequeu.isEmpty()) {
	    System.out.println("NO");
	    return;
	}

	if (dequeu.size() >= 2 && (dequeu.size() % 2 == 0)) {

	    while (!dequeu.isEmpty()) {

		String firstElement = dequeu.poll();
		switch (firstElement) {
		case "{":
		    lastElement = dequeu.removeLast();
		    if (!lastElement.equals("}")) {
			System.out.println("NO");
			isBalanced = false;
		    }
		    break;

		case "[":
		    lastElement = dequeu.removeLast();
		    if (!lastElement.equals("]")) {
			System.out.println("NO");
			isBalanced = false;
		    }
		    break;

		case "(":
		    lastElement = dequeu.removeLast();
		    if (!lastElement.equals(")")) {
			System.out.println("NO");
			isBalanced = false;
		    }
		    break;

		}

		if (!isBalanced) {
		    break;
		}
	    }
	} else {
	    isBalanced = false;
	    System.out.println("NO");
	}

	if (isBalanced) {
	    System.out.println("YES");
	}

    }

}
