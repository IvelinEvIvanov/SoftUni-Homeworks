package _06_class.more_exercises._04_TeamworkProjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nTeams = Integer.parseInt(scanner.nextLine());

		List<Team> teams = new ArrayList<>();
		String userName = "";
		String teamName = "";

		// Create Team
		for (int i = 0; i < nTeams; i++) {
			String[] tokens = scanner	.nextLine()
										.split("-");

			userName = tokens[0];
			teamName = tokens[1];

			if (teams.size() > 0) {
				boolean wasTeamCreated = TeamHelper.wasTeamCreated(teams, teamName);
				if (wasTeamCreated) {
					TeamHelper.printTeamWasCreatedMessage(teamName);
				}

				boolean hasAlreadyTeam = TeamHelper.hasAlreadyTeam(teams, userName);
				if (hasAlreadyTeam) {
					TeamHelper.printCreatorHasTeamMessage(userName);
				}

				if (!wasTeamCreated && !hasAlreadyTeam) {
					Team team = new Team(teamName);
					team.setCreator(new User(userName));
					teams.add(team);

					team.printTeamCreatedMessage();
				}
			} else {
				Team team = new Team(teamName);
				team.setCreator(new User(userName));
				teams.add(team);

				team.printTeamCreatedMessage();
			}
		}

		// Join Users To Team
		while (true) {
			String line = scanner.nextLine();
			if (line.equals("end of assignment")) {
				break;
			}

			String[] tokens = line.split("->");

			userName = tokens[0];
			teamName = tokens[1];

			if (!TeamHelper.doesTeamExist(teams, teamName)) {
				System.err.printf("Team %s does not exist!%n", teamName);
				continue;
			}

			if (TeamHelper.hasMemaberAlreadyTeam(teams, userName)) {
				System.err.printf("Member %s cannot join team {team Name}!%n", userName);
				continue;
			}

			Team team = TeamHelper.getTeamByName(teams, teamName);
			if (team != null) {
				team.getUsers()
					.add(new User(userName));
			}
		}

		scanner.close();

		teams.sort((t1, t2) -> t2	.getUsers()
									.size()
				- t1.getUsers()
					.size());

		for (Team team : teams) {
			if (team.getUsers()
					.size() > 0) {
				System.out.println(team);
			}
		}

		System.out.println("Teams to disband:");
		for (Team team : teams) {
			if (team.getUsers()
					.size() == 0) {
				System.out.println(team.getName());
			}
		}
	}
}
