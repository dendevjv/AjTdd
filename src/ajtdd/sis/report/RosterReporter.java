package ajtdd.sis.report;

import ajtdd.sis.studentinfo.CourseSession;
import ajtdd.sis.studentinfo.Student;

import static ajtdd.sis.report.ReportConstant.NEWLINE;

public class RosterReporter {

	public static final String ROSTER_REPORT_FOOTER = NEWLINE + "# students = ";
	public static final String ROSTER_REPORT_HEADER = "Student" + NEWLINE + "-"
			+ NEWLINE;

	private CourseSession session;

	public RosterReporter(CourseSession session) {
		this.session = session;
	}

	public String getReport() {
		StringBuilder buffer = new StringBuilder();

		writeHeader(buffer);
		writeBody(buffer);
		writeFooter(buffer);

		return buffer.toString();
	}

	private void writeBody(StringBuilder buffer) {
		for (Student student : session.getAllStudents()) {
			buffer.append(student.getName());
			buffer.append(NEWLINE);
		}
	}

	private void writeFooter(StringBuilder buffer) {
		buffer.append(ROSTER_REPORT_FOOTER);
		buffer.append(session.getNumberOfStudents());
		buffer.append(NEWLINE);
	}

	private void writeHeader(StringBuilder buffer) {
		buffer.append(ROSTER_REPORT_HEADER);
	}
}
