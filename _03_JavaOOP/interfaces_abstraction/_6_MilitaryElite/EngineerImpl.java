package interfaces_abstraction._6_MilitaryElite;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {

    private Set<Repair> repairs;

    public EngineerImpl(int id, String firstName, String lastName, double salary, String corp) {
	super(id, firstName, lastName, salary, corp);

	this.repairs = new LinkedHashSet<Repair>();

    }

    public void addRepair(Repair repair) {
	this.repairs.add(repair);
    }

    @Override
    public Collection<Repair> getRepaire() {
	return this.repairs;
    }

    @Override
    public String toString() {
	StringBuilder result = new StringBuilder(super.toString());
	result.append(System.lineSeparator());

	result.append("Repairs:");
	result.append(System.lineSeparator());

	for (Repair repair : repairs) {
	    result.append("  " + repair);
	    result.append(System.lineSeparator());
	}

	return result.toString().trim();

    }

}
