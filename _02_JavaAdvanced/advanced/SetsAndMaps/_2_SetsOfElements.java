package advanced.SetsAndMaps;

import java.util.*;

public class _2_SetsOfElements {

    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	int n = scanner.nextInt();
	int m = scanner.nextInt();

	Set<Integer> nset = new LinkedHashSet<>();
	Set<Integer> mset = new LinkedHashSet<>();

	for (int i = 1; i <= (n + m); i++) {
	    if (i > n) {
		mset.add(scanner.nextInt());
	    } else {
		nset.add(scanner.nextInt());
	    }

	}

	nset.retainAll(mset);

	if (!nset.isEmpty()) {
	    Iterator<Integer> it = nset.iterator();
	    while (it.hasNext()) {
		System.out.print(it.next() + " ");
	    }
	}

    }

}
