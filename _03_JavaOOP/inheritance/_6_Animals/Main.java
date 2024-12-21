package inheritance._6_Animals;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Scanner reader = new Scanner(System.in);

	String input = reader.nextLine();
	while (!input.equals("Beast!")) {

	    String[] tokens = reader.nextLine().split(" ");

	    if (input.equals("Cat")) {
		try {

		    Cat cat = new Cat(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);

		    System.out.println(cat);
		} catch (IllegalArgumentException e) {
		    System.out.println(e.getMessage());
		}
	    } else if (input.equals("Kittens")) {
		try {

		    Kitten cat = new Kitten(tokens[0], Integer.parseInt(tokens[1]));

		    System.out.println(cat);
		} catch (IllegalArgumentException e) {
		    System.out.println(e.getMessage());
		}
	    } else if (input.equals("Tomcat")) {
		try {

		    Tomcat cat = new Tomcat(tokens[0], Integer.parseInt(tokens[1]));

		    System.out.println(cat);
		} catch (IllegalArgumentException e) {
		    System.out.println(e.getMessage());
		}
	    } else if (input.equals("Dog")) {
		try {

		    Dog dog = new Dog(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);

		    System.out.println(dog);
		} catch (IllegalArgumentException e) {
		    System.out.println(e.getMessage());
		}
	    } else if (input.equals("Frog")) {
		try {

		    Frog frog = new Frog(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);

		    System.out.println(frog);
		} catch (IllegalArgumentException e) {
		    System.out.println(e.getMessage());
		}
	    }

	    input = reader.nextLine();
	}
    }

}
