package polymorphism._3_WildFarm;

import java.text.DecimalFormat;

public abstract class Animal {

    private String animalType;
    private String animalName;
    private double animalWeight;
    private int foodEaten;

    public Animal(String animalType, String animalName, double animalWeight) {
	this.animalType = animalType;
	this.animalName = animalName;
	this.animalWeight = animalWeight;
	this.setFoodEaten(0);
    }

    protected DecimalFormat df = new DecimalFormat("#.##");

    protected abstract void makeSound();

    protected void eat(Food food) {
	this.setFoodEaten(food.getFood());
    };

    public String getAnimalName() {
	return animalName;
    }

    public String getAnimalType() {
	return animalType;
    }

    public double getAnimalWeight() {
	return animalWeight;
    }

    public int getFoodEaten() {
	return foodEaten;
    }

    protected void setFoodEaten(int foodEaten) {
	this.foodEaten = foodEaten;
    }

}
