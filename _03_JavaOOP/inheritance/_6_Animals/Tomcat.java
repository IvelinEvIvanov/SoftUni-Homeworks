package inheritance._6_Animals;

public class Tomcat extends Cat {

    public Tomcat(String name, int age) {
	super(name, age, "Male");
    }

    @Override
    public String produceSound() {
	return "MEOW";
    }

}
