package polymorphism._2_VehiclesExtension;

public class Truck extends Vehicle {

    private double CONSUMPTION_INCREASED = 1.6;

    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
	super(fuelQuantity, fuelConsumption + 1.6, tankCapacity);

    }

    @Override
    public void setRefueledLiters(double refueledLiters) {
	if (this.isRefueledLitersNegative(refueledLiters)) {
	    System.out.println("Fuel must be a positive number");
	} else if (this.isMoreThanCapacity(refueledLiters)) {
	    System.out.println("Cannot fit fuel in tank");
	} else {
	    this.fuelQuantity += (refueledLiters * 0.95);
	}

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
	return String.format("Truck: %.2f", this.fuelQuantity);
    }

}
