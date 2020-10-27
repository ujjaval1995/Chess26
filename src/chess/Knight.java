package chess;

public class Knight extends Piece
{
	Knight(String color)
	{
		super(color);
	}
	
	public String toString()
	{
		return super.toString() + "N";
	}

	public boolean move(String input)
	{
		return move_L(input);
	}
	
	public boolean move_L(String input)
	{
		int col1 = Board.file_to_col(input.charAt(0));
		int row1 = Board.rank_to_row(input.charAt(1));
		int col2 = Board.file_to_col(input.charAt(3));
		int row2 = Board.rank_to_row(input.charAt(4));
		
		if ((Math.abs(row1-row2) == 2 && Math.abs(col1-col2) == 1) || (Math.abs(row1-row2) == 1 && Math.abs(col1-col2) == 2)) // L
		{
			return (regular_move(row1, col1, row2, col2) || capture_move(row1, col1, row2, col2));
		}
		else // not L
		{
			return false;
		}
	}
}
