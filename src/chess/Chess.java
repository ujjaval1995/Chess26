package chess;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Chess
{
	static String turn = "white";
	static String winner = null;
	static int turn_count = 0;
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
	
	static void increment_turn_count()
	{
		for (int i=0; i<8; i++)
		{
			for (int j=0; j<8; j++)
			{
				Piece piece = Board.board[i][j];
				if (piece != null && piece instanceof Pawn)
				{
					if (turn.equals(piece.getColor()))
					{
						Pawn pawn = (Pawn) piece;
						pawn.enpassant = false;
					}
				}
			}
		}
		turn_count++;
	}
	
	static void end_game()
	{
		if (turn.equals("white"))
		{
			System.out.print("White wins");
		}
		else
		{
			System.out.print("Black wins");
		}
	}
	
	static void read_from_file()
	{
		try
		{
		      File file = new File("src/game1.txt");
		      Scanner sc = new Scanner(file);
		      while (sc.hasNextLine())
		      {
		    	  Board.print_board();
		    	  print_turn();
		    	  
		    	  String input = sc.nextLine();
		    	  System.out.println(input);
		    	  
		    	  System.out.println();
		    	  change_turn();
		    	  increment_turn_count();
		      }
		     sc.close();
		}
		catch (FileNotFoundException e)
		{
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		}
		game_over = true;
	}

	public static void main(String[] args)
	{
		Board.make_board();
		Board.initialize_board();
		
		// read_from_file();
		
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
				
				if (input.equals("resign"))
				{
					game_over = true;
				}
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
			increment_turn_count();
		}
		sc.close();
		end_game();
	}
}
