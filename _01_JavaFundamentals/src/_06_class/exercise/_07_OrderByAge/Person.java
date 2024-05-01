package _06_class.exercise._07_OrderByAge;

public class Person {

	private String firstName;
	private String id;
	private Integer age;

	public Person() {
	}

	public Person(String firstName, String id, Integer age) {
		this.firstName = firstName;
		this.id = id;
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return String.format("%s with %s is %d years old.", firstName, id, age);
	}

}
