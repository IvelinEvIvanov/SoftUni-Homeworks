package encapsulation._5_FootballTeamGenerator;

public class Validator {
    public static void validateName(String name) {
	if (name == null || name.trim().isEmpty()) {
	    throw new IllegalArgumentException("A name should not be empty.");
	}
    }

    public static void validateStat(String statName, int statNumber) {
	if (statNumber < 0 || statNumber > 100) {
	    throw new IllegalArgumentException(statName + " should be between 0 and 100.");
	}
    }

}
