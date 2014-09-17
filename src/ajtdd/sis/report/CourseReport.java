package ajtdd.sis.report;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static ajtdd.sis.report.ReportConstant.NEWLINE;
import ajtdd.sis.studentinfo.CourseSession;

public class CourseReport {
	private List<CourseSession> sessions = new ArrayList<>();

	public void add(CourseSession session) {
		sessions.add(session);
	}

	public String text() {
		Collections.sort(sessions);
		StringBuilder sb = new StringBuilder();
		for (CourseSession cs : sessions) {
			sb.append(cs.getDepartment());
			sb.append(" ");
			sb.append(cs.getNumber());
			sb.append(NEWLINE);
		}
		return sb.toString();
	}

}
