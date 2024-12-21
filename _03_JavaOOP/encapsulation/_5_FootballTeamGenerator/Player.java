package encapsulation._5_FootballTeamGenerator;

public class Player {

    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
	this.setName(name);
	this.setEndurance(endurance);
	this.setSprint(sprint);
	this.setDribble(dribble);
	this.setPassing(passing);
	this.setShooting(shooting);
    }

    public String getName() {
	return name;
    }

    private void setName(String name) {
	Validator.validateName(name);
	this.name = name.trim();
    }

    private void setEndurance(int endurance) {
	Validator.validateStat("Endurance", endurance);
	this.endurance = endurance;
    }

    private void setSprint(int sprint) {
	Validator.validateStat("Sprint", endurance);
	this.sprint = sprint;
    }

    private void setDribble(int dribble) {
	Validator.validateStat("Dribble", dribble);
	this.dribble = dribble;
    }

    private void setPassing(int passing) {
	Validator.validateStat("Passing", passing);
	this.passing = passing;
    }

    private void setShooting(int shooting) {
	Validator.validateStat("Shooting", shooting);
	this.shooting = shooting;
    }

    public double overallSkillLevel() {
	return (this.endurance + this.sprint + this.dribble + this.passing + this.shooting) / 5.00;
    }

}
