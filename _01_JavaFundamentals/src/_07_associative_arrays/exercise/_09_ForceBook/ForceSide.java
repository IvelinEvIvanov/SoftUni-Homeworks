package _07_associative_arrays.exercise._09_ForceBook;

import java.util.ArrayList;
import java.util.List;

public class ForceSide {

	private String sideName;
	private List<String> forceUsers;

	public ForceSide(String side, String user) {
		this.sideName = side;
		this.forceUsers = new ArrayList<>();
		this.forceUsers.add(user);
	}

	public List<String> getForceUsers() {
		return forceUsers;
	}

	public void setForceUsers(List<String> forceUsers) {
		this.forceUsers = forceUsers;
	}

	public String getSideName() {
		return sideName;
	}

	public void addForceUser(String name) {
		if (!this.forceUsers.contains(name)) {
			this.forceUsers.add(name);
		}
	}

	public void removeForceUser(String name) {
		this.forceUsers.remove(name);
	}

	public boolean isThereForceUsers() {
		return this.forceUsers.size() == 0	? false
											: true;
	}

	public boolean isForceUserExist(String name) {
		if (this.forceUsers.contains(name)) {
			return true;
		}
		return false;
	}

	public int getUsersCount() {
		return this.forceUsers.size();
	}

	@Override
	public String toString() {
		String result = String.format("Side: %s, Members: %d%n", this.sideName, this.getUsersCount());

		for (String user : forceUsers) {
			result += "! " + user + "\n";
		}

		return result;
	}

}
