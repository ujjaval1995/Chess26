package chess;

public class Pawn extends Piece
{
	boolean moved;
	boolean enpassant;
	
	Pawn(String color)
	{
		super(color);
		this.moved = false;
		this.enpassant = false;
	}
	
	public String toString()
	{
		return super.toString() + "p";
	}

	public boolean move(String input, boolean modify)
	{
		int col1 = Board.file_to_col(input.charAt(0));
		int row1 = Board.rank_to_row(input.charAt(1));
		int col2 = Board.file_to_col(input.charAt(3));
		int row2 = Board.rank_to_row(input.charAt(4));
		// return move_forward(row1, col1, row2, col2, modify);
		
		if (this.hasColor("white"))
		{
			if (col1 == col2 && Board.board[row2][col2] == null) // move
			{
				if (row1-1 == row2) // move 1
				{
					Board.board[row1][col1] = null;
					Board.board[row2][col2] = this;
					if (row2 == 7)
					{
						if (promote(input, modify) == false)
						{
							return false;
						}
						else
						{
							return true;
						}
					}
					if (Board.check(this.getColor()))
					{
						Board.board[row1][col1] = this;
						Board.board[row2][col2] = null;
						return false;
					}
					else
					{
						moved = true;
						return true;
					}
				}
				else if (row1-2 == row2 && Board.board[row1-1][col2] == null && !moved) // move 2
				{
					Board.board[row1][col1] = null;
					Board.board[row2][col2] = this;
					if (Board.check(this.getColor()))
					{
						Board.board[row1][col1] = this;
						Board.board[row2][col2] = null;
						return false;
					}
					else
					{
						moved = true;
						enpassant = true;
						return true;
					}
				}
			}
			else if (row1-1 == row2 && (col1-1 == col2 || col1+1 == col2)) // capture
			{
				if (Board.board[row2][col2] == null) // en passant
				{
					Piece piece = Board.board[row1][col2];
					if (piece != null && piece instanceof Pawn)
					{
						Pawn pawn = (Pawn) piece;
						if (pawn.hasColor("black") && pawn.enpassant == true)
						{
							Board.board[row1][col1] = null;
							Board.board[row1][col2] = null;
							Board.board[row2][col2] = this;
							if (Board.check(this.getColor()))
							{
								Board.board[row1][col1] = this;
								Board.board[row1][col2] = piece;
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
				}
				else if (Board.board[row2][col2].hasColor("black")) // regular
				{
					Piece piece = Board.board[row2][col2];
					Board.board[row1][col1] = null;
					Board.board[row2][col2] = this;
					if (row2 == 7)
					{
						if (promote(input, modify) == false)
						{
							return false;
						}
						else
						{
							return true;
						}
					}
					if (Board.check(this.getColor()))
					{
						Board.board[row1][col1] = this;
						Board.board[row2][col2] = piece;
						return false;
					}
					else
					{
						moved = true;
						return true;
					}
				}
				else
				{
					return false;
				}
			}
		}
		else // black
		{
			if (col1 == col2 && Board.board[row2][col2] == null) // move
			{
				if (row1+1 == row2) // move 1
				{
					Board.board[row1][col1] = null;
					Board.board[row2][col2] = this;
					if (row2 == 0)
					{
						if (promote(input, modify) == false)
						{
							return false;
						}
						else
						{
							return true;
						}
					}
					if (Board.check(this.getColor()))
					{
						Board.board[row1][col1] = this;
						Board.board[row2][col2] = null;
						return false;
					}
					else
					{
						moved = true;
						return true;
					}
				}
				else if (row1+2 == row2 && Board.board[row1+1][col2] == null && !moved) // move 2
				{
					Board.board[row1][col1] = null;
					Board.board[row2][col2] = this;
					if (Board.check(this.getColor()))
					{
						Board.board[row1][col1] = this;
						Board.board[row2][col2] = null;
						return false;
					}
					else
					{
						moved = true;
						enpassant = true;
						return true;
					}
				}
			}
			else if (row1+1 == row2 && (col1-1 == col2 || col1+1 == col2)) // capture
			{
				if (Board.board[row2][col2] == null) // en passant
				{
					Piece piece = Board.board[row1][col2];
					if (piece != null && piece instanceof Pawn)
					{
						Pawn pawn = (Pawn) piece;
						if (pawn.hasColor("black") && pawn.enpassant == true)
						{
							Board.board[row1][col1] = null;
							Board.board[row1][col2] = null;
							Board.board[row2][col2] = this;
							if (Board.check(this.getColor()))
							{
								Board.board[row1][col1] = this;
								Board.board[row1][col2] = piece;
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
				}
				else if (Board.board[row2][col2].hasColor("white")) // regular
				{
					Piece piece = Board.board[row2][col2];
					Board.board[row1][col1] = null;
					Board.board[row2][col2] = this;
					if (row2 == 0)
					{
						if (promote(input, modify) == false)
						{
							return false;
						}
						else
						{
							return true;
						}
					}
					if (Board.check(this.getColor()))
					{
						Board.board[row1][col1] = this;
						Board.board[row2][col2] = piece;
						return false;
					}
					else
					{
						moved = true;
						return true;
					}
				}
				else
				{
					return false;
				}
			}
		}
		return false;
	}
	
	public boolean move_forward(int row1, int col1, int row2, int col2, boolean modify)
	{
		if (col1 == col2) // straight
		{
			if ((this.hasColor("white") && row1-1 == row2) || (this.hasColor("black") && row1+1 == row2)) // 1
			{
				
				boolean ret = regular_move(row1, col1, row2, col2, modify);
				if (ret && modify)
				{
					moved = true;
				}
				return ret;
			}
			else if ((this.hasColor("white") && row1-2 == row2) || (this.hasColor("black") && row1+2 == row2) && !moved) // 2
			{
				if (Board.board[(row1+row2)/2][col1] != null) // clear path
				{
					return false;
				}
				else
				{
					boolean ret = regular_move(row1, col1, row2, col2, modify);
					{
						if (ret && modify)
						{
							moved = true;
							enpassant = true;
						}
						return ret;
					}
				}
			}
			else
			{
				return false;
			}
		}
		else if (Math.abs(col1-col2) == 1) // diagonal
		{
			if ((this.hasColor("white") && row1-1 == row2) || (this.hasColor("black") && row1+1 == row2))
			{
				if (capture_move(row1, col1, row2, col2, false))
				{
					
				}
				
			}
			else
			{
				return false;
			}
		}
		
		return false;
	}
	
	public boolean enpassant(int row1, int col1, int row2, int col2, boolean modify)
	{
		return false;
	}
	
	public boolean promote(String input, boolean modify)
	{
		int col1 = Board.file_to_col(input.charAt(0));
		int row1 = Board.rank_to_row(input.charAt(1));
		int col2 = Board.file_to_col(input.charAt(3));
		int row2 = Board.rank_to_row(input.charAt(4));
		Piece p1 = Board.board[row1][col1];
		Piece p2 = Board.board[row2][col2];
		
		if (input.length() >= 7)
		{
			char c = input.charAt(6);
			switch (c)
			{
				case 'R':
					Board.board[row1][col1] = null;
					Board.board[row2][col2] = new Rook(this.getColor());
					break;
				case 'N':
					Board.board[row1][col1] = null;
					Board.board[row2][col2] = new Knight(this.getColor());
					break;
				case 'B':
					Board.board[row1][col1] = null;
					Board.board[row2][col2] = new Bishop(this.getColor());
					break;
				default:
					Board.board[row1][col1] = null;
					Board.board[row2][col2] = new Queen(this.getColor());
			}
		}
		else
		{
			Board.board[row1][col1] = null;
			Board.board[row2][col2] = new Queen(this.getColor());
		}
		if (Board.check(this.getColor()))
		{
			Board.board[row1][col1] = p1;
			Board.board[row2][col2] = p2;
			return false;
		}
		return true;
	}
}
