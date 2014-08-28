package ajtdd.chess;

import java.util.List;

import ajtdd.chess.pieces.Pawn;

import junit.framework.TestCase;

public class BoardTest extends TestCase {
	private Board board;
	
	public void setUp() {
		board = new Board();
	}
	
	public void testCreate() {
		assertEquals(0, board.getNumberOfPieces());
		
		Pawn pawnBlack = new Pawn(Pawn.BLACK_COLOR);
		board.add(pawnBlack);
		List<Pawn> list = board.getListOfPawns();
		assertEquals(1, board.getNumberOfPieces());
		assertEquals(pawnBlack, list.get(0));
		
		Pawn pawnWhite = new Pawn();
		board.add(pawnWhite);
		assertEquals(2, board.getNumberOfPieces());
		assertEquals(pawnWhite, list.get(1));
		assertEquals(pawnBlack, list.get(0));
	}
}
