package ajtdd.sis;

import junit.framework.TestSuite;

public class AllTests {
	public static TestSuite suite() {
		TestSuite suite = new TestSuite();
		suite.addTest(ajtdd.sis.report.AllTests.suite());
		suite.addTest(ajtdd.sis.studentinfo.AllTests.suite());
		return suite;
	}
}
