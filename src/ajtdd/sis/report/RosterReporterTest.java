package ajtdd.sis.report;

import static ajtdd.sis.report.ReportConstant.NEWLINE;
import junit.framework.TestCase;
import ajtdd.sis.studentinfo.CourseSession;
import ajtdd.sis.studentinfo.DateUtil;
import ajtdd.sis.studentinfo.Student;

public class RosterReporterTest extends TestCase {
	public void testRosterReport() {
		CourseSession session = CourseSession.create("ENGL", "101",
				DateUtil.createDate(2003, 1, 6));

		session.enroll(new Student("A"));
		session.enroll(new Student("B"));
		String rosterReport = new RosterReporter(session).getReport();
		assertEquals(
				RosterReporter.ROSTER_REPORT_HEADER + "A" + NEWLINE + "B"
						+ NEWLINE + RosterReporter.ROSTER_REPORT_FOOTER + "2"
						+ NEWLINE, rosterReport);
	}
}
