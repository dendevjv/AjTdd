package ajtdd.chess.pieces;

public class Piece {
	public static final String BISHOP_NAME = "Bishop";
	public static final String BLACK_COLOR = "black";
	public static final String KING_NAME = "King";
	public static final String KNIGHT_NAME = "Knight";
	public static final String PAWN_NAME = "Pawn";
	public static final String QUEEN_NAME = "Queen";
	public static final String ROOK_NAME = "Rook";
	public static final String WHITE_COLOR = "white";
	private static final String BISHOP_REPRESENTATION = "B";
	private static final String KING_REPRESENTATION = "K";
	private static final String KNIGHT_REPRESENTATION = "N";
	private static final String PAWN_REPRESENTATION = "P";
	private static final String QUEEN_REPRESENTATION = "Q";
	private static final String ROOK_REPRESENTATION = "R";

	public static Piece createBishopBlack() {
		return new Piece(Piece.BLACK_COLOR, Piece.BISHOP_NAME);
	}

	public static Piece createBishopWhite() {
		return new Piece(Piece.WHITE_COLOR, Piece.BISHOP_NAME);
	}

	public static Piece createKingBlack() {
		return new Piece(Piece.BLACK_COLOR, Piece.KING_NAME);
	}

	public static Piece createKingWhite() {
		return new Piece(Piece.WHITE_COLOR, Piece.KING_NAME);
	}

	public static Piece createKnightBlack() {
		return new Piece(Piece.BLACK_COLOR, Piece.KNIGHT_NAME);
	}

	public static Piece createKnightWhite() {
		return new Piece(Piece.WHITE_COLOR, Piece.KNIGHT_NAME);
	}

	public static Piece createPawnBlack() {
		return new Piece(Piece.BLACK_COLOR, PAWN_NAME);
	}

	public static Piece createPawnWhite() {
		return new Piece(Piece.WHITE_COLOR, PAWN_NAME);
	}

	public static Piece createQueenBlack() {
		return new Piece(Piece.BLACK_COLOR, Piece.QUEEN_NAME);
	}

	public static Piece createQueenWhite() {
		return new Piece(Piece.WHITE_COLOR, Piece.QUEEN_NAME);
	}

	public static Piece createRookBlack() {
		return new Piece(Piece.BLACK_COLOR, Piece.ROOK_NAME);
	}

	public static Piece createRookWhite() {
		return new Piece(Piece.WHITE_COLOR, Piece.ROOK_NAME);
	}

	final private String color;

	final private String name;

	private Piece(String color, String name) {
		this.color = color;
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public String getName() {
		return name;
	}

	public boolean isBlack() {
		return Piece.BLACK_COLOR.equals(color);
	}

	public boolean isWhite() {
		return Piece.WHITE_COLOR.equals(color);
	}

	@Override
	public String toString() {
		String s = null;
		if (name.equals(PAWN_NAME)) {
			s = PAWN_REPRESENTATION;
		} else if (name.equals(BISHOP_NAME)) {
			s = BISHOP_REPRESENTATION;
		} else if (name.equals(KING_NAME)) {
			s = KING_REPRESENTATION;
		} else if (name.equals(KNIGHT_NAME)) {
			s = KNIGHT_REPRESENTATION;
		} else if (name.equals(QUEEN_NAME)) {
			s = QUEEN_REPRESENTATION;
		} else if (name.equals(ROOK_NAME)) {
			s = ROOK_REPRESENTATION;
		} else {
			throw new IllegalStateException("Invalid name");
		}
		if (s != null && Piece.WHITE_COLOR.equals(color)) {
			s = s.toLowerCase();
		}
		return s;
	}
}
