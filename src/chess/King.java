package chess;

public class King extends Piece
{
	King(String color)
	{
		super(color);
	}
	
	public String toString()
	{
		return super.toString() + "K";
	}

	public boolean move(String input, boolean modify)
	{
		int col1 = Board.file_to_col(input.charAt(0));
		int row1 = Board.rank_to_row(input.charAt(1));
		int col2 = Board.file_to_col(input.charAt(3));
		int row2 = Board.rank_to_row(input.charAt(4));
		return (move_1(row1, col1, row2, col2, modify) || castle(row1, col1, row2, col2, modify));
	}
	
	public boolean move_1(int row1, int col1, int row2, int col2, boolean modify)
	{
		
		if (row1 == row2 && col1 == col2) // same
		{
			return false;
		}
		else if (Math.abs(row1-row2) <= 1 && Math.abs(col1-col2) <= 1) // 1
		{
			return (regular_move(row1, col1, row2, col2, modify) || capture_move(row1, col1, row2, col2, modify));
		}
		else // not same, 1
		{
			return false;
		}
	}
	
	public boolean castle(int row1, int col1, int row2, int col2, boolean modify)
	{
		// COMPLETE
		return false;
	}
}
