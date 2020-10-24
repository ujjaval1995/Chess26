package chess;

import java.util.Arrays;

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

	public boolean move(String input)
	{
		int col1 = Board.file_to_col(input.charAt(0));
		int row1 = Board.rank_to_row(input.charAt(1));
		int col2 = Board.file_to_col(input.charAt(3));
		int row2 = Board.rank_to_row(input.charAt(4));
		
		if (this.color.equals("white"))
		{
			if (col1 == col2 && Board.board[row2][col2] == null) // move
			{
				if (row1-1 == row2 && col1 == col2) // move 1
				{
					Board.board[row2][col2] = this;
					Board.board[row1][col1] = null;
					moved = true;
					if (row2 == 7)
					{
						if (promote(input) == false)
						{
							return false;
						}
					}
					return true;
				}
				else if (row1-2 == row2 && Board.board[row1-1][col2] == null && !moved) // move 2
				{
					Board.board[row2][col2] = this;
					Board.board[row1][col1] = null;
					moved = true;
					enpassant = true;
					return true;
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
						if (pawn.color.equals("black") && pawn.enpassant == true)
						{
							Board.board[row2][col2] = this;
							Board.board[row1][col2] = null;
							moved = true;
							return true;
						}
					}
				}
				else // regular
				{
					Board.board[row2][col2] = this;
					Board.board[row1][col1] = null;
					moved = true;
					if (row2 == 7)
					{
						if (promote(input) == false)
						{
							return false;
						}
					}
					return true;
				}
			}
		}
		else // black
		{
			if (col1 == col2 && Board.board[row2][col2] == null) // regular
			{
				if (row1+1 == row2 && col1 == col2) // move 1
				{
					Board.board[row2][col2] = this;
					Board.board[row1][col1] = null;
					moved = true;
					if (row2 == 0)
					{
						if (promote(input) == false)
						{
							return false;
						}
					}
					return true;
				}
				else if (row1+2 == row2 && Board.board[row1+1][col2] == null && !moved) // move 2
				{
					Board.board[row2][col2] = this;
					Board.board[row1][col1] = null;
					moved = true;
					enpassant = true;
					return true;
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
						if (pawn.color.equals("white") && pawn.enpassant == true)
						{
							Board.board[row2][col2] = this;
							Board.board[row1][col2] = null;
							moved = true;
							return true;
						}
					}
				}
				else // regular
				{
					Board.board[row2][col2] = this;
					Board.board[row1][col1] = null;
					moved = true;
					if (row2 == 0)if (row2 == 0)
					{
						if (promote(input) == false)
						{
							return false;
						}
					}
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean promote(String input)
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
					Board.board[row2][col2] = new Rook(this.color);
					Board.board[row1][col1] = null;
					break;
				case 'N':
					Board.board[row2][col2] = new Knight(this.color);
					Board.board[row1][col1] = null;
					break;
				case 'B':
					Board.board[row2][col2] = new Bishop(this.color);
					Board.board[row1][col1] = null;
					break;
				default:
					Board.board[row2][col2] = new Queen(this.color);
					Board.board[row1][col1] = null;
			}
		}
		else
		{
			Board.board[row2][col2] = new Queen(this.color);
			Board.board[row1][col1] = null;
		}
		if (Board.check(color))
		{
			Board.board[row1][col1] = p1;
			Board.board[row2][col2] = p2;
			return false;
		}
		return true;
	}
	
	public boolean[][] get_moves(int row, int col)
	{
		boolean arr[][] = new boolean[8][8];
		{
			for (boolean[] i : arr)
			{
				Arrays.fill(i, false);
			}
		}
		
		
		
		return arr;
	}
	
}
