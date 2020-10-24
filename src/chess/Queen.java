package chess;

public class Queen extends Piece
{
	Queen(String color)
	{
		super(color);
	}
	
	public String toString()
	{
		return super.toString() + "Q";
	}

	public boolean move(String input)
	{
		return false;
	}
}
