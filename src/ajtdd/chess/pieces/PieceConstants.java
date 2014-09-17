package ajtdd.chess.pieces;

public class PieceConstants {
	private PieceConstants() {}
	
	public static final String BLACK_COLOR_STR = "black";
	public static final String WHITE_COLOR_STR = "white";
	
	public static final String BISHOP_NAME = "Bishop";
	public static final String KING_NAME = "King";
	public static final String KNIGHT_NAME = "Knight";
	public static final String PAWN_NAME = "Pawn";
	public static final String QUEEN_NAME = "Queen";
	public static final String ROOK_NAME = "Rook";
	
	static final String BISHOP_REPRESENTATION = "B";
	static final String KING_REPRESENTATION = "K";
	static final String KNIGHT_REPRESENTATION = "N";
	static final String PAWN_REPRESENTATION = "P";
	static final String QUEEN_REPRESENTATION = "Q";
	static final String ROOK_REPRESENTATION = "R";
	static final String NO_PIECE_REPRESENTATION = ".";
	
	static final double PAWN_BASIC_STRENGTH = 1.0;
	static final double KNIGHT_BASIC_STRENGTH = 2.5;
	static final double BISHOP_BASIC_STRENGTH = 3.0;
	static final double ROOK_BASIC_STRENGTH = 5.0;
	static final double QUEEN_BASIC_STRENGTH = 9.0;
	static final double KING_BASIC_STRENGTH = 0.0;
}
