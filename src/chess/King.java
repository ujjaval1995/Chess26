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

	public boolean move(int r1, int c1, int r2, int c2)
	{
		return true;
	}
}
