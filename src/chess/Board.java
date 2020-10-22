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
		for (int j=0; j<8; j+=5)
		{
			board[0][j] = new Knight("black");
			board[7][j] = new Knight("white");
		}
		for (int j=0; j<8; j+=3)
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
		System.out.println(" a  b  c  d  e  f  g  h");
	}
}
