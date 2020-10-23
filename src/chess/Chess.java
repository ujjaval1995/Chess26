package chess;

import java.util.Scanner;

public class Chess
{
	static String turn = "white";
	static boolean game_over = false;
	
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
		
		while (!game_over)
		{	
			Board.print_board();
			String input = "";
			int row1 = -1, col1 = -1, row2 = -1, col2 = -1;
			
			while (true)
			{
				print_turn();
				input = sc.nextLine();
				
				if (input.length() < 5)
				{
					System.out.println("Invalid input, try again");
					continue;
				}
				
				col1 = Board.file_to_col(input.charAt(0));
				row1 = Board.rank_to_row(input.charAt(1));
				col2 = Board.file_to_col(input.charAt(3));
				row2 = Board.rank_to_row(input.charAt(4));
				
				if (row1 == -1 || col1 == -1 || row2 == -1 || col2 == -1)
				{
					System.out.println("Invalid input, try again");
					continue;
				}
				if (Board.board[row1][col1] != null && Board.board[row1][col1].move(input) == true)
				{
					break;
				}
				else
				{
					System.out.println("Illegal move, try again");
				}
			}
			
			System.out.println();
			change_turn();
		}
		//sc.close();
	}
}
