package advanced.StreamsFilesDirectories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _7_MergeTwoFiles {

    public static void main(String[] args) {
	try (BufferedReader readerOne = Files.newBufferedReader(Paths.get("Exercises Resources//inputOne.txt"));
		BufferedReader readerTwo = Files.newBufferedReader(Paths.get("Exercises Resources//inputTwo.txt"));
		PrintWriter out = new PrintWriter("Exercises Resources//merges.txt")) {

	    String line = "";
	    while ((line = readerOne.readLine()) != null) {
		out.println(line);
	    }

	    while ((line = readerTwo.readLine()) != null) {
		out.println(line);
	    }

	} catch (IOException e) {
	    e.printStackTrace();
	}

    }

}
