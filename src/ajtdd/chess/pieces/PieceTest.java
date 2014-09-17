package ajtdd.chess.pieces;

import ajtdd.chess.pieces.Piece.Type;
import junit.framework.TestCase;

import static ajtdd.chess.pieces.PieceConstants.*;

public class PieceTest extends TestCase {
	private static final double DELTA = 1e-14;

	public void testCreate() {
		verifyCreation(Piece.createPawnWhite(), Piece.createPawnBlack(),
				Piece.Type.Pawn, PAWN_REPRESENTATION);
		verifyCreation(Piece.createRookWhite(), Piece.createRookBlack(),
				Piece.Type.Rook, ROOK_REPRESENTATION);
		verifyCreation(Piece.createKnightWhite(), Piece.createKnightBlack(),
				Piece.Type.Knight, KNIGHT_REPRESENTATION);
		verifyCreation(Piece.createBishopWhite(), Piece.createBishopBlack(),
				Piece.Type.Bishop, BISHOP_REPRESENTATION);
		verifyCreation(Piece.createQueenWhite(), Piece.createQueenBlack(),
				Piece.Type.Queen, QUEEN_REPRESENTATION);
		verifyCreation(Piece.createKingWhite(), Piece.createKingBlack(),
				Piece.Type.King, KING_REPRESENTATION);
		Piece blank = Piece.noPiece();
		assertEquals(".", blank.getRepresentation());
		assertEquals(Piece.Type.NoPiece, blank.getType());
	}
	
	private void verifyCreation(Piece whitePiece, Piece blackPiece,
			Type type, String representation) {
		assertTrue(whitePiece.isWhite());
		assertEquals(type, whitePiece.getType());
		assertEquals(representation.toLowerCase(), whitePiece.getRepresentation());
		
		assertTrue(blackPiece.isBlack());
		assertEquals(type, blackPiece.getType());
		assertEquals(representation, blackPiece.getRepresentation());
	}

	public void testRepresentation() {
		assertEquals("p", Piece.createPawnWhite().toString());
		assertEquals("P", Piece.createPawnBlack().toString());
		assertEquals("n", Piece.createKnightWhite().toString());
		assertEquals("N", Piece.createKnightBlack().toString());
		assertEquals("b", Piece.createBishopWhite().toString());
		assertEquals("B", Piece.createBishopBlack().toString());
		assertEquals("r", Piece.createRookWhite().toString());
		assertEquals("R", Piece.createRookBlack().toString());
		assertEquals("q", Piece.createQueenWhite().toString());
		assertEquals("Q", Piece.createQueenBlack().toString());
		assertEquals("k", Piece.createKingWhite().toString());
		assertEquals("K", Piece.createKingBlack().toString());
	}
	
	public void testColor() {
		Piece p1 = Piece.createKingWhite();
		assertEquals(WHITE_COLOR_STR, p1.getColorString());
		assertTrue(p1.isWhite());
		assertFalse(p1.isBlack());
		
		Piece p2 = Piece.createKingBlack();
		assertEquals(BLACK_COLOR_STR, p2.getColorString());
		assertTrue(p2.isBlack());
		assertFalse(p2.isWhite());
	}
	
	public void testGetBaseStrength() {
		Piece p = null;
		p = Piece.createPawnBlack();
		assertEquals(1.0, p.getBaseStrength(), DELTA);
		p = Piece.createPawnWhite();
		assertEquals(1.0, p.getBaseStrength(), DELTA);
		p = Piece.createKnightBlack();
		assertEquals(2.5, p.getBaseStrength(), DELTA);
		p = Piece.createKnightWhite();
		assertEquals(2.5, p.getBaseStrength(), DELTA);
		p = Piece.createBishopBlack();
		assertEquals(3.0, p.getBaseStrength(), DELTA);
		p = Piece.createBishopWhite();
		assertEquals(3.0, p.getBaseStrength(), DELTA);
		p = Piece.createRookBlack();
		assertEquals(5.0, p.getBaseStrength(), DELTA);
		p = Piece.createRookWhite();
		assertEquals(5.0, p.getBaseStrength(), DELTA);
		p = Piece.createQueenBlack();
		assertEquals(9.0, p.getBaseStrength(), DELTA);
		p = Piece.createQueenWhite();
		assertEquals(9.0, p.getBaseStrength(), DELTA);
		p = Piece.createKingBlack();
		assertEquals(0.0, p.getBaseStrength(), DELTA);
		p = Piece.createKingWhite();
		assertEquals(0.0, p.getBaseStrength(), DELTA);
	}
}
