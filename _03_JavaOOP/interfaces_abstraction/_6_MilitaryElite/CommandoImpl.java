package interfaces_abstraction._6_MilitaryElite;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {

    private Set<Mission> missons;

    public CommandoImpl(int id, String firstName, String lastName, double salary, String corp) {
	super(id, firstName, lastName, salary, corp);

	this.missons = new LinkedHashSet<Mission>();

    }

    public void addMission(Mission mission) {
	this.missons.add(mission);
    }

    @Override
    public Collection<Mission> getMission() {
	return this.missons;
    }

    @Override
    public String toString() {

	StringBuilder result = new StringBuilder(super.toString());
	result.append(System.lineSeparator());

	result.append("Missions:");
	result.append(System.lineSeparator());

	for (Mission mission : this.missons) {
	    result.append("  " + mission);
	    result.append(System.lineSeparator());
	}

	return result.toString().trim();
    }

}
