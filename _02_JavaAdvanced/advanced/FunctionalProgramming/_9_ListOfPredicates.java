package advanced.FunctionalProgramming;

import java.util.*;
import java.util.function.Predicate;

public class _9_ListOfPredicates {

    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);

	int n = Integer.parseInt(scanner.nextLine());

	List<Integer> list = new ArrayList<>();

	for (int i = 1; i <= n; i++) {
	    list.add(i);
	}

	int[] divisibleNums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(num -> Integer.parseInt(num))
		.toArray();

	Predicate<Integer> isDivisible = num -> {

	    for (int j = 0; j < divisibleNums.length; j++) {

		if (!(num % divisibleNums[j] == 0)) {
		    return false;
		}

	    }

	    return true;
	};

	list.stream().filter(isDivisible).forEach(item -> System.out.printf(item + " "));
    }

}
