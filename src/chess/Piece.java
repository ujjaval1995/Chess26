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
	
	public String getColor()
	{
		if (this.color.equals("white"))
		{
			return "white";
		}
		else
		{
			return "black";
		}
	}
	
	public String getOtherColor()
	{
		if (this.color.equals("white"))
		{
			return "black";
		}
		else
		{
			return "white";
		}
	}
	
	public boolean hasColor(String color)
	{
		if (this.color.equals(color))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public abstract boolean move(String input);
}
