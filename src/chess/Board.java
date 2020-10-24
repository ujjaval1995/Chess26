package chess;

public class Board
{
	static Piece[][] board;
	
	static void make_board()
	{
		board = new Piece[8][8];
	}
	
	static void initialize_board()
	{
		for (int j=0; j<8; j++)
		{
			board[1][j] = new Pawn("black");
			board[6][j] = new Pawn("white");
		}
		for (int j=0; j<8; j+=7)
		{
			board[0][j] = new Rook("black");
			board[7][j] = new Rook("white");
		}
		for (int j=1; j<8; j+=5)
		{
			board[0][j] = new Knight("black");
			board[7][j] = new Knight("white");
		}
		for (int j=2; j<8; j+=3)
		{
			board[0][j] = new Bishop("black");
			board[7][j] = new Bishop("white");
		}
		board[0][3] = new Queen("black");
		board[7][3] = new Queen("white");
		board[0][4] = new King("black");
		board[7][4] = new King("white");
	}
	
	static void print_board()
	{
		for (int i=0; i<8; i++)
		{
			for (int j=0; j<8; j++)
			{
				Piece piece = board[i][j];
				if (piece != null)
				{
					System.out.print(piece + " ");
				}
				else if ((i+j)%2 == 1)
				{
					System.out.print("## ");
				}
				else
				{
					System.out.print("   ");
				}
			}
			System.out.println(8-i);
		}
		System.out.println(" a  b  c  d  e  f  g  h\n");
	}
	
	static int file_to_col(char file)
	{
		switch (file)
		{
			case 'a': return 0;
			case 'b': return 1;
			case 'c': return 2;
			case 'd': return 3;
			case 'e': return 4;
			case 'f': return 5;
			case 'g': return 6;
			case 'h': return 7;
		}
		return -1;
	}
	
	static int rank_to_row(char rank)
	{
		switch(rank)
		{
			case '8': return 0;
			case '7': return 1;
			case '6': return 2;
			case '5': return 3;
			case '4': return 4;
			case '3': return 5;
			case '2': return 6;
			case '1': return 7;
		}
		return -1;
	}
	
	static boolean check(String color)
	{
		String other = color.equals("white") ? "black" : "white";
		for (int i=0; i<8; i++)
		{
			for (int j=0; j<8; j++)
			{
				Piece piece = Board.board[i][j];
				if (piece != null && piece.color.equals(other))
				{
					for (int x=0; x<8; x++)
					{
						for (int y=0; y<8; y++)
						{
							if (piece.get_moves(i, j)[x][y] == true)
							{
								Piece piece2 = Board.board[x][y];
								if (piece2 != null && piece2 instanceof King && piece2.color.equals(color))
								{
									return true;
								}
							}
						}
					}
				}
			}
		}
		return false;
	}
	
}
