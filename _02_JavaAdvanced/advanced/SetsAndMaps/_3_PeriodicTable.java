package advanced.SetsAndMaps;

import java.util.*;

public class _3_PeriodicTable {

    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);

	int n = scanner.nextInt();
	Set<String> set = new TreeSet<>();

	for (int i = 0; i < n; i++) {
	    String[] line = scanner.nextLine().split(" ");
	    for (String element : line) {
		set.add(element);
	    }
	}

	Iterator<String> it = set.iterator();
	while (it.hasNext()) {
	    System.out.print(it.next() + " ");
	}
    }

}
