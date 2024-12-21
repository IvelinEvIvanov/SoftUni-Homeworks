package advanced.FunctionalProgramming;

import java.util.*;
import java.util.function.Consumer;

public class _1_ConsumerPrint {

    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);

	String[] tokens = scanner.nextLine().split(" ");

	Consumer<String[]> printList = item -> {
	    for (int i = 0; i < item.length; i++) {
		System.out.println(item[i]);
	    }
	};

	printList.accept(tokens);
    }

}
