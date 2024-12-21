package advanced.StreamsFilesDirectories;

import java.io.*;

public class _1_SumLines {

    public static void main(String[] args) {

	File file = new File("Exercises Resources//input.txt");

	try (BufferedReader br = new BufferedReader(new FileReader(file))) {

	    String line = "";
	    while ((line = br.readLine()) != null) {

		int sum = 0;
		for (int i = 0; i < line.length(); i++) {
		    sum += line.charAt(i);
		}

		System.out.println(sum);
	    }

	} catch (IOException e) {
	    e.printStackTrace();
	}

    }

}
