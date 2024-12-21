package advanced.StreamsFilesDirectories;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class _2_SumBytes {

    public static void main(String[] args) {

	try (BufferedReader reader = Files.newBufferedReader(Paths.get("Exercises Resources//input.txt"))) {

	    String line = "";
	    long sum = 0;

	    while ((line = reader.readLine()) != null) {

		for (int i = 0; i < line.length(); i++) {
		    sum += line.charAt(i);
		}

	    }

	    System.out.println(sum);

	} catch (IOException e) {
	    e.printStackTrace();
	}

    }

}
