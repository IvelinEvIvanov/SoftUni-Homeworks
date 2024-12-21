package polymorphism._3_WildFarm;

public class Tiger extends Felime {

    public Tiger(String animalType, String animalName, double animalWeight, String livinRegion) {
	super(animalType, animalName, animalWeight, livinRegion);

    }

    @Override
    public void makeSound() {
	System.out.println("ROAAR!!!");
    }

    @Override
    public void eat(Food food) {
	if (food instanceof Vegetable) {
	    food.setFood(0);
	    System.out.println("Tigers are not eating that type of food!");
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

	return String.format("Tiger[%s, %s, %s, %d]", name, weight, reagion, food);
    }

}
