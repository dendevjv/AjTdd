package ajtdd.chess.pieces;

import static ajtdd.chess.pieces.PieceConstants.*;

public class Piece implements Comparable<Piece> {
	public enum Type {
		Bishop(BISHOP_REPRESENTATION, BISHOP_BASIC_STRENGTH), 
		King(KING_REPRESENTATION, KING_BASIC_STRENGTH), 
		Knight(KNIGHT_REPRESENTATION, KNIGHT_BASIC_STRENGTH), 
		NoPiece(NO_PIECE_REPRESENTATION, 0.0), 
		Pawn(PAWN_REPRESENTATION, PAWN_BASIC_STRENGTH), 
		Queen(QUEEN_REPRESENTATION, QUEEN_BASIC_STRENGTH),
		Rook(ROOK_REPRESENTATION, ROOK_BASIC_STRENGTH);
		
		private String representation;
		private double baseStrength;
		
		Type(String representation, double baseStrength) {
			this.representation = representation;
			this.baseStrength = baseStrength;
		}
		
		String getRepresentation() {
			return representation;
		}
		
		double getBaseStrength() {
			return baseStrength;
		}
	}

	private enum Color {
		Black, White
	}

	public static Piece createBishopBlack() {
		return createBlack(Type.Bishop);
	}

	public static Piece createBishopWhite() {
		return createWhite(Type.Bishop);
	}

	public static Piece createKingBlack() {
		return createBlack(Type.King);
	}

	public static Piece createKingWhite() {
		return createWhite(Type.King);
	}

	public static Piece createKnightBlack() {
		return createBlack(Type.Knight);
	}

	public static Piece createKnightWhite() {
		return createWhite(Type.Knight);
	}

	public static Piece createPawnBlack() {
		return createBlack(Type.Pawn);
	}

	public static Piece createPawnWhite() {
		return createWhite(Type.Pawn);
	}

	public static Piece createQueenBlack() {
		return createBlack(Type.Queen);
	}

	public static Piece createQueenWhite() {
		return createWhite(Type.Queen);
	}

	public static Piece createRookBlack() {
		return createBlack(Type.Rook);
	}

	public static Piece createRookWhite() {
		return createWhite(Type.Rook);
	}

	public static Piece noPiece() {
		return new Piece(null, Type.NoPiece);
	}

	private static Piece createBlack(Type type) {
		return new Piece(Color.Black, type);
	}

	private static Piece createWhite(Type type) {
		return new Piece(Color.White, type);
	}

	final private Color color;

	private double strength;

	final private Type type;

	private Piece(Color color, Type name) {
		this.color = color;
		this.type = name;
	}

	@Override
	public int compareTo(Piece o) {
		// reversed compare for decreasing sorting
		return Double.compare(o.strength, strength);
	}

	public double getBaseStrength() {
		return getType().getBaseStrength();
	}

	public String getColorString() {
		if (color == Color.White) {
			return WHITE_COLOR_STR;
		} else {
			return BLACK_COLOR_STR;
		}
	}

	public String getName() {
		switch (type) {
		case Bishop:
			return BISHOP_NAME;
		case King:
			return KING_NAME;
		case Knight:
			return KNIGHT_NAME;
		case Pawn:
			return PAWN_NAME;
		case Queen:
			return QUEEN_NAME;
		case Rook:
			return ROOK_NAME;
		case NoPiece:
			return NO_PIECE_REPRESENTATION;
		default:
			throw new IllegalStateException("Invalid piece type");
		}
	}

	public double getStrength() {
		return strength;
	}

	public Type getType() {
		return type;
	}

	public boolean isBlack() {
		return color == Color.Black;
	}

	public boolean isWhite() {
		return color == Color.White;
	}

	public void setStrength(double strength) {
		this.strength = strength;
	}

	@Override
	public String toString() {
		String s = getRepresentation();
		return s;
	}

	String getRepresentation() {
		String s = this.getType().getRepresentation();
		if (isWhite()) {
			s = s.toLowerCase();
		}
		return s;
	}
}
