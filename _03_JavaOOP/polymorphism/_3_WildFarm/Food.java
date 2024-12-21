package polymorphism._3_WildFarm;

public abstract class Food {

    private int food;

    public Food(int food) {
	this.food = food;
    }

    public int getFood() {
	return food;
    }

    protected void setFood(int food) {
	this.food = food;
    }

}
