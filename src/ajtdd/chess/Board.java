package ajtdd.chess;

import java.util.ArrayList;
import java.util.List;

import ajtdd.chess.pieces.Pawn;
import ajtdd.chess.pieces.Piece;

/**
 * Represents a chess board.
 */
public class Board {
	private static final char EMPTY_CELL = '.';
	private static final int SIZE = 8;
	public static final String NL = System.getProperty("line.separator");
	private int numberOfPieces = 0; 
	private List<Pawn> listOfPawns;
	private Piece[][] pieces;
	
	public Board() {
		pieces = new Piece[SIZE][SIZE];
		listOfPawns = new ArrayList<Pawn>();
		initialize();
	}
	
	private void initialize() {
		int row;
		
		row = 1; // second row
		for (int col = 0; col < SIZE; col++) {
			Pawn pawn = new Pawn(Pawn.WHITE_COLOR);
			pieces[row][col] = pawn;
			add(pawn);
		}
		row = 6; // seventh row
		for (int col = 0; col < SIZE; col++) {
			Pawn pawn = new Pawn(Pawn.BLACK_COLOR);
			pieces[row][col] = pawn;
			add(pawn);
		}
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

	public void add(Pawn pawn) {
		listOfPawns.add(pawn);
		numberOfPieces++;
	}

	public List<Pawn> getListOfPawns() {
		return listOfPawns;
	}

}
