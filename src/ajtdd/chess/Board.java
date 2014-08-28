package ajtdd.chess;

import java.util.ArrayList;
import java.util.List;

import ajtdd.chess.pieces.Pawn;

/**
 * Represents a chess board.
 */
public class Board {
	private int numberOfPieces = 0; 
	private List<Pawn> listOfPawns;
	
	public Board() {
		listOfPawns = new ArrayList<Pawn>();
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
