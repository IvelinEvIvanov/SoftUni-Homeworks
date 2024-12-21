package encapsulation._3_ShoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
	this.setName(name);
	this.setMoney(money);

	this.products = new ArrayList<Product>();
    }

    private void setName(String name) {
	if (name.trim().isEmpty() || name == null) {
	    throw new IllegalArgumentException("Name cannot be empty");
	}

	this.name = name;

    }

    private void setMoney(double money) {
	if (money < 0) {
	    throw new IllegalArgumentException("Money cannot be negative");
	}

	this.money = money;

    }

    public void buyProduct(Product product) {
	if (this.money - product.getCost() < 0) {
	    throw new IllegalArgumentException(String.format("%s can't afford %s", this.name, product.getName()));
	}

	this.money = this.money - product.getCost();
	this.products.add(product);
    }

    public String getName() {
	return this.name;
    }

    @Override
    public String toString() {

	StringBuilder sb = new StringBuilder(this.getName() + " - ");

	if (this.products.size() > 0) {
	    for (int i = 0; i < this.products.size(); i++) {
		sb.append(this.products.get(i).getName() + ", ");
	    }
	} else {
	    sb.append("Nothing bought");
	}

	sb = sb.deleteCharAt(sb.length() - 1);
	sb = sb.deleteCharAt(sb.length() - 1);

	return sb.toString();
    }

}
