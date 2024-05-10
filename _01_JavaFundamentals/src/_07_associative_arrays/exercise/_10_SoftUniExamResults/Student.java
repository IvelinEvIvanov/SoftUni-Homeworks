package _07_associative_arrays.exercise._10_SoftUniExamResults;

import java.util.ArrayList;
import java.util.List;

public class Student {

	private String name;
	private List<Submission> submissions = new ArrayList<>();

	public Student(String name, String programLanguage, Integer points) {
		this.name = name;
		this.submissions.add(new Submission(programLanguage, points));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Submission> getSubmissions() {
		return submissions;
	}

	public void setSubmissions(List<Submission> submissions) {
		this.submissions = submissions;
	}

	public void addSubmission(String programLanguage, Integer points) {
		this.submissions.add(new Submission(programLanguage, points));
	}

	public Integer getMaxPoint() {
		Integer max = 0;
		for (Submission submission : submissions) {
			if (max < submission.getPoints()) {
				max = submission.getPoints();
			}
		}
		return max;
	}

	@Override
	public String toString() {
		Integer maxPoint = this.getMaxPoint();
		return String.format("%s | %d", name, maxPoint);
	}

}
