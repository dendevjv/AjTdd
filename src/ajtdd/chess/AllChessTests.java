package ajtdd.chess;

import junit.framework.TestSuite;
import ajtdd.chess.pieces.PawnTest;

public class AllChessTests {
	public static TestSuite suite() {
		TestSuite suite = new TestSuite();
		suite.addTestSuite(BoardTest.class);
		suite.addTestSuite(PawnTest.class);
		return suite;
	}
}
