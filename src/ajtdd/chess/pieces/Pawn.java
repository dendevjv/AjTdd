package ajtdd.chess.pieces;

/**
 * Represents a pawn in a chess game.
 */
public class Pawn extends Piece {
	private static final String WHITE_REPRESENTATION = "p";
	private static final String BLACK_REPRESENTATION = "P";
	
	public Pawn() {
		super(WHITE_COLOR);
	}

	public Pawn(String color) {
		super(color);
	}

	@Override
	public String toString() {
		if (BLACK_COLOR.equals(getColor())) {
			return BLACK_REPRESENTATION;
		} else if (WHITE_COLOR.equals(getColor())) {
			return WHITE_REPRESENTATION;
		}
		throw new IllegalStateException("Invalid value of field color");
	}
}
