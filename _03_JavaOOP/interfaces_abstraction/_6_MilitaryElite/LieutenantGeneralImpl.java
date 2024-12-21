package interfaces_abstraction._6_MilitaryElite;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {

    private TreeSet<Private> privateSoldiers;

    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
	super(id, firstName, lastName, salary);
	this.privateSoldiers = new TreeSet<Private>(new CompareById<Private>());

    }

    public void addPrivate(Private priv) {
	this.privateSoldiers.add(priv);

    }

    @Override
    public Set<Private> getPrivates() {
	return this.privateSoldiers;
    }

    @Override
    public String toString() {

	StringBuilder result = new StringBuilder(super.toString());
	result.append(System.lineSeparator());
	result.append("Privates:");
	result.append(System.lineSeparator());

	for (Private priv : this.getPrivates()) {
	    result.append("  " + priv);
	    result.append(System.lineSeparator());
	}

	return result.toString().trim();
    }

}
