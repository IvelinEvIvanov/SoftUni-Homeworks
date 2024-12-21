package interfaces_abstraction._5_Telephony;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Scanner reader = new Scanner(System.in);

	List<String> numbers = new ArrayList<>();
	List<String> urls = new ArrayList<>();

	String[] input = reader.nextLine().split("\\s+");

	for (int i = 0; i < input.length; i++) {
	    numbers.add(input[i].trim());
	}

	input = reader.nextLine().split("\\s+");

	for (int i = 0; i < input.length; i++) {
	    urls.add(input[i].trim());
	}

	Smartphone phone = new Smartphone(numbers, urls);

	System.out.println(phone.call());
	System.out.println(phone.browse());
    }

}
