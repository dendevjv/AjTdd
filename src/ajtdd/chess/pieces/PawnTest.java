package ajtdd.chess.pieces;

import ajtdd.Debug;

public class PawnTest  extends junit.framework.TestCase {

	public void testCreate() {
		Debug.log.info("PawnTest");
		
		Pawn pawn1 = new Pawn(Pawn.WHITE_COLOR);
		assertEquals(Pawn.WHITE_COLOR, pawn1.getColor());
		
		Pawn pawn2 = new Pawn(Pawn.BLACK_COLOR);
		assertEquals(Pawn.BLACK_COLOR, pawn2.getColor());
		
		Pawn pawn3 = new Pawn();
		assertEquals(Pawn.WHITE_COLOR, pawn3.getColor());
	}
	
	public void testRepresentation() {
		assertEquals("p", new Pawn(Pawn.WHITE_COLOR).toString());
		assertEquals("P", new Pawn(Pawn.BLACK_COLOR).toString());
		
		try {
			 new Pawn("Yellow").toString();
			 fail("Invalid color, expected IllegalStateException");
		} catch (IllegalStateException ex) {
			// expected
		}
	}
	
//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}

}
