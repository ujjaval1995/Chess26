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

	public boolean move(int r1, int c1, int r2, int c2)
	{
		return true;
	}
}
