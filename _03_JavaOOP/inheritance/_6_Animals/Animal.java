package inheritance._6_Animals;

public class Animal {

    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
	this.setName(name);
	this.setAge(age);
	this.setGender(gender);
    }

    private void setName(String name) {
	if (name == null || name.trim().isEmpty()) {
	    throw new IllegalArgumentException("Invalid input!");
	}
	this.name = name.trim();
    }

    private void setAge(int age) {
	if (age < 0) {
	    throw new IllegalArgumentException("Invalid input!");
	}
	this.age = age;
    }

    private void setGender(String gender) {
	if (gender == null || gender.trim().isEmpty()) {
	    throw new IllegalArgumentException("Invalid input!");
	}
	this.gender = gender.trim();
    }

    public String getName() {
	return name;
    }

    public int getAge() {
	return age;
    }

    public String getGender() {
	return gender;
    }

    public String produceSound() {
	return "";
    }

    @Override
    public String toString() {
	return String.format("%s%n%s %d %s%n%s", this.getClass().getSimpleName(), this.getName(), this.getAge(),
		this.getGender(), this.produceSound());
    }

}
