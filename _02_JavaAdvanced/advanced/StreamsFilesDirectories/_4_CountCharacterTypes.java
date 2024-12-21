package advanced.StreamsFilesDirectories;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class _4_CountCharacterTypes {

    public static void main(String[] args) {

	try (BufferedReader reader = Files.newBufferedReader(Paths.get("Exercises Resources//input.txt"))) {

	    String line = "";
	    int vowels = 0;
	    int consonants = 0;
	    int punctuation = 0;

	    while ((line = reader.readLine()) != null) {

		for (int i = 0; i < line.length(); i++) {
		    if ((line.charAt(i) == 'a') || (line.charAt(i) == 'e') || (line.charAt(i) == 'i')
			    || (line.charAt(i) == 'o') || (line.charAt(i) == 'u')) {

			vowels++;
		    }

		    if ((line.charAt(i) == '?') || (line.charAt(i) == '!') || (line.charAt(i) == '.')
			    || (line.charAt(i) == ',')) {

			punctuation++;
		    }

		    if (Character.isLetterOrDigit(line.charAt(i)) || (line.charAt(i) == '-')
			    || (line.charAt(i) == '\'')) {
			consonants++;
		    }
		}

	    }

	    System.out.println("Vowels: " + vowels);
	    System.out.println("Consonants: " + (consonants - vowels));
	    System.out.println("Punctuation: " + punctuation);

	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

}
