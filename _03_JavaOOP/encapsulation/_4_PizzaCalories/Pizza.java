package encapsulation._4_PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {

    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name, int numberOfToppings) {
	this.setName(name);
	this.setToppings(numberOfToppings);
	this.dough = null;
	this.toppings = new ArrayList<>();
    }

    private void setName(String name) {
	Validator.validatePizzaName(name);
	this.name = name;
    }

    public String getName() {
	return this.name;
    }

    public void setDought(Dough dought) {
	this.dough = dought;
    }

    private void setToppings(int numberOfToppings) {
	Validator.validateNumberOfToppings(numberOfToppings);
	this.toppings = toppings;
    }

    public void addTopping(Topping topping) {
	this.toppings.add(topping);
    }

    public double getOverallCalories() {
	double totalCalories = this.dough.calculateCalories();
	for (int i = 0; i < this.toppings.size(); i++) {
	    totalCalories += this.toppings.get(i).calculateCalories();
	}

	return totalCalories;
    }

}
