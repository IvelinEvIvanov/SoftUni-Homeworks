package advanced.StreamsFilesDirectories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _6_WordCount {

    public static void main(String[] args) {
	try (BufferedReader readerWords = Files.newBufferedReader(Paths.get("Exercises Resources//words.txt"));
		BufferedReader readerText = Files.newBufferedReader(Paths.get("Exercises Resources//text.txt"));
		PrintWriter out = new PrintWriter("Exercises Resources//results.txt")) {

	    Map<String, Integer> mapResult = new LinkedHashMap<>();
	    String wordsLine = readerWords.readLine();
	    String[] words = wordsLine.split(" ");

	    for (int i = 0; i < words.length; i++) {
		mapResult.put(words[i], 0);
	    }

	    Scanner scanner = new Scanner(readerText);

	    for (int i = 0; i < words.length; i++) {
		while (scanner.hasNext()) {
		    String word = scanner.next();

		    if (mapResult.containsKey(word)) {
			mapResult.put(word, mapResult.get(word) + 1);
		    }
		}
	    }

	    mapResult.forEach((k, v) -> {
		out.println(k + " - " + v);
	    });
	} catch (IOException e) {
	    e.printStackTrace();
	}

    }

}
