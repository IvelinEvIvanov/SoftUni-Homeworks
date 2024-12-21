package polymorphism._3_WildFarm;

public class Zebra extends Mammal {

    public Zebra(String animalType, String animalName, double animalWeight, String livinRegion) {
	super(animalType, animalName, animalWeight, livinRegion);

    }

    @Override
    public void makeSound() {
	System.out.println("Zs");
    }

    @Override
    public void eat(Food food) {
	if (food instanceof Meat) {
	    food.setFood(0);
	    System.out.println("Zebras are not eating that type of food!");
	} else {
	    this.setFoodEaten(super.getFoodEaten() + food.getFood());
	}
    }

    @Override
    public String toString() {
	String name = this.getAnimalName();
	String weight = this.df.format(this.getAnimalWeight());
	String reagion = this.getLivinRegion();
	int food = this.getFoodEaten();

	return String.format("Zebra[%s, %s, %s, %d]", name, weight, reagion, food);
    }

}
