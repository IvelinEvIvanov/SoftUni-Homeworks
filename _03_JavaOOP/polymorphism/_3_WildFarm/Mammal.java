package polymorphism._3_WildFarm;

public abstract class Mammal extends Animal {
    private String livinRegion;

    public Mammal(String animalType, String animalName, double animalWeight, String livinRegion) {
	super(animalType, animalName, animalWeight);
	this.livinRegion = livinRegion;

    }

    public String getLivinRegion() {
	return livinRegion;
    }

}
