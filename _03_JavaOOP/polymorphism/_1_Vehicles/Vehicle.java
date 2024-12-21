package polymorphism._1_Vehicles;

public abstract class Vehicle {

    protected double fuelQuantity;
    protected double fuelConsumption;
    protected double drivenDistance;
    protected double refueledLiters;

    public Vehicle(double fuelQuantity, double fuelConsumption) {
	this.fuelQuantity = fuelQuantity;
	this.fuelConsumption = fuelConsumption;
    }

    public double getFuelQuantity() {
	return fuelQuantity;
    }

    public double getFuelConsumption() {
	return fuelConsumption;
    }

    public double getDrivenDistance() {
	return drivenDistance;
    }

    public double getRefueledLiters() {
	return refueledLiters;
    }

    public void setFuelQuantity(double fuelQuantity) {
	this.fuelQuantity = fuelQuantity;
    }

    public void setFuelConsumption(double fuelConsumption) {
	this.fuelConsumption = fuelConsumption;
    }

    public void setDrivenDistance(double drivenDistance) {
	this.drivenDistance = drivenDistance;
    }

    public void setRefueledLiters(double refueledLiters) {
	this.refueledLiters = refueledLiters;
    }

    public abstract double calculateFuel(double distance);

}
