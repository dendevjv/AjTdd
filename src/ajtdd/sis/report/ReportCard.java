package ajtdd.sis.report;

import java.util.EnumMap;
import java.util.Map;

import ajtdd.sis.studentinfo.Student;
import ajtdd.sis.studentinfo.Student.Grade;

public class ReportCard {

	public static final String A_MESSAGE = "Excellent";
	public static final String B_MESSAGE = "Very good";
	public static final String C_MESSAGE = "Hmmm...";
	public static final String D_MESSAGE = "You're not trying";
	public static final String F_MESSAGE = "Loser";

	private Map<Student.Grade, String> messages = null;

	public String getMessage(Grade grade) {
		return getMessages().get(grade);
	}

	private Map<Student.Grade, String> getMessages() {
		if (messages == null) {
			loadMessages();
		}
		return messages;
	}

	private void loadMessages() {
		messages = new EnumMap<>(Student.Grade.class);
		messages.put(Grade.A, A_MESSAGE);
		messages.put(Grade.B, B_MESSAGE);
		messages.put(Grade.C, C_MESSAGE);
		messages.put(Grade.D, D_MESSAGE);
		messages.put(Grade.F, F_MESSAGE);
	}

}
