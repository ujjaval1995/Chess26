package chess;

public class Rook extends Piece
{
	Rook(String color)
	{
		super(color);
	}
	
	public String toString()
	{
		return super.toString() + "R";
	}

	public boolean move(String input)
	{
		return move_straight(input);
	}
}
