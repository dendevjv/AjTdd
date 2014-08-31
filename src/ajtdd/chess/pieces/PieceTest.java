package ajtdd.chess.pieces;

import junit.framework.TestCase;

public class PieceTest extends TestCase {
	public void testCreate() {
		Piece p1 = new Pawn();
		assertEquals(Piece.WHITE_COLOR, p1.getColor());
		
		Piece p2 = new Pawn(Piece.BLACK_COLOR);
		assertEquals(Pawn.BLACK_COLOR, p2.getColor());
		
		Piece p3 = new Pawn(Piece.WHITE_COLOR);
		assertEquals(Pawn.WHITE_COLOR, p3.getColor());
	}
}
