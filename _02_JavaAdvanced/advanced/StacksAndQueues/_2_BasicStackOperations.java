package advanced.StacksAndQueues;

import java.util.*;

public class _2_BasicStackOperations {

    public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	String[] input = scan.nextLine().split("\\s+");

	int n = Integer.parseInt(input[0]);
	int s = Integer.parseInt(input[1]);
	int x = Integer.parseInt(input[2]);

	String[] numbers = scan.nextLine().split("\\s+");

	ArrayDeque<Integer> stack = new ArrayDeque<Integer>();

	for (int i = 0; i < n; i++) {
	    stack.push(Integer.parseInt(numbers[i]));
	}

	for (int i = 0; i < s; i++) {
	    stack.pop();
	}

	if (stack.isEmpty()) {
	    System.out.println(0);
	} else if (stack.contains(x)) {
	    System.out.println("true");
	} else {
	    Integer[] arr = stack.toArray(new Integer[stack.size()]);
	    Arrays.sort(arr);

	    System.out.println(arr[0]);
	}

    }

}
