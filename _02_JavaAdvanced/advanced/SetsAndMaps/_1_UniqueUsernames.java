package advanced.SetsAndMaps;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class _1_UniqueUsernames {

    public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);

	int n = Integer.parseInt(scan.nextLine());
	Set<String> set = new LinkedHashSet<>();

	for (int i = 0; i < n; i++) {
	    set.add(scan.nextLine());
	}

	Iterator<String> it = set.iterator();
	while (it.hasNext()) {
	    System.out.println(it.next());
	}

    }

}
