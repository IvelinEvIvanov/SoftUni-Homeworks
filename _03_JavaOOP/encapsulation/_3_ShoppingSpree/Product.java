package encapsulation._3_ShoppingSpree;

public class Product {

    private String name;
    private double cost;

    public Product(String name, double cost) {
	this.setName(name);
	this.setCost(cost);
    }

    public String getName() {
	return name;
    }

    private void setName(String name) {
	if (name.trim().isEmpty() || name == null) {
	    throw new IllegalArgumentException("Name cannot be empty");
	}
	this.name = name;

    }

    public double getCost() {
	return cost;
    }

    private void setCost(double cost) {
	if (cost < 0) {
	    throw new IllegalArgumentException("Money cannot be negative");
	}

	this.cost = cost;

    }

}
