package _06_class.more_exercises._04_TeamworkProjects;

import java.util.List;

public class TeamHelper {

	public static boolean wasTeamCreated(List<Team> teams, String teamName) {
		for (Team team : teams) {
			if (team.getName()
					.equals(teamName)) {
				return true;
			}
		}

		return false;
	}

	public static boolean hasAlreadyTeam(List<Team> teams, String nickName) {
		for (Team team : teams) {
			if (team.getCreator()
					.getNickName()
					.equals(nickName)) {
				return true;
			}
		}

		return false;
	}

	public static boolean doesTeamExist(List<Team> teams, String teamName) {
		for (Team team : teams) {
			if (team.getName()
					.equals(teamName)) {
				return true;
			}
		}

		return false;
	}

	public static boolean hasMemaberAlreadyTeam(List<Team> teams, String nickName) {
		for (Team team : teams) {

			List<User> users = team.getUsers();
			if (users.size() > 0) {

				for (User user : users) {
					if (user.getNickName()
							.equals(nickName)

					) {
						return true;
					}
				}
			}

			if (team.getCreator()
					.getNickName()
					.equals(nickName)) {
				return true;
			}
		}

		return false;
	}

	public static Team getTeamByName(List<Team> teams, String teamName) {
		for (Team team : teams) {
			if (team.getName()
					.equals(teamName)) {
				return team;
			}
		}

		return null;
	}

	public static void printCreatorHasTeamMessage(String nickName) {
		System.err.printf("%s cannot create another team!%n", nickName);
	}

	public static void printTeamWasCreatedMessage(String teamName) {
		System.err.printf("Team %s was already created!%n", teamName);
	}
}
