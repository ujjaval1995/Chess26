package chess;

public class King extends Piece
{
	King(String color)
	{
		super(color);
	}
	
	public String toString()
	{
		return super.toString() + "K";
	}

	public boolean move(String input)
	{
		return false;
	}
}
