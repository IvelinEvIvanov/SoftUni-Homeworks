package advanced.StacksAndQueues;

import java.util.*;

public class _1_ReverseNumbersWithAStack {

    public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	String[] numbers = scan.nextLine().split(" ");

	ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
	int number = 0;

	for (int i = 0; i < numbers.length; i++) {
	    number = Integer.parseInt(numbers[i]);
	    stack.push(number);
	}

	int size = stack.size();
	for (int i = 0; i < size; i++) {
	    System.out.print(stack.pop() + " ");
	}

    }

}