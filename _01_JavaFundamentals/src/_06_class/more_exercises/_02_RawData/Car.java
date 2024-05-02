package _06_class.more_exercises._02_RawData;

public class Car {

	private String model;
	private Engine engine;
	private Cargo cargo;
	private Tier[] tiers;

	public Car(String model, Engine engine, Cargo cargo, Tier[] tiers) {
		this.model = model;
		this.engine = engine;
		this.cargo = cargo;
		this.tiers = tiers;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Tier[] getTiers() {
		return tiers;
	}

	public void setTiers(Tier[] tiers) {
		this.tiers = tiers;
	}

	@Override
	public String toString() {
		return this.model;
	}

}
