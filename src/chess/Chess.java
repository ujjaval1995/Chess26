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
	
	static int file_to_row(char file)
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
	
	static int rank_to_col(char rank)
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

	public static void main(String[] args)
	{
		Board.make_board();
		Board.initialize_board();
		
		Scanner sc = new Scanner(System.in);
		while (true)
		{	
			Board.print_board();
			String input = "";
			int row = -1;
			int col = -1;
			do
			{
				print_turn();
				input = sc.nextLine();
				if (input.length() < 5) continue;
				row = file_to_row(input.charAt(0));
				col = rank_to_col(input.charAt(1));
			}
			while (row == -1 || col == -1);
			Board.board[row][col].move(input);
			
			System.out.println();
			change_turn();
		}
		//sc.close();
	}
}
