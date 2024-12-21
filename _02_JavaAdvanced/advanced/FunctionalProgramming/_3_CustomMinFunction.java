package advanced.FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class _3_CustomMinFunction {

    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);

	Integer[] numbers = Arrays.stream(scanner.nextLine().split(" ")).map(e -> Integer.parseInt(e))
		.toArray(Integer[]::new);

	Function<Integer[], Integer> findMin = nums -> {
	    Integer min = Arrays.stream(nums).min((n1, n2) -> Integer.compare(n1, n2)).get();
	    return min;
	};

	System.out.println(findMin.apply(numbers));
    }

}
