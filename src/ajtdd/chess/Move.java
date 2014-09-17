package ajtdd.chess;

import java.util.Objects;

public class Move {
	private int rank;
	private int column;
	
	public Move(String position) {
		char colCh = position.charAt(0);
		char rankCh = position.charAt(1);
		rank = rankCh - '0';
		column = colCh - 'a' + 1;
	}
	
	/**
	 * Creates a move to the specified location.
	 * @param rank rank of board from 1 to 8(top)
	 * @param column column of board from 1 to 8(right)
	 */
	public Move(int rank, int column) {
		this.rank = rank;
		this.column = column;
	}
	
	public Move make(int rankChange, int columnChange) {
		return new Move(rank + rankChange, column + columnChange);
	}
	
	public final int getRank() {
		return rank;
	}

	public final int getColumn() {
		return column;
	}

	@Override
	public String toString() {
		return String.valueOf((char)('a' - 1 + column)) + rank;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Move other = (Move) obj;
		return rank == other.rank && column == other.column;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(rank, column);
	}
}
