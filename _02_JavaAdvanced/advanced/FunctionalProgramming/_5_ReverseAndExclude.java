package advanced.FunctionalProgramming;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class _5_ReverseAndExclude {

    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);

	ArrayDeque<Integer> stack = new ArrayDeque<Integer>();

	String[] numbers = scanner.nextLine().split(" ");

	for (int i = 0; i < numbers.length; i++) {
	    stack.push(Integer.parseInt(numbers[i]));
	}

	int n = Integer.parseInt(scanner.nextLine());

	Predicate<Integer> isDivisible = item -> item % n == 0;

	List<Integer> result = new ArrayList<>();

	Function<ArrayDeque<Integer>, List<Integer>> reverseList = thestack -> {

	    while (!thestack.isEmpty()) {
		if (isDivisible.test(thestack.peek())) {
		    thestack.pop();
		} else {
		    result.add(thestack.pop());
		}
	    }

	    return result;
	};

	reverseList.apply(stack);

	if (!result.isEmpty()) {
	    for (Integer num : result) {
		System.out.printf(num + " ");
	    }
	}

    }

}
