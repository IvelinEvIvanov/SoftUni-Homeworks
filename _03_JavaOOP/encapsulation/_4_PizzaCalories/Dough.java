package encapsulation._4_PizzaCalories;

public class Dough {

    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
	this.setFlourType(flourType);
	this.setBakingTechnique(bakingTechnique);
	this.setWeight(weight);
    }

    private void setFlourType(String flourType) {
	Validator.validateFlour(flourType);
	this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
	Validator.validateBakingTechnique(bakingTechnique);
	this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
	Validator.validateWeight(weight);
	this.weight = weight;
    }

    public double calculateCalories() {
	DoughModifiers flour = DoughModifiers.valueOf(this.flourType);
	DoughModifiers bakingTechnique = DoughModifiers.valueOf(this.bakingTechnique);

	return (2 * this.weight) * flour.getValue() * bakingTechnique.getValue();
    }
}
