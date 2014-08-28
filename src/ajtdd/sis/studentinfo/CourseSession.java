package ajtdd.sis.studentinfo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Provides a representation of a single semester
 * session of a specific university course.
 */
public class CourseSession {
	private String department;
	private String number;
	private Date startDate;
	private ArrayList<Student> students = new ArrayList<Student>();

	/**
	 * Constructs a CourseSession starting on a specific date.
	 * @param department
	 * @param number
	 * @param startDate
	 */
	public CourseSession(String department, String number, Date startDate) {
		this.department = department;
		this.number = number;
		this.startDate = startDate;
	}

	String getDepartment() {
		return department;
	}

	String getNumber() {
		return number;
	}

	public int getNumberOfStudents() {
		return students.size();
	}

	public void enroll(Student student) {
		students.add(student);
	}

	Student get(int i) {
		return students.get(i);
	}

	/**
	 * Get the last date of the course session
	 * @return the last date of the course session
	 */
	Object getEndDate() {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(startDate);
		final int sessionLengthInWeeks = 16;
		final int daysInWeek = 7;
		final int daysFromFridayToMonday = 3;
		final int numberOfDays = sessionLengthInWeeks * daysInWeek
				- daysFromFridayToMonday;
		calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
		return calendar.getTime();
	}

	public Date getStartDate() {
		return startDate;
	}
	
	public ArrayList<Student> getAllStudents() {
		return students;
	}

}
