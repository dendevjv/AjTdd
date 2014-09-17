package ajtdd.sis.studentinfo;

import java.util.ArrayList;
import java.util.List;

public class Student {
	public enum Grade {
		A(4),
		B(3),
		C(2),
		D(1),
		F(0);
		
		private int points;
		
		Grade(int points) {
			this.points = points;
		}
		
		int getPoints() {
			return points;
		}
	}
	
	public static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;;
	static final String IN_STATE = "CO";
	private int credits;
	private List<Grade> grades = new ArrayList<>();
	private GradingStrategy gradingStrategy;
	private String name;
	private String state = "";

	public Student(String name) {
		this.name = name;
		credits = 0;
		gradingStrategy = new BasicGradingStrategy();
	}

	public void addCredits(int credits) {
		this.credits += credits;
	}

	public void addGrade(Grade grade) {
		grades.add(grade);
	}

	public int getCredits() {
		return credits;
	}

	public double getGpa() {
		if (grades.isEmpty()) {
			return 0.0;
		}
		double total = 0.0;
		for (Grade grade : grades) {
			total += gradingStrategy.getGradePointsFor(grade);
		}
		return total / grades.size();
	}

	public String getName() {
		return name;
	}
	
	public boolean isFullTime() {
		return credits >= Student.CREDITS_REQUIRED_FOR_FULL_TIME;
	}

	public boolean isInState() {
		return state.equals(Student.IN_STATE);
	}

	public void setGradingStrategy(GradingStrategy gradingStrategy) {
		this.gradingStrategy = gradingStrategy;
	}

	public void setState(String state) {
		this.state = state.toUpperCase();
	}
}
