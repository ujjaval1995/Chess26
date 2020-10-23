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

	public boolean move(int r1, int c1, int r2, int c2)
	{
		return true;
	}
}
