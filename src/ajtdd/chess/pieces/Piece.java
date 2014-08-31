package ajtdd.chess.pieces;

public class Piece {
	public static final String WHITE_COLOR = "white";
	public static final String BLACK_COLOR = "black";
	
	final private String color;
	
	public Piece(String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}
}
