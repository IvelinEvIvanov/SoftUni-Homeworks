package advanced.StreamsFilesDirectories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class _5_LineNumbers {

    public static void main(String[] args) {

	try (BufferedReader reader = Files.newBufferedReader(Paths.get("Exercises Resources//inputLineNumbers.txt"));
		PrintWriter out = new PrintWriter("Exercises Resources//output.txt")) {

	    int count = 1;
	    String line = "" + count++ + ". " + reader.readLine();
	    out.println(line);

	    while ((line = reader.readLine()) != null) {
		line = "" + count++ + ". " + line;
		out.println(line);
	    }

	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

}
