package polymorphism._3_WildFarm;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Scanner reader = new Scanner(System.in);

	String[] animals = null;
	String[] food = null;

	String input = "";

	List<Animal> animalList = new ArrayList<>();

	while (true) {
	    input = reader.nextLine();
	    if (input.equals("End")) {
		break;
	    }

	    animals = input.split(" ");

	    input = reader.nextLine();
	    food = input.split(" ");

	    String animal = animals[0];

	    switch (animal) {
	    case "Cat":
		Cat cat = new Cat(animals[0], animals[1], Double.parseDouble(animals[2]), animals[3], animals[4]);

		cat.makeSound();
		setFood(cat, food);

		animalList.add(cat);

		break;
	    case "Tiger":
		Tiger tiger = new Tiger(animals[0], animals[1], Double.parseDouble(animals[2]), animals[3]);

		tiger.makeSound();
		setFood(tiger, food);

		animalList.add(tiger);
		break;
	    case "Zebra":
		Zebra zebra = new Zebra(animals[0], animals[1], Double.parseDouble(animals[2]), animals[3]);

		zebra.makeSound();
		setFood(zebra, food);

		animalList.add(zebra);
		break;
	    case "Mouse":
		Mouse mouse = new Mouse(animals[0], animals[1], Double.parseDouble(animals[2]), animals[3]);

		mouse.makeSound();
		setFood(mouse, food);

		animalList.add(mouse);
		break;

	    }
	} // while

	for (Animal animal : animalList) {
	    System.out.println(animal);
	}
    }

    private static Food setFood(Animal animal, String[] food) {
	Food tempFood = null;
	if (food[0].equals("Vegetable")) {
	    tempFood = new Vegetable(Integer.parseInt(food[1]));
	    animal.eat(tempFood);
	    return tempFood;
	}

	tempFood = new Meat(Integer.parseInt(food[1]));
	animal.eat(tempFood);

	return tempFood;
    }

}
