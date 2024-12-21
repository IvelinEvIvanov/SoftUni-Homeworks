package advanced.StreamsFilesDirectories;

import java.io.*;

public class _8_GetFolderSize {

    public static void main(String[] args) {
	File file = new File("Exercises Resources");

	File[] files = file.listFiles();

	int sum = 0;
	for (File thefile : files) {
	    sum += thefile.length();
	}

	System.out.println(sum);
    }

}
