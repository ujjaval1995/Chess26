package chess;

public class Knight extends Piece
{
	Knight(String color)
	{
		super(color);
	}
	
	public String toString()
	{
		return super.toString() + "N";
	}

	public boolean move(String input)
	{
		return true;
	}
}
