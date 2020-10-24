package chess;

public class Bishop extends Piece
{
	Bishop(String color)
	{
		super(color);
	}
	
	public String toString()
	{
		return super.toString() + "B";
	}

	public boolean move(String input)
	{
		return false;
	}
}
