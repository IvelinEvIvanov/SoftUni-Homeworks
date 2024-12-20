package encapsulation._4_PizzaCalories;

public enum ToppingsModifiers {

    Meat(1.2), Veggies(0.8), Cheese(1.1), Sauce(0.9);

    private double value;

    private ToppingsModifiers(double value) {
	this.value = value;
    }

    public double getValue() {
	return this.value;
    }
}
