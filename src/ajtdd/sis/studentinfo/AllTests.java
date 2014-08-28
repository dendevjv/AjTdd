package ajtdd.sis.studentinfo;

import ajtdd.sis.studentinfo.CourseSessionTest;
import ajtdd.sis.studentinfo.DateUtilTest;
import ajtdd.sis.studentinfo.StudentTest;
import junit.framework.TestSuite;

public class AllTests {
	public static TestSuite suite() {
		TestSuite suite = new TestSuite();
		suite.addTestSuite(StudentTest.class);
		suite.addTestSuite(CourseSessionTest.class);
		suite.addTestSuite(DateUtilTest.class);
		return suite;
	}
}
