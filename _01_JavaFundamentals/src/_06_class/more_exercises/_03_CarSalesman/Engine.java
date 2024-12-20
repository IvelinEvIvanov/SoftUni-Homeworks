package _06_class.more_exercises._03_CarSalesman;

public class Engine {

	private String model;
	private int power;
	private String displacement = "n/a";
	private String efficiency = "n/a";

	public Engine() {
	}

	public Engine(String model, int power) {
		this.model = model;
		this.power = power;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public String getDisplacement() {
		return displacement;
	}

	public void setDisplacement(String displacement) {
		this.displacement = displacement;
	}

	public String getEfficiency() {
		return efficiency;
	}

	public void setEfficiency(String efficiency) {
		this.efficiency = efficiency;
	}

}
