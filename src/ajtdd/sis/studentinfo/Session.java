package ajtdd.sis.studentinfo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public abstract class Session implements Comparable<Session> {
	private String department;
	private String number;
	private int numberOfCredits;
	private Date startDate;
	private List<Student> students = new ArrayList<Student>();

	public Session(String department, String number, Date startDate) {
		this.department = department;
		this.number = number;
		this.startDate = startDate;
	}

	public void enroll(Student student) {
		student.addCredits(numberOfCredits);
		students.add(student);
	}

	public Student get(int i) {
		return students.get(i);
	}

	public List<Student> getAllStudents() {
		return students;
	}

	public String getDepartment() {
		return department;
	}

	/**
	 * Get the last date of the course session
	 * 
	 * @return the last date of the course session
	 */
	public Date getEndDate() {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(getStartDate());
		final int daysInWeek = 7;
		final int daysFromFridayToMonday = 3;
		int numberOfDays = getSessionLength() * daysInWeek
				- daysFromFridayToMonday;
		calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
		return calendar.getTime();
	}

	public String getNumber() {
		return number;
	}

	public int getNumberOfStudents() {
		return students.size();
	}

	public abstract int getSessionLength();

	public void setNumberOfCredits(int credits) {
		this.numberOfCredits = credits;
	}

	protected Date getStartDate() {
		return startDate;
	}
	
	@Override
	public int compareTo(Session other) {
		int compare = this.getDepartment().compareTo(other.getDepartment());
		if (compare == 0) {
			compare = this.getNumber().compareTo(other.getNumber());
		}
		return compare;
	}
}
