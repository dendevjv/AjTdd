package ajtdd.chess;

import java.util.List;

import ajtdd.Debug;
import ajtdd.chess.pieces.Pawn;
import static ajtdd.chess.Board.NL;

import junit.framework.TestCase;

public class BoardTest extends TestCase {
	private Board board;
	
	public void setUp() {
		board = new Board();
	}
	
	public void testCreate() {
		Debug.log.info("BoardTest");
		
		assertEquals(16, board.getNumberOfPieces());
		
		String rank2 = board.getRank(2);
//		System.out.println(rank2);
		assertEquals("pppppppp", rank2);
		
		String rank7 = board.getRank(7);
//		System.out.println(rank7);
		assertEquals("PPPPPPPP", rank7);
		
		final String expectedBoard = "........" + NL
				+ "PPPPPPPP" + NL
				+ "........" + NL
				+ "........" + NL
				+ "........" + NL
				+ "........" + NL
				+ "pppppppp" + NL
				+ "........" + NL;
		String actualBoard = board.toString();
//		System.out.println();
//		System.out.println("--------");
//		System.out.println(actualBoard);
//		System.out.println("--------" + NL);
		assertEquals(expectedBoard, actualBoard);
		
//		Pawn pawnBlack = new Pawn(Pawn.BLACK_COLOR);
//		board.add(pawnBlack);
//		List<Pawn> list = board.getListOfPawns();
//		assertEquals(1, board.getNumberOfPieces());
//		assertEquals(pawnBlack, list.get(0));
//		
//		Pawn pawnWhite = new Pawn();
//		board.add(pawnWhite);
//		assertEquals(2, board.getNumberOfPieces());
//		assertEquals(pawnWhite, list.get(1));
//		assertEquals(pawnBlack, list.get(0));
	}

}
