package ajtdd.chess.pieces;

public class PawnTest  extends junit.framework.TestCase {

	public void testCreate() {
		Pawn pawn1 = new Pawn(Pawn.WHITE_COLOR);
		assertEquals(Pawn.WHITE_COLOR, pawn1.getColor());
		
		Pawn pawn2 = new Pawn(Pawn.BLACK_COLOR);
		assertEquals(Pawn.BLACK_COLOR, pawn2.getColor());
		
		Pawn pawn3 = new Pawn();
		assertEquals(Pawn.WHITE_COLOR, pawn3.getColor());
	}
	
//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}

}
