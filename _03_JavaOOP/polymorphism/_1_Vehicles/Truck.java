package polymorphism._1_Vehicles;

public class Truck extends Vehicle {

    private double CONSUMPTION_INCREASED = 1.6;

    public Truck(double fuelQuantity, double fuelConsumption) {
	super(fuelQuantity, fuelConsumption + 1.6);

    }

    @Override
    public void setRefueledLiters(double refueledLiters) {
	this.fuelQuantity += (refueledLiters * 0.95);
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
