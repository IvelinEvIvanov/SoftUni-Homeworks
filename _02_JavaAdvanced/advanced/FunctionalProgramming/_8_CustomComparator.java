package advanced.FunctionalProgramming;

import java.util.*;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _8_CustomComparator {

    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);

	List<Integer> list = Arrays.stream(scanner.nextLine().split(" ")).map(n -> Integer.parseInt(n))
		.collect(Collectors.toCollection(ArrayList::new));

	Comparator<Integer> sortEven = (n1, n2) -> {
	    return Integer.compare(n1, n2);
	};

	Predicate<Integer> isEven = n -> n % 2 == 0;
	List<Integer> resultEven = new ArrayList<>();

	list.stream().filter(isEven).sorted(sortEven).forEach(item -> {
	    resultEven.add(item);
	    list.remove(item);

	});

	Collections.sort(list);

	for (Integer item : resultEven) {
	    System.out.printf(item + " ");
	}

	for (Integer item : list) {
	    System.out.printf(item + " ");
	}

    }

}
