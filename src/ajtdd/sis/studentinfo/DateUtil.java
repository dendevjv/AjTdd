package ajtdd.sis.studentinfo;

import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {

	/**
	 * Creates date object for specified year, month and day of month.
	 * @param year year
	 * @param month month (from 1 to 12)
	 * @param date day of month (from 1 to 31)
	 * @return
	 */
	public static Date createDate(int year, int month, int date) {
		return new GregorianCalendar(year, month - 1, date).getTime();
	}
}
