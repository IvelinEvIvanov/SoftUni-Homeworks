package encapsulation._4_PizzaCalories;

public class Validator {

    public static void validateBakingTechnique(String bakingTechnique) {
	try {
	    DoughModifiers.valueOf(bakingTechnique);
	} catch (IllegalArgumentException e) {
	    throw new IllegalArgumentException("Invalid type of dough.");
	}
    }

    public static void validateWeight(double weight) {
	if (weight < 1 || weight > 200) {
	    throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
	}
    }

    public static void validateFlour(String flour) {
	try {
	    DoughModifiers.valueOf(flour);
	} catch (IllegalArgumentException e) {
	    throw new IllegalArgumentException("Invalid type of dough.");
	}
    }

    public static void validateToppingType(String toppingType) {
	try {
	    ToppingsModifiers.valueOf(toppingType);
	} catch (IllegalArgumentException e) {
	    throw new IllegalArgumentException("Cannot place " + toppingType + " on top of your pizza.");
	}
    }

    public static void validateToppingWeight(double weight, String toppingName) {
	if (weight < 1 || weight > 50) {
	    throw new IllegalArgumentException(toppingName + " weight should be in the range [1..50].");
	}

    }

    public static void validatePizzaName(String name) {
	if (name.trim().isEmpty() || name == null || name.length() > 15) {
	    throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
	}
    }

    public static void validateNumberOfToppings(int numberOfToppings) {
	if (numberOfToppings > 10 || numberOfToppings < 0) {
	    throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
	}
    }
}
