package chess;

import java.util.Scanner;

public class Chess
{
	static String turn = "white";
	
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
			if (turn.equals("white"))
			{
				System.out.print("\nWhite's Turn: ");
			}
			else
			{
				System.out.print("\nBlack's Turn: ");
			}
			String input = sc.nextLine();
			
			char file1 = input.charAt(0);
			char rank1 = input.charAt(1);
			char file2 = input.charAt(3);
			char rank2 = input.charAt(4);
			
			System.out.println();
			change_turn();
		}
		//sc.close();
	}
}
