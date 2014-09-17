package ajtdd.sis.report;

import static ajtdd.sis.studentinfo.Student.Grade.A;
import static ajtdd.sis.studentinfo.Student.Grade.B;
import static ajtdd.sis.studentinfo.Student.Grade.C;
import static ajtdd.sis.studentinfo.Student.Grade.D;
import static ajtdd.sis.studentinfo.Student.Grade.F;
import junit.framework.TestCase;

public class ReportCardTest extends TestCase {
	public void testMessage() {
		ReportCard card = new ReportCard();
		assertEquals(ReportCard.A_MESSAGE, card.getMessage(A));
		assertEquals(ReportCard.B_MESSAGE, card.getMessage(B));
		assertEquals(ReportCard.C_MESSAGE, card.getMessage(C));
		assertEquals(ReportCard.D_MESSAGE, card.getMessage(D));
		assertEquals(ReportCard.F_MESSAGE, card.getMessage(F));
	}
}
