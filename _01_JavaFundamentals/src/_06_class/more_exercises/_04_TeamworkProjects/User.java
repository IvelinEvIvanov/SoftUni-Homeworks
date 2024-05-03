package _06_class.more_exercises._04_TeamworkProjects;

public class User {

	private String nickName;

	public User(String nickName) {
		this.nickName = nickName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return String.format(" -- %s%n", nickName);
	}
}
