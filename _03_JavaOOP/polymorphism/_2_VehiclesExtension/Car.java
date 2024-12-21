package polymorphism._2_VehiclesExtension;

public class Car extends Vehicle {

    private double CONSUMPTION_INCREASED = 0.9;

    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
	super(fuelQuantity, fuelConsumption + 0.9, tankCapacity);

    }

    @Override
    public double calculateFuel(double distance) {
	if (this.fuelQuantity - (this.fuelConsumption * distance) < 0) {
	    return -1;
	}

	this.fuelQuantity -= (this.fuelConsumption * distance);

	return this.fuelQuantity;
    }

    @Override
    public String toString() {
	return String.format("Car: %.2f", this.fuelQuantity);
    }

}
