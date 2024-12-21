package advanced.SetsAndMaps;

import java.util.*;

public class _4_CountSymbols {

    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);

	Map<Character, Integer> map = new TreeMap<Character, Integer>();
	String text = scanner.nextLine();
	for (int i = 0; i < text.length(); i++) {
	    char nextChar = text.charAt(i);
	    if (!map.containsKey(nextChar)) {
		map.put(nextChar, 1);
	    } else {
		map.put(nextChar, map.get(nextChar) + 1);
	    }
	}

	for (Map.Entry<Character, Integer> entry : map.entrySet()) {
	    System.out.println(entry.getKey() + ": " + entry.getValue() + " time/s");
	}

    }

}
