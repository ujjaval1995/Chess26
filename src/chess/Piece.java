package chess;

public abstract class Piece
{
	String color;
	
	Piece(String color)
	{
		this.color = color;
	}
	
	public String toString()
	{
		if (this.color.equals("white"))
		{
			return "w";
		}
		else
		{
			return "b";
		}
	}
	
	public abstract boolean move(String input);
	public abstract boolean[][] get_moves();
}
