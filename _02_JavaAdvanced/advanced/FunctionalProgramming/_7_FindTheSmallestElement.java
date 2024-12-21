package advanced.FunctionalProgramming;

import java.util.*;
import java.util.Scanner;
import java.util.function.*;
import java.util.stream.Collectors;

public class _7_FindTheSmallestElement {
    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);

	List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(num -> Integer.parseInt(num))
		.collect(Collectors.toCollection(ArrayList::new));

	Function<List<Integer>, Integer> findMin = num -> {
	    Integer min = Integer.MAX_VALUE;
	    Integer index = 0;

	    for (int i = 0; i < numbers.size(); i++) {
		if (numbers.get(i) <= min) {
		    min = numbers.get(i);
		    index = i;
		}
	    }

	    return index;
	};

	System.out.println(findMin.apply(numbers));
    }
}
