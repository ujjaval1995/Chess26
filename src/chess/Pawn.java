package chess;

public class Pawn extends Piece
{
	Pawn(String color)
	{
		super(color);
	}
	
	public String toString()
	{
		return super.toString() + "p";
	}

	public boolean move(String input)
	{
		return true;
	}
}
