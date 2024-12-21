package advanced.FunctionalProgramming;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class _2_KnightsOfHonor {

    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);

	List<String> list = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

	Consumer<String> appendSir = item -> System.out.println("Sir " + item);

	for (String name : list) {
	    appendSir.accept(name);
	}
    }

}
