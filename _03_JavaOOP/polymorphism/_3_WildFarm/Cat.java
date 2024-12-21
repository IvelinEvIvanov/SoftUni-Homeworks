package polymorphism._3_WildFarm;

import javax.swing.plaf.synth.Region;

public class Cat extends Felime {
    private String bread;

    public Cat(String animalType, String animalName, double animalWeight, String livinRegion, String bread) {
	super(animalType, animalName, animalWeight, livinRegion);
	this.bread = bread;
    }

    @Override
    public void makeSound() {
	System.out.println("Meowwww");
    }

    @Override
    public void eat(Food food) {
	this.setFoodEaten(super.getFoodEaten() + food.getFood());

    }

    @Override
    public String toString() {

	String name = this.getAnimalName();
	String thebread = this.bread;
	String weight = this.df.format(this.getAnimalWeight());
	String reagion = this.getLivinRegion();
	int food = this.getFoodEaten();

	return String.format("Cat[%s, %s, %s, %s, %d]", name, thebread, weight, reagion, food);
    }

}
