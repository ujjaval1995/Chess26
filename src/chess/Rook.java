package chess;

public class Rook extends Piece
{
	Rook(String color)
	{
		super(color);
	}
	
	public String toString()
	{
		return super.toString() + "R";
	}

	public boolean move(int r1, int c1, int r2, int c2)
	{
		return true;
	}
}
