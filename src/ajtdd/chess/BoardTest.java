package ajtdd.chess;

import static ajtdd.chess.Board.NL;

import java.util.List;

import ajtdd.chess.pieces.Piece;
import junit.framework.TestCase;

public class BoardTest extends TestCase {
	private static final double DELTA = 1e-14;
	private Board board;
	
	public void setUp() {
		board = new Board();
	}
	
	public void testCreate() {
		assertEquals(32, board.getNumberOfPieces());

		String actualBoard = board.toString();
//		printBoard(actualBoard);
		assertEquals(contructExpected(), actualBoard);
	}
	
	public void testPossibleMovesOfKing() {
		int r, c;
		board.setEmpty();
		r = 3; c = 2;
		board.setPiece(r, c, Piece.createKingBlack());
		Move[] moves = board.getPossibleMoves(r, c);
		Move[] expectedMoves = new Move[] {
			new Move(4,2), new Move(4,3), new Move(3,3), new Move(2,3),
			new Move(2,2), new Move(2,1), new Move(3,1), new Move(4,1)
		};
		assertEqualArraysAsSets(expectedMoves, moves);
		/*
		 * 41 42 43
		 * 31 32 33
		 * 21 22 23
		 * 11 12 13
		 */
		r = 1; c = 1;
		board.setPiece(r, c, Piece.createKingBlack());
		moves = board.getPossibleMoves(r, c);
		expectedMoves = new Move[] {
			new Move(2,1), new Move(2,2), new Move(1,2)
		};
		assertEqualArraysAsSets(expectedMoves, moves);
		/*
		 * 81 82 83 84 85 86 87 88
		 * 7                 77 78
		 * 6
		 * 5
		 * 4
		 * 3
		 * 2
		 * 1
		 */
		r = 8; c = 8;
		board.setPiece(r, c, Piece.createKingBlack());
		moves = board.getPossibleMoves(r, c);
		expectedMoves = new Move[] {
				new Move(8,7), new Move(7,7), new Move(7,8)
		};
		assertEqualArraysAsSets(expectedMoves, moves);
	}
	
	/**
	 * Asserts that array of expected values contains the same element 
	 * that array of actual values provided all elements are unique. 
	 * @param expectedMoves array of unique elements
	 * @param actualMoves array of unique elements
	 */
	private void assertEqualArraysAsSets(Move[] expectedMoves, Move[] actualMoves) {
		assertEquals("Lengths of arrays do not match", expectedMoves.length, actualMoves.length);
		for (int i = 0; i < expectedMoves.length; i++) {
			boolean contains = false;
			for (int j = 0; j < actualMoves.length; j++) {
				if (actualMoves[j].equals(expectedMoves[i])) {
					contains = true;
					break;
				}
			}
			assertTrue(contains);
		}
	}

	public void testSetPieceIntInt() {
		board.setEmpty();
		board.setPiece(1, 2, Piece.createKingBlack());
		board.setPiece(1, 3, Piece.createRookBlack());
		assertEquals(
				  "........" + NL
				+ "........" + NL
				+ "........" + NL
				+ "........" + NL
				+ "........" + NL
				+ "........" + NL
				+ "........" + NL
				+ ".KR....." + NL
				, board.toString());
		board.setPiece(2, 1, Piece.createPawnBlack());
		board.setPiece(2, 3, Piece.createPawnBlack());
		board.setPiece(2, 4, Piece.createBishopBlack());
		board.setPiece(3, 2, Piece.createPawnBlack());
		board.setPiece(3, 5, Piece.createQueenBlack());
		assertEquals(
				  "........" + NL
				+ "........" + NL
				+ "........" + NL
				+ "........" + NL
				+ "........" + NL
				+ ".P..Q..." + NL
				+ "P.PB...." + NL
				+ ".KR....." + NL
				, board.toString());
		board.setPiece(5, 6, Piece.createKnightWhite());
		board.setPiece(5, 7, Piece.createQueenWhite());
		board.setPiece(6, 6, Piece.createPawnWhite());
		board.setPiece(7, 7, Piece.createPawnWhite());
		board.setPiece(8, 6, Piece.createKingWhite());
		board.setPiece(8, 5, Piece.createRookWhite());
		assertEquals(
				  "....rk.." + NL
				+ "......p." + NL
				+ ".....p.." + NL
				+ ".....nq." + NL
				+ "........" + NL
				+ ".P..Q..." + NL
				+ "P.PB...." + NL
				+ ".KR....." + NL
				, board.toString());
		
		assertEquals(1, board.getNumberOfBlackPieces(Piece.Type.King));
		assertEquals(1, board.getNumberOfBlackPieces(Piece.Type.Rook));
		assertEquals(1, board.getNumberOfBlackPieces(Piece.Type.Bishop));
		assertEquals(1, board.getNumberOfBlackPieces(Piece.Type.Queen));
		assertEquals(3, board.getNumberOfBlackPieces(Piece.Type.Pawn));
		
		assertEquals(1, board.getNumberOfWhitePieces(Piece.Type.Knight));
		assertEquals(1, board.getNumberOfWhitePieces(Piece.Type.Queen));
		assertEquals(1, board.getNumberOfWhitePieces(Piece.Type.King));
		assertEquals(1, board.getNumberOfWhitePieces(Piece.Type.Rook));
		assertEquals(2, board.getNumberOfWhitePieces(Piece.Type.Pawn));
	}
	
	public void testSetPieceString() {
		board.setEmpty();
		board.setPiece("b1", Piece.createKingBlack());
		board.setPiece("c1", Piece.createRookBlack());
		assertEquals(
				  "........" + NL
				+ "........" + NL
				+ "........" + NL
				+ "........" + NL
				+ "........" + NL
				+ "........" + NL
				+ "........" + NL
				+ ".KR....." + NL
				, board.toString());
		board.setPiece("a2", Piece.createPawnBlack());
		board.setPiece("c2", Piece.createPawnBlack());
		board.setPiece("d2", Piece.createBishopBlack());
		board.setPiece("b3", Piece.createPawnBlack());
		board.setPiece("e3", Piece.createQueenBlack());
		assertEquals(
				  "........" + NL
				+ "........" + NL
				+ "........" + NL
				+ "........" + NL
				+ "........" + NL
				+ ".P..Q..." + NL
				+ "P.PB...." + NL
				+ ".KR....." + NL
				, board.toString());
		board.setPiece("f5", Piece.createKnightWhite());
		board.setPiece("g5", Piece.createQueenWhite());
		board.setPiece("f6", Piece.createPawnWhite());
		board.setPiece("g7", Piece.createPawnWhite());
		board.setPiece("f8", Piece.createKingWhite());
		board.setPiece("e8", Piece.createRookWhite());
		assertEquals(
				  "....rk.." + NL
				+ "......p." + NL
				+ ".....p.." + NL
				+ ".....nq." + NL
				+ "........" + NL
				+ ".P..Q..." + NL
				+ "P.PB...." + NL
				+ ".KR....." + NL
				, board.toString());
		
		assertEquals(1, board.getNumberOfBlackPieces(Piece.Type.King));
		assertEquals(1, board.getNumberOfBlackPieces(Piece.Type.Rook));
		assertEquals(1, board.getNumberOfBlackPieces(Piece.Type.Bishop));
		assertEquals(1, board.getNumberOfBlackPieces(Piece.Type.Queen));
		assertEquals(3, board.getNumberOfBlackPieces(Piece.Type.Pawn));
		
		assertEquals(1, board.getNumberOfWhitePieces(Piece.Type.Knight));
		assertEquals(1, board.getNumberOfWhitePieces(Piece.Type.Queen));
		assertEquals(1, board.getNumberOfWhitePieces(Piece.Type.King));
		assertEquals(1, board.getNumberOfWhitePieces(Piece.Type.Rook));
		assertEquals(2, board.getNumberOfWhitePieces(Piece.Type.Pawn));
	}
	
	public void testSetEmpty() {
		assertEquals(32, board.getNumberOfPieces());
		board.setEmpty();
		assertEquals(0, board.getNumberOfPieces());
		assertEquals("........" + NL
				+ "........" + NL
				+ "........" + NL
				+ "........" + NL
				+ "........" + NL
				+ "........" + NL
				+ "........" + NL
				+ "........" + NL
				, board.toString());
	}
	
	public void testGetPiece() {
		assertPiece(Piece.createRookBlack(), board.getPieceAt("a8"));
		assertPiece(Piece.createKingWhite(), board.getPieceAt("e1"));
	}
	
	private void assertPiece(Piece expected, Piece actual) {
		assertNotNull(actual);
		assertEquals(expected.getColorString(), actual.getColorString());
		assertEquals(expected.getType(), actual.getType());
	}

	public void testNumberOfWhitePieces() {
		assertEquals(8, board.getNumberOfWhitePieces(Piece.Type.Pawn));
		assertEquals(2, board.getNumberOfWhitePieces(Piece.Type.Rook));
		assertEquals(2, board.getNumberOfWhitePieces(Piece.Type.Bishop));
		assertEquals(2, board.getNumberOfWhitePieces(Piece.Type.Knight));
		assertEquals(1, board.getNumberOfWhitePieces(Piece.Type.King));
		assertEquals(1, board.getNumberOfWhitePieces(Piece.Type.Queen));
	}
	
	public void testNumberOfBlackPieces() {
		assertEquals(8, board.getNumberOfBlackPieces(Piece.Type.Pawn));
		assertEquals(2, board.getNumberOfBlackPieces(Piece.Type.Rook));
		assertEquals(2, board.getNumberOfBlackPieces(Piece.Type.Bishop));
		assertEquals(2, board.getNumberOfBlackPieces(Piece.Type.Knight));
		assertEquals(1, board.getNumberOfBlackPieces(Piece.Type.King));
		assertEquals(1, board.getNumberOfBlackPieces(Piece.Type.Queen));
	}

	public void testStrengthOfBlackPieces() {
		board.setEmpty();
		board.setPiece("b8", Piece.createKingBlack());
		assertStrengthOfBlack(0.0);
		
		board.setPiece("c8", Piece.createRookBlack());
		assertStrengthOfBlack(5.0);
		
		board.setPiece("a7", Piece.createPawnBlack());
		assertStrengthOfBlack(6.0);
		
		board.setPiece("c7", Piece.createPawnBlack());
		assertStrengthOfBlack(7.0);
		
		board.setPiece("d7", Piece.createBishopBlack());
		assertStrengthOfBlack(10.0);
		
		board.setPiece("b6", Piece.createPawnBlack());
		assertStrengthOfBlack(11.0);
		
		board.setPiece("e6", Piece.createQueenBlack());
		assertStrengthOfBlack(20.0);
	}
	
	public void testStrengthOfWhitePieces() {
		board.setEmpty();
		board.setPiece("e1", Piece.createRookWhite());
		assertStrengthOfWhite(5.0);
		
		board.setPiece("f1", Piece.createKingWhite());
		assertStrengthOfWhite(5.0);
		
		board.setPiece("f2", Piece.createPawnWhite());
		assertStrengthOfWhite(6.0);
		
		board.setPiece("g2", Piece.createPawnWhite());
		assertStrengthOfWhite(7.0);
		
		board.setPiece("f3", Piece.createPawnWhite());
		assertStrengthOfWhite(7.0);
		
		board.setPiece("h3", Piece.createPawnWhite());
		assertStrengthOfWhite(8.0);
		
		board.setPiece("f4", Piece.createKnightWhite());
		assertStrengthOfWhite(10.5);
		
		board.setPiece("g4", Piece.createQueenWhite());
		assertStrengthOfWhite(19.5);
	}
	
	public void testAssignStrengthToPieces() {
		Piece whiteRook = board.getPieceAt("a1");
		Piece blackRook = board.getPieceAt("h8");
		Piece blackKnight = board.getPieceAt("b8");
		Piece whitePawn = board.getPieceAt("e2");
		Piece whiteQueen = board.getPieceAt("d1");
		Piece blackKing = board.getPieceAt("e8");
		Piece whiteBishop = board.getPieceAt("f1");
		
		assertEquals(0.0, whiteRook.getStrength());
		assertEquals(0.0, blackRook.getStrength());
		assertEquals(0.0, blackKnight.getStrength());
		assertEquals(0.0, whitePawn.getStrength());
		assertEquals(0.0, whiteQueen.getStrength());
		assertEquals(0.0, blackKing.getStrength());
		assertEquals(0.0, whiteBishop.getStrength());
		
		board.assignStrengthToPieces();

		assertEquals(5.0, whiteRook.getStrength());
		assertEquals(5.0, blackRook.getStrength());
		assertEquals(2.5, blackKnight.getStrength());
		assertEquals(1.0, whitePawn.getStrength());
		assertEquals(9.0, whiteQueen.getStrength());
		assertEquals(0.0, blackKing.getStrength());
		assertEquals(3.0, whiteBishop.getStrength());
	}
	
	public void testGetBlackPieces() {
		board.setEmpty();
		List<Piece> blacks = board.getBlackPieces();
		assertTrue(listIsStrengthNonIncreasing(blacks));
		
		board.setPiece("a8", Piece.createRookBlack());
		board.assignStrengthToPieces();
		assertTrue(listIsStrengthNonIncreasing(blacks));
		
		board.setPiece("b8", Piece.createKnightBlack());
		board.assignStrengthToPieces();
		assertTrue(listIsStrengthNonIncreasing(blacks));
		
		board.setPiece("c8", Piece.createBishopBlack());
		board.assignStrengthToPieces();
		assertTrue(listIsStrengthNonIncreasing(blacks));
		
		board.setPiece("d8", Piece.createKingBlack());
		board.assignStrengthToPieces();
		assertTrue(listIsStrengthNonIncreasing(blacks));
		
		board.setPiece("e8", Piece.createQueenBlack());
		board.assignStrengthToPieces();
		assertTrue(listIsStrengthNonIncreasing(blacks));
		
		board.setPiece("h7", Piece.createPawnBlack());
		board.assignStrengthToPieces();
		assertTrue(listIsStrengthNonIncreasing(blacks));
	}
	
	public void testGetWhitePieces() {
		board.setEmpty();
		List<Piece> whites = board.getWhitePieces();
		assertTrue(listIsStrengthNonIncreasing(whites));
		
		board.setPiece("a8", Piece.createRookWhite());
		board.assignStrengthToPieces();
		assertTrue(listIsStrengthNonIncreasing(whites));
		
		board.setPiece("b8", Piece.createKnightWhite());
		board.assignStrengthToPieces();
		assertTrue(listIsStrengthNonIncreasing(whites));
		
		board.setPiece("c8", Piece.createBishopWhite());
		board.assignStrengthToPieces();
		assertTrue(listIsStrengthNonIncreasing(whites));
		
		board.setPiece("d8", Piece.createKingWhite());
		board.assignStrengthToPieces();
		assertTrue(listIsStrengthNonIncreasing(whites));
		
		board.setPiece("e8", Piece.createQueenWhite());
		board.assignStrengthToPieces();
		assertTrue(listIsStrengthNonIncreasing(whites));
		
		board.setPiece("h7", Piece.createPawnWhite());
		board.assignStrengthToPieces();
		assertTrue(listIsStrengthNonIncreasing(whites));
	}
	
	private boolean listIsStrengthNonIncreasing(List<Piece> pieces) {
//		System.out.println(pieces);
		if (pieces.size() <= 1) {
			return true;
		}
		for (int i = 1; i < pieces.size(); i++) {
//			System.out.printf("%.1f ? %.1f ;", pieces.get(i - 1).getStrength(), pieces.get(i).getStrength());
			if (pieces.get(i - 1).getStrength() <  pieces.get(i).getStrength()) {
				return false;
			}
		}
//		System.out.println();
		return true;
	}

	private void assertStrengthOfBlack(double expected) {
		assertEquals(expected, board.strengthOfBlackPieces(), DELTA);
	}

	private void assertStrengthOfWhite(double expected) {
		assertEquals(expected, board.strengthOfWhitePieces(), DELTA);
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
