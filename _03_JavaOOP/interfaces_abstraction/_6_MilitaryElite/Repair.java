package interfaces_abstraction._6_MilitaryElite;

public class Repair {

    private String partName;
    private int hoursWorked;

    public Repair(String partName, int hoursWorked) {
	this.partName = partName;
	this.hoursWorked = hoursWorked;
    }

    @Override
    public String toString() {
	StringBuilder result = new StringBuilder("Part Name: ");
	result.append(this.partName);

	result.append(" Hours Worked: ");
	result.append(this.hoursWorked);

	return result.toString().trim();
    }

}
