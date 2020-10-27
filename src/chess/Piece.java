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
	
	// COMPLETE
	// add boolean parameter in all move functions for move vs can_move
	// change (String input) to (int row1, int col1, int row2, int col2) where possible
	
	public abstract boolean move(String input);
	
	public boolean regular_move(int row1, int col1, int row2, int col2)
	{
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
		else
		{
			return false;
		}
	}
	
	public boolean capture_move(int row1, int col1, int row2, int col2)
	{		
		if (!Board.board[row2][col2].hasColor(color)) // capture
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
		else
		{
			return false;
		}
	}
	
	public boolean move_straight(String input)
	{
		int col1 = Board.file_to_col(input.charAt(0));
		int row1 = Board.rank_to_row(input.charAt(1));
		int col2 = Board.file_to_col(input.charAt(3));
		int row2 = Board.rank_to_row(input.charAt(4));
		
		if (row1 == row2 && col1 == col2) // same
		{
			return false;
		}
		else if (row1 == row2 && col1 != col2) // horizontal
		{
			int min = Math.min(col1, col2);
			int max = Math.max(col1, col2);
			for (int j=min+1; j<max; j++) // clear path
			{
				if (Board.board[row1][j] != null)
				{
					return false;
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
		}
		else // not same, horizontal, vertical
		{
			return false;
		}
		return (regular_move(row1, col1, row2, col2) || capture_move(row1, col1, row2, col2));
	}
	
	public boolean move_diagonal(String input)
	{
		int col1 = Board.file_to_col(input.charAt(0));
		int row1 = Board.rank_to_row(input.charAt(1));
		int col2 = Board.file_to_col(input.charAt(3));
		int row2 = Board.rank_to_row(input.charAt(4));
		
		if (row1 == row2 || col1 == col2) // same, horizontal, vertical
		{
			return false;
		}
		else if (row1 + col1 == row2 + col2) // diagonal /
		{
			int minrow = Math.min(row1, row2);
			if (row1 == minrow) // down-left
			{
				for (int i=row1+1, j=col1-1; i<row2; i++, j--) // clear path
				{
					if (Board.board[i][j] != null)
					{
						return false;
					}
				}
			}
			else // up-right
			{
				for (int i=row2+1, j=col2-1; i<row1; i++, j--) // clear path
				{
					if (Board.board[i][j] != null)
					{
						return false;
					}
				}
			}
		}
		else if (row1 + (7-col1) == row2 + (7-col2)) // diagonal \
		{
			int minrow = Math.min(row1, row2);
			if (row1 == minrow) // down-right
			{
				for (int i=row1+1, j=col1+1; i<row2; i++, j++) // clear path
				{
					if (Board.board[i][j] != null)
					{
						return false;
					}
				}
			}
			else // up-left
			{
				for (int i=row2+1, j=col2+1; i<row1; i++, j++) // clear path
				{
					if (Board.board[i][j] != null)
					{
						return false;
					}
				}
			}
		}
		else // not same, horizontal, vertical, diagonal
		{
			return false;
		}
		return (regular_move(row1, col1, row2, col2) || capture_move(row1, col1, row2, col2));
	}
}
