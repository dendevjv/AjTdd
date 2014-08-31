package ajtdd.sis.studentinfo;

public class Student {
	public static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
	static final String IN_STATE = "CO";
	private int credits;
	private String name;
	private String state = "";

	public Student(String name) {
		this.name = name;
		credits = 0;
	}

	public void addCredits(int credits) {
		this.credits += credits;
	}

	public int getCredits() {
		return credits;
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

	public void setState(String state) {
		this.state = state.toUpperCase();
	}
}
