package encapsulation._2_AnimalFarm;

public class Chicken {

    private String name;
    private int age;

    public Chicken(String name, int age) {
	this.setName(name);
	this.setAge(age);
    }

    private void setName(String name) {
	if (name == null || name.isEmpty() || name.equals(" ")) {
	    throw new IllegalArgumentException("Name cannot be empty.");
	} else {
	    this.name = name;
	}
    }

    private void setAge(int age) {
	if (age < 0 || age > 15) {
	    throw new IllegalArgumentException("Age should be between 0 and 15.");
	} else {
	    this.age = age;
	}
    }

    private double calculateProductPerDay() {
	if (this.age >= 0 && this.age <= 5) {
	    return 2.0;
	} else if (this.age >= 6 && this.age <= 11) {
	    return 1.0;
	}

	return 0.75;
    }

    public double productPerDay() {
	return this.calculateProductPerDay();
    }

    @Override
    public String toString() {
	return String.format("Chicken %s (age %d) can produce %.2f eggs per day.", this.name, this.age,
		this.productPerDay());
    }

}
