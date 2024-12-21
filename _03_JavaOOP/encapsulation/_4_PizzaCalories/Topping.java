package encapsulation._4_PizzaCalories;

public class Topping {

    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
	this.setToppingType(toppingType);
	this.setWeight(weight);
    }

    private void setToppingType(String toppingType) {
	Validator.validateToppingType(toppingType);
	this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
	Validator.validateToppingWeight(weight, this.toppingType);
	this.weight = weight;
    }

    public double calculateCalories() {
	ToppingsModifiers tm = ToppingsModifiers.valueOf(this.toppingType);

	return (2 * weight) * tm.getValue();
    }
}
