package ajtdd.chess.pieces;

import junit.framework.TestCase;

public class PieceTest extends TestCase {
	public void testCreate() {
		Piece p1 = Piece.createPawnWhite();
		assertEquals(Piece.WHITE_COLOR, p1.getColor());
		assertEquals(Piece.PAWN_NAME, p1.getName());
		
		Piece p2 = Piece.createPawnBlack();
		assertEquals(Piece.BLACK_COLOR, p2.getColor());
		assertEquals(Piece.PAWN_NAME, p2.getName());
		
		/* Other types of Pieces are tested in BoardTest. */
	}
	
	public void testRepresentation() {
		Piece p1 = Piece.createPawnWhite();
		assertEquals("p", p1.toString());
		
		Piece p2 = Piece.createPawnBlack();
		assertEquals("P", p2.toString());
	}
	
	public void testColor() {
		Piece p1 = Piece.createKingWhite();
		assertEquals(Piece.WHITE_COLOR, p1.getColor());
		assertTrue(p1.isWhite());
		assertFalse(p1.isBlack());
		
		Piece p2 = Piece.createKingBlack();
		assertEquals(Piece.BLACK_COLOR, p2.getColor());
		assertTrue(p2.isBlack());
		assertFalse(p2.isWhite());
	}
}
