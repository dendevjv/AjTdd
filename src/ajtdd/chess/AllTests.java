package ajtdd.chess;

import junit.framework.TestSuite;
import ajtdd.chess.pieces.PieceTest;

public class AllTests {
	public static TestSuite suite() {
		TestSuite suite = new TestSuite();
		suite.addTestSuite(PieceTest.class);
		suite.addTestSuite(BoardTest.class);
		return suite;
	}
}
