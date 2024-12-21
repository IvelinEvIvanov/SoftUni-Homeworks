package polymorphism._2_VehiclesExtension;

public class Bus extends Vehicle {

    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
	super(fuelQuantity, fuelConsumption, tankCapacity);

    }

    @Override
    public double calculateFuel(double distance) {
	if ((this.fuelQuantity - ((this.fuelConsumption + 1.4) * distance)) < 0) {
	    return -1;
	}

	this.fuelQuantity -= ((this.fuelConsumption + 1.4) * distance);

	return this.fuelQuantity;
    }

    public double driveEmpty(double distance) {
	if ((this.fuelQuantity - (this.fuelConsumption * distance)) < 0) {
	    return -1;
	}

	this.fuelQuantity -= (this.fuelConsumption * distance);

	return this.fuelQuantity;
    }

    @Override
    public double getRefueledLiters() {
	return super.getRefueledLiters();
    }

    @Override
    public double getTankCapacity() {
	return super.getTankCapacity();
    }

    @Override
    public void setTankCapacity(double tankCapacity) {
	super.setTankCapacity(tankCapacity);
    }

    @Override
    public String toString() {
	return String.format("Bus: %.2f", this.fuelQuantity);
    }

}
