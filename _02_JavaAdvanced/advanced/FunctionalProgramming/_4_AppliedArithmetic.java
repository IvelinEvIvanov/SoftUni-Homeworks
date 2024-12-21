package advanced.FunctionalProgramming;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class _4_AppliedArithmetic {

    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);

	List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(number -> Integer.parseInt(number))
		.collect(Collectors.toCollection(ArrayList::new));

	Function<List<Integer>, List<Integer>> add = list -> {
	    List<Integer> newList = new ArrayList<>();

	    for (int i = 0; i < list.size(); i++) {
		newList.add(list.get(i) + 1);

	    }

	    return newList;
	};

	Function<List<Integer>, List<Integer>> multiply = list -> {
	    List<Integer> newList = new ArrayList<>();

	    for (int i = 0; i < list.size(); i++) {
		newList.add(list.get(i) * 2);

	    }

	    return newList;
	};

	Function<List<Integer>, List<Integer>> substract = list -> {
	    List<Integer> newList = new ArrayList<>();

	    for (int i = 0; i < list.size(); i++) {
		newList.add(list.get(i) - 1);

	    }

	    return newList;
	};

	while (true) {
	    String command = scanner.nextLine();

	    if (command.equals("end")) {
		break;
	    }

	    switch (command) {
	    case "add":
		numbers = add.apply(numbers);
		break;

	    case "multiply":
		numbers = multiply.apply(numbers);
		break;

	    case "subtract":
		numbers = substract.apply(numbers);
		break;

	    case "print":
		for (int i = 0; i < numbers.size(); i++) {
		    System.out.print(numbers.get(i) + " ");
		}
		break;

	    }
	}
    }

}
