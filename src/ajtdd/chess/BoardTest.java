package ajtdd.chess;

import static ajtdd.chess.Board.NL;
import junit.framework.TestCase;

public class BoardTest extends TestCase {
	private Board board;
	
	public void setUp() {
		board = new Board();
	}
	
	public void testCreate() {
		assertEquals(32, board.getNumberOfPieces());

		String expectedBoard = contructExpected();
		String actualBoard = board.toString();
//		printBoard(actualBoard);
		assertEquals(expectedBoard, actualBoard);
	}

	@SuppressWarnings("unused")
	private void printBoard(String actualBoard) {
		System.out.println();
		System.out.println("--------");
		System.out.print(actualBoard);
		System.out.println("--------");
	}

	private String contructExpected() {
		StringBuilder sb = new StringBuilder();
		sb.append("RNBQKBNR");
		sb.append(NL);
		sb.append("PPPPPPPP");
		sb.append(NL);
		sb.append("........");
		sb.append(NL);
		sb.append("........");
		sb.append(NL);
		sb.append("........");
		sb.append(NL);
		sb.append("........");
		sb.append(NL);
		sb.append("pppppppp");
		sb.append(NL);
		sb.append("rnbqkbnr");
		sb.append(NL);
		return sb.toString();
	}

}
