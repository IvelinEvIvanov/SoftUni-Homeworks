package polymorphism._2_VehiclesExtension;

public abstract class Vehicle {

    protected double fuelQuantity;
    protected double fuelConsumption;
    protected double drivenDistance;
    protected double refueledLiters;
    protected double tankCapacity;

    public Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
	this.fuelQuantity = fuelQuantity;
	this.fuelConsumption = fuelConsumption;
	this.tankCapacity = tankCapacity;
    }

    protected double getFuelQuantity() {
	return fuelQuantity;
    }

    protected double getFuelConsumption() {
	return fuelConsumption;
    }

    protected double getDrivenDistance() {
	return drivenDistance;
    }

    protected double getRefueledLiters() {
	return refueledLiters;
    }

    protected void setFuelQuantity(double fuelQuantity) {
	this.fuelQuantity = fuelQuantity;
    }

    protected void setFuelConsumption(double fuelConsumption) {
	this.fuelConsumption = fuelConsumption;
    }

    protected void setDrivenDistance(double drivenDistance) {
	this.drivenDistance = drivenDistance;
    }

    public void setRefueledLiters(double refueledLiters) {
	if (this.isRefueledLitersNegative(refueledLiters)) {
	    System.out.println("Fuel must be a positive number");
	} else if (this.isMoreThanCapacity(refueledLiters)) {
	    System.out.println("Cannot fit fuel in tank");
	} else {
	    this.fuelQuantity += refueledLiters;
	}

    }

    protected boolean isRefueledLitersNegative(double refueledLiters) {
	if (refueledLiters <= 0) {
	    return true;
	}

	return false;
    }

    protected boolean isMoreThanCapacity(double refueledLiters) {

	if ((this.fuelQuantity + refueledLiters) > this.getTankCapacity()) {
	    return true;
	}

	return false;
    }

    protected double getTankCapacity() {
	return tankCapacity;
    }

    protected void setTankCapacity(double tankCapacity) {
	this.tankCapacity = tankCapacity;
    }

    protected abstract double calculateFuel(double distance);

}
