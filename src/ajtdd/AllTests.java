package ajtdd;

import junit.framework.TestSuite;

public class AllTests {
	public static TestSuite suite() {
		TestSuite suite = new TestSuite();
		suite.addTest(ajtdd.sis.AllTests.suite());
		suite.addTest(ajtdd.chess.AllTests.suite());
		return suite;
	}
}
