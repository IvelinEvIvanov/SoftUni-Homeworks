package polymorphism._3_WildFarm;

public class Felime extends Mammal {

    public Felime(String animalType, String animalName, double animalWeight, String livinRegion) {
	super(animalType, animalName, animalWeight, livinRegion);

    }

    @Override
    protected void makeSound() {
    }

    @Override
    protected void eat(Food food) {
    }

}
