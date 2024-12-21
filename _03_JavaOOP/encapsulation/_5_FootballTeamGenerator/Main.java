package encapsulation._5_FootballTeamGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	String input = reader.readLine();
	String[] tokens = null;

	Map<String, Team> teams = new HashMap<>();
	Team team = null;
	String teamName = null;
	Player player = null;

	while (!input.equals("END")) {

	    tokens = input.split(";");
	    String command = tokens[0];

	    switch (command) {
	    case "Team":
		team = new Team(tokens[1]);
		teams.putIfAbsent(tokens[1], team);
		break;

	    case "Add":
		teamName = tokens[1];

		int endurance = Integer.parseInt(tokens[3]);
		int sprint = Integer.parseInt(tokens[4]);
		int dribble = Integer.parseInt(tokens[5]);
		int passing = Integer.parseInt(tokens[6]);
		int shooting = Integer.parseInt(tokens[7]);

		try {
		    if (team.isValidTeamName(teamName)) {
			player = new Player(tokens[2], endurance, sprint, dribble, passing, shooting);
			teams.get(teamName).addPlayer(player);
		    }
		} catch (IllegalArgumentException e) {
		    System.out.println(e.getMessage());
		}

		break;

	    case "Remove":
		try {
		    if (team.isValidTeamName(tokens[1])) {
			teams.get(teamName).removePlayer(tokens[2]);
		    }
		} catch (IllegalArgumentException e) {
		    System.out.println(e.getMessage());
		}
		break;

	    case "Rating":
		try {
		    team.isValidTeamName(tokens[1]);
		    System.out.println(team.getName() + " - " + Math.round(teams.get(tokens[1]).getRating()));
		} catch (IllegalArgumentException e) {
		    System.out.println(e.getMessage());
		}
		break;

	    }

	    input = reader.readLine();
	} // while

    }
}
