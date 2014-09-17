package ajtdd.chess;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ajtdd.chess.pieces.Piece;
import ajtdd.chess.pieces.Piece.Type;

/**
 * Represents a chess board.
 */
public class Board {
	public static final String NL = System.getProperty("line.separator");
	private static final char EMPTY_CELL = '.';
	private static final int SIZE = 8;
	private Piece[][] pieces;
	private List<Piece> whitePieces;
	private List<Piece> blackPieces;

	public Board() {
		whitePieces = new ArrayList<>();
		blackPieces = new ArrayList<>();
		pieces = new Piece[SIZE][SIZE];
		initialize();
	}

	public void assignStrengthToPieces() {
		for (int i = 0; i < pieces.length; i++) {
			for (int j = 0; j < pieces[0].length; j++) {
				Piece p = pieces[i][j];
				if (p != null && p.getType() != Piece.Type.NoPiece) {
					p.setStrength(getStrengthOfPiece(p, j));
				}
			}
		}
		Collections.sort(blackPieces);
		Collections.sort(whitePieces);
	}

	public int getNumberOfBlackPieces(Piece.Type type) {
		int n = 0;
		for (int i = 0; i < pieces.length; i++) {
			for (int j = 0; j < pieces[0].length; j++) {
				Piece p = pieces[i][j];
				if (p != null && p.isBlack() && p.getType() == type) {
					n++;
				}
			}
		}
		return n;
	}

	public int getNumberOfPieces() {
		int numberOfPieces = 0;
		for (int i = 0; i < pieces.length; i++) {
			for (int j = 0; j < pieces[0].length; j++) {
				if (pieces[i][j] != null
						&& pieces[i][j].getType() != Piece.Type.NoPiece) {
					numberOfPieces++;
				}
			}
		}
		return numberOfPieces;
	}

	public int getNumberOfWhitePieces(Piece.Type type) {
		int n = 0;
		for (int i = 0; i < pieces.length; i++) {
			for (int j = 0; j < pieces[0].length; j++) {
				Piece p = pieces[i][j];
				if (p != null && p.isWhite() && p.getType() == type) {
					n++;
				}
			}
		}
		return n;
	}

	/**
	 * Retrieves the piece at a given location such as "a8" or "e1".
	 * 
	 * @param location
	 *            string where 1st char represents column (from 'a' to 'h') and
	 *            2nd char represents rank (from 1 to 8)
	 * @return
	 */
	public Piece getPieceAt(String location) {
		if (location.length() != 2) {
			throw new IllegalArgumentException("location is not valid: "
					+ location);
		}
		char fileChar = location.charAt(0);
		char rankChar = location.charAt(1);
		int columnIndex = (int) (fileChar - 'a');
		int rowIndex = (int) (rankChar - '0') - 1;
		return pieces[rowIndex][columnIndex];
	}

	/**
	 * Gets rank (horizontal line) designated by specified index.
	 * 
	 * @param rankIndex
	 *            index from 1 (bottom) to 8 (top)
	 * @return string representing rank of board
	 */
	public String getRank(int rankIndex) {
		int row = rankIndex - 1;
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

	public void setEmpty() {
		for (int i = 0; i < pieces.length; i++) {
			for (int j = 0; j < pieces[0].length; j++) {
				pieces[i][j] = Piece.noPiece();
			}
		}
		blackPieces.clear();
		whitePieces.clear();
	}

	/**
	 * Sets piece at specified location on board.
	 * 
	 * @param rank
	 *            from 1 to 8 (top)
	 * @param col
	 *            from 1 to 8 (right)
	 * @param piece
	 */
	public void setPiece(int rank, int col, Piece piece) {
		int rowIndex = rank - 1;
		int colIndex = col - 1;
		pieces[rowIndex][colIndex] = piece;
		if (piece.isBlack()) {
			blackPieces.add(piece);
		} else if (piece.isWhite()) {
			whitePieces.add(piece);
		}
	}

	/**
	 * Sets piece at specified location on board.
	 * 
	 * @param location
	 *            string where 1st char represents column (from 'a' to 'h') and
	 *            2nd char represents rank (from 1 to 8)
	 * @param piece
	 */
	public void setPiece(String location, Piece piece) {
		if (location.length() != 2) {
			throw new IllegalArgumentException("location is not valid: "
					+ location);
		}
		char fileChar = location.charAt(0);
		char rankChar = location.charAt(1);
		int file = (int) (fileChar - 'a') + 1;
		int rank = (int) (rankChar - '0');
		setPiece(rank, file, piece);
	}
	
	public double strengthOfBlackPieces() {
		double strength = 0.0;
		for (int i = 0; i < pieces.length; i++) {
			for (int j = 0; j < pieces[0].length; j++) {
				if (pieces[i][j].isBlack()) {
					strength += getStrengthOfPiece(pieces[i][j], j);
				}
			}
		}
		return strength;
	}

	public double strengthOfWhitePieces() {
		double strength = 0.0;
		for (int i = 0; i < pieces.length; i++) {
			for (int j = 0; j < pieces[0].length; j++) {
				if (pieces[i][j].isWhite()) {
					strength += getStrengthOfPiece(pieces[i][j], j);
				}
			}
		}
		return strength;
	}
	
	public Move[] getPossibleMoves(int rank, int column) {
		ArrayList<Move> moves = new ArrayList<>();
		Piece p = pieces[rank - 1][column - 1];
		Piece.Type type = p.getType();
		
		Move origin = new Move(rank, column);
		if (type == Piece.Type.King) {
			Move next = null;
			int[] coordinates = {1, 0, 1, 1, 0, 1, -1, 1, -1, 0, -1, -1, 0, -1, 1, -1};
			for (int i = 0; i < coordinates.length; i += 2) {
				next = origin.make(coordinates[i], coordinates[i + 1]);
				if (isOnBoard(next)) {
					moves.add(next);
				}
			}
		}
		
		Move[] a = new Move[moves.size()];
		return moves.toArray(a);
	}
	
	private boolean isOnBoard(Move m) {
		int r = m.getRank();
		int c = m.getColumn();
		if (r < 1 || r > SIZE || c < 1 || c > SIZE) {
			return false;
		}
		return true;
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

	private boolean columnContainsMoreSamePieces(int col, Piece piece) {
		int count = 0;
		for (int row = 0; row < SIZE; row++) {
			Piece p = pieces[row][col];
			if (p.getType().equals(piece.getType())
					&& p.getColorString().equals(piece.getColorString())) {
				count++;
			}
		}
		return count > 1;
	}

	private double getStrengthOfPiece(Piece piece, int columnIndex) {
		double baseStrength = piece.getBaseStrength();
		if (piece.getType() == Type.Pawn && columnContainsMoreSamePieces(columnIndex, piece)) {
			return baseStrength / 2.0;
		}
		return baseStrength;
	}

	private void initialize() {
		int row = 0; // first row - bottom row = rank 1
		pieces[row][0] = Piece.createRookWhite();
		pieces[row][7] = Piece.createRookWhite();
		pieces[row][1] = Piece.createKnightWhite();
		pieces[row][6] = Piece.createKnightWhite();
		pieces[row][2] = Piece.createBishopWhite();
		pieces[row][5] = Piece.createBishopWhite();
		pieces[row][3] = Piece.createQueenWhite();
		pieces[row][4] = Piece.createKingWhite();

		row = 1; // second row
		for (int col = 0; col < SIZE; col++) {
			pieces[row][col] = Piece.createPawnWhite();
		}
		for (row = 2; row < 6; row++) {
			for (int col = 0; col < SIZE; col++) {
				pieces[row][col] = Piece.noPiece();
			}
		}
		row = 6; // seventh row
		for (int col = 0; col < SIZE; col++) {
			pieces[row][col] = Piece.createPawnBlack();
		}

		row = 7; // eighth row - top row = rank 8
		pieces[row][0] = Piece.createRookBlack();
		pieces[row][7] = Piece.createRookBlack();
		pieces[row][1] = Piece.createKnightBlack();
		pieces[row][6] = Piece.createKnightBlack();
		pieces[row][2] = Piece.createBishopBlack();
		pieces[row][5] = Piece.createBishopBlack();
		pieces[row][3] = Piece.createQueenBlack();
		pieces[row][4] = Piece.createKingBlack();
	}

	List<Piece> getBlackPieces() {
		return blackPieces;
	}

	public List<Piece> getWhitePieces() {
		return whitePieces;
	}
}
