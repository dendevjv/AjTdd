package ajtdd.sis.studentinfo;

import junit.framework.TestCase;
import ajtdd.sis.studentinfo.Student.Grade;

public class HonorsGradingStrategyTest extends TestCase {
	public void testGetGradePoints() {
		HonorsGradingStrategy strategy = new HonorsGradingStrategy();
		assertEquals(5, strategy.getGradePointsFor(Grade.A));
		assertEquals(4, strategy.getGradePointsFor(Grade.B));
		assertEquals(3, strategy.getGradePointsFor(Grade.C));
		assertEquals(2, strategy.getGradePointsFor(Grade.D));
		assertEquals(0, strategy.getGradePointsFor(Grade.F));
	}
}
