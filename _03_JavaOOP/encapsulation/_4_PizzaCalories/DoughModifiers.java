package encapsulation._4_PizzaCalories;

public enum DoughModifiers {

    White(1.5), Wholegrain(1.0), Crispy(0.9), Chewy(1.1), Homemade(1.0);

    private double value;

    private DoughModifiers(double value) {
	this.value = value;
    }

    public double getValue() {
	return this.value;
    }

}
