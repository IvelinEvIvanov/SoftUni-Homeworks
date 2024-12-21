package interfaces_abstraction._6_MilitaryElite;

public class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier {

    private Corps corp;

    public SpecialisedSoldierImpl(int id, String firstName, String lastName, double salary, String corp) {
	super(id, firstName, lastName, salary);

	try {
	    this.corp = Corps.valueOf(corp);
	} catch (IllegalArgumentException ex) {
	    throw new IllegalArgumentException("Invalid corp");
	}
    }

    @Override
    public Corps getCorp() {
	return this.corp;
    }

    @Override
    public String toString() {
	return String.format("%s%nCorps: %s", super.toString(), this.corp);
    }

}
