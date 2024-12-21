package advanced.StreamsFilesDirectories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class _3_AllCapitals {

    public static void main(String[] args) {

	try (BufferedReader reader = Files.newBufferedReader(Paths.get("Exercises Resources//input.txt"));
		PrintWriter out = new PrintWriter("Exercises Resources//output.txt")) {

	    String line = "";
	    while ((line = reader.readLine()) != null) {
		out.println(line.toUpperCase());
	    }

	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

}
