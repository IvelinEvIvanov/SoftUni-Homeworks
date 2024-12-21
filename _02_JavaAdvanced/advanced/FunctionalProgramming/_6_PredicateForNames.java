package advanced.FunctionalProgramming;

import java.util.*;
import java.util.function.*;

public class _6_PredicateForNames {

    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);

	int len = Integer.parseInt(scanner.nextLine());
	String[] names = scanner.nextLine().split(" ");

	Predicate<String> isValid = name -> name.length() <= len;

	Arrays.stream(names).filter(isValid).forEach(n -> System.out.println(n));
    }

}
