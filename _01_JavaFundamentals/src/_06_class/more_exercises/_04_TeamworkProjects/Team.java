package _06_class.more_exercises._04_TeamworkProjects;

import java.util.ArrayList;
import java.util.List;

public class Team {

	private String name;
	private User creator;
	private List<User> users;

	public Team(String name) {
		this.name = name;
		this.users = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public void joinUser(String name) {
		this.users.add(new User(name));
	}

	public void printTeamCreatedMessage() {
		System.out.printf("Team %s has been created by %s!%n", this.name, this.creator.getNickName());
	}

	@Override
	public String toString() {
		String result = String.format("%s%n - %s%n", name, creator.getNickName());
		
		for (User user : users) {
			result += user;
		}

		return result;
	}

}
