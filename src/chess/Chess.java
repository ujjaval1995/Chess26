package chess;

import java.util.Scanner;

public class Chess
{
	static String turn = "white";
	
	static void print_turn()
	{
		if (turn.equals("white"))
		{
			System.out.print("White's Turn: ");
		}
		else
		{
			System.out.print("Black's Turn: ");
		}
	}
	
	static void change_turn()
	{
		if (turn.equals("white"))
		{
			turn = "black";
		}
		else
		{
			turn = "white";
		}
	}

	public static void main(String[] args)
	{
		Board.make_board();
		Board.initialize_board();
		
		Scanner sc = new Scanner(System.in);
		while (true)
		{	
			Board.print_board();
			String input = "";
			int row1 = -1, col1 = -1, row2 = -1, col2 = -1;
			do
			{
				print_turn();
				input = sc.nextLine();
				if (input.length() < 5) continue;
				col1 = Board.file_to_col(input.charAt(0));
				row1 = Board.rank_to_row(input.charAt(1));
				col2 = Board.file_to_col(input.charAt(3));
				row2 = Board.rank_to_row(input.charAt(4));
			}
			while (row1 == -1 || col1 == -1 || row2 == -1 || col2 == -1);
			Board.board[row1][col1].move(input);
			
			System.out.println();
			change_turn();
		}
		//sc.close();
	}
}
