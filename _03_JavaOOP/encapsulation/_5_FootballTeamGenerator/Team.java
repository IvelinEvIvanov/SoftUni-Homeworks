package encapsulation._5_FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private String name;
    private List<Player> players;

    public Team(String name) {
	this.setName(name);
	this.players = new ArrayList<>();
    }

    public String getName() {
	return name;
    }

    private void setName(String name) {
	Validator.validateName(name);
	this.name = name.trim();
    }

    public void addPlayer(Player player) {
	if (!this.players.contains(player)) {
	    this.players.add(player);
	}
    }

    public void removePlayer(String player) {
	int index = -1;
	for (int i = 0; i < this.players.size(); i++) {
	    if (this.players.get(i).getName().equals(player)) {
		index = i;
		break;
	    }
	}

	if (index != -1) {
	    this.players.remove(index);
	} else {
	    throw new IllegalArgumentException(String.format("Player %s is not in %s team.", player, this.name));
	}
    }

    public double getRating() {
	return this.players.stream().mapToDouble(Player::overallSkillLevel).sum();
    }

    public boolean isValidTeamName(String name) {
	if (!this.name.equals(name)) {
	    throw new IllegalArgumentException("Team " + name + " does not exist.");
	}

	return true;
    }

}
