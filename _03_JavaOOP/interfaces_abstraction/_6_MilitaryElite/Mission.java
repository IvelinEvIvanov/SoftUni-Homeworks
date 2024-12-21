package interfaces_abstraction._6_MilitaryElite;

public class Mission {

    private String codeName;
    private State state;

    public Mission(String codeName, String state) {
	this.codeName = codeName;

	try {
	    this.state = State.valueOf(state);
	} catch (IllegalArgumentException ex) {
	    throw new IllegalArgumentException("Invalid mission");
	}

    }

    public void completeMission() {

    }

    @Override
    public String toString() {
	return String.format("Code Name: " + this.codeName + " State: " + this.state);
    }

}
