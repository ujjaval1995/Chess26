package chess;

public class Pawn extends Piece
{
	boolean moved;
	
	Pawn(String color)
	{
		super(color);
		this.moved = false;
	}
	
	public String toString()
	{
		return super.toString() + "p";
	}

	public boolean move(String input)
	{
		int col1 = Board.file_to_col(input.charAt(0));
		int row1 = Board.rank_to_row(input.charAt(1));
		int col2 = Board.file_to_col(input.charAt(3));
		int row2 = Board.rank_to_row(input.charAt(4));
		
		if (this.color.equals("white"))
		{
			if (col1 == col2 && Board.board[row2][col2] == null) // regular
			{
				if (row1-1 == row2 && col1 == col2) // move 1
				{
					Board.board[row2][col2] = this;
					Board.board[row1][col1] = null;
					moved = true;
					return true;
				}
				else if (row1-2 == row2 && Board.board[row1-1][col2] == null && !moved) // move 2
				{
					Board.board[row2][col2] = this;
					Board.board[row1][col1] = null;
					moved = true;
					return true;
				}
			}
			else if (row1-1 == row2 && (col1-1 == col2 || col1+1 == col2) && Board.board[row2][col2] != null) // capture
			{
				Board.board[row2][col2] = this;
				Board.board[row1][col1] = null;
				moved = true;
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			if (col1 == col2 && Board.board[row2][col2] == null) // regular
			{
				if (row1+1 == row2 && col1 == col2) // move 1
				{
					Board.board[row2][col2] = this;
					Board.board[row1][col1] = null;
					moved = true;
					return true;
				}
				else if (row1+2 == row2 && Board.board[row1+1][col2] == null && !moved) // move 2
				{
					Board.board[row2][col2] = this;
					Board.board[row1][col1] = null;
					moved = true;
					return true;
				}
			}
			else if (row1+1 == row2 && (col1-1 == col2 || col1+1 == col2) && Board.board[row2][col2] != null) // capture
			{
				Board.board[row2][col2] = this;
				Board.board[row1][col1] = null;
				moved = true;
				return true;
			}
			else
			{
				return false;
			}
		}
		return false;
	}
}
