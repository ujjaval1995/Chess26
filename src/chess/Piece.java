package chess;

public abstract class Piece
{
	private String color;
	
	Piece(String color)
	{
		if (color.equals("white"))
		{
			this.color = color;
		}
		else
		{
			this.color = "black";
		}
	}
	
	public String toString()
	{
		if (this.color.equals("white"))
		{
			return "w";
		}
		else
		{
			return "b";
		}
	}
	
	public String getColor()
	{
		if (this.color.equals("white"))
		{
			return "white";
		}
		else
		{
			return "black";
		}
	}
	
	public String getOtherColor()
	{
		if (this.color.equals("white"))
		{
			return "black";
		}
		else
		{
			return "white";
		}
	}
	
	public boolean hasColor(String color)
	{
		if (this.color.equals(color))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public abstract boolean move(String input);
	
	public boolean move_straight(String input)
	{
		int col1 = Board.file_to_col(input.charAt(0));
		int row1 = Board.rank_to_row(input.charAt(1));
		int col2 = Board.file_to_col(input.charAt(3));
		int row2 = Board.rank_to_row(input.charAt(4));
		
		if (row1 == row2 && col1 != col2) // horizontal
		{
			int min = Math.min(col1, col2);
			int max = Math.max(col1, col2);
			for (int i=min+1; i<max; i++) // clear path
			{
				if (Board.board[row1][i] != null)
				{
					return false;
				}
			}
			if (Board.board[row2][col2] == null) // move
			{
				Board.board[row1][col1] = null;
				Board.board[row2][col2] = this;
				if (Board.check(color))
				{
					Board.board[row1][col1] = this;
					Board.board[row2][col2] = null;
					return false;
				}
				else
				{
					return true;
				}
			}
			else if (!Board.board[row2][col2].hasColor(color)) // capture
			{
				Piece piece = Board.board[row2][col2];
				Board.board[row1][col1] = null;
				Board.board[row2][col2] = this;
				if (Board.check(color))
				{
					Board.board[row1][col1] = this;
					Board.board[row2][col2] = piece;
					return false;
				}
				else
				{
					return true;
				}
			}
			
		}
		else if (row1 != row2 && col1 == col2) // vertical
		{
			int min = Math.min(row1, row2);
			int max = Math.max(row1, row2);
			for (int i=min+1; i<max; i++) // clear path
			{
				if (Board.board[i][col1] != null)
				{
					return false;
				}
			}
			if (Board.board[row2][col2] == null) // move
			{
				Board.board[row1][col1] = null;
				Board.board[row2][col2] = this;
				if (Board.check(color))
				{
					Board.board[row1][col1] = this;
					Board.board[row2][col2] = null;
					return false;
				}
				else
				{
					return true;
				}
			}
			else if (!Board.board[row2][col2].hasColor(color)) // capture
			{
				Piece piece = Board.board[row2][col2];
				Board.board[row1][col1] = null;
				Board.board[row2][col2] = this;
				if (Board.check(color))
				{
					Board.board[row1][col1] = this;
					Board.board[row2][col2] = piece;
					return false;
				}
				else
				{
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean move_diagonal(String input)
	{
		return false;
	}
}
