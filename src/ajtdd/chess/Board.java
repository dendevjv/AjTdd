package ajtdd.chess;

import ajtdd.chess.pieces.Piece;

/**
 * Represents a chess board.
 */
public class Board {
	private static final char EMPTY_CELL = '.';
	private static final int SIZE = 8;
	public static final String NL = System.getProperty("line.separator");
	private int numberOfPieces = 0; 
	private Piece[][] pieces;
	
	public Board() {
		pieces = new Piece[SIZE][SIZE];
		initialize();
	}
	
	private void initialize() {
		int row = 0; // first row
		pieces[row][0] = Piece.createRookWhite();
		pieces[row][7] = Piece.createRookWhite();
		pieces[row][1] = Piece.createKnightWhite();
		pieces[row][6] = Piece.createKnightWhite();
		pieces[row][2] = Piece.createBishopWhite();
		pieces[row][5] = Piece.createBishopWhite();
		pieces[row][3] = Piece.createQueenWhite();
		pieces[row][4] = Piece.createKingWhite();
		numberOfPieces += 8;
		
		row = 1; // second row
		for (int col = 0; col < SIZE; col++) {
			Piece pawn = Piece.createPawnWhite();
			pieces[row][col] = pawn;
			numberOfPieces++;
		}
		row = 6; // seventh row
		for (int col = 0; col < SIZE; col++) {
			Piece pawn = Piece.createPawnBlack();
			pieces[row][col] = pawn;
			numberOfPieces++;;
		}
		
		row = 7; // eighth row
		pieces[row][0] = Piece.createRookBlack();
		pieces[row][7] = Piece.createRookBlack();
		pieces[row][1] = Piece.createKnightBlack();
		pieces[row][6] = Piece.createKnightBlack();
		pieces[row][2] = Piece.createBishopBlack();
		pieces[row][5] = Piece.createBishopBlack();
		pieces[row][3] = Piece.createQueenBlack();
		pieces[row][4] = Piece.createKingBlack();
		numberOfPieces += 8;
	}
	
	/**
	 * Gets rank (horizontal line) designated by specified index.
	 * @param i index (from 1 to 8)
	 * @return string representing rank of board
	 */
	public String getRank(int i) {
		int row = i - 1;
		StringBuilder sb = new StringBuilder();
		for (int col = 0; col < SIZE; col++) {
			Piece p = pieces[row][col];
			if (p == null) {
				sb.append(EMPTY_CELL);
			} else {
				sb.append(p.toString());
			}
		}
		return sb.toString();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int row = SIZE; row > 0; row--) {
			String rank = this.getRank(row);
			sb.append(rank);
			sb.append(NL);
		}
		return sb.toString();
	}

	public int getNumberOfPieces() {
		return numberOfPieces;
	}
}
