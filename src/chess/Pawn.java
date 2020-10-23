package chess;

public class Pawn extends Piece
{
	Pawn(String color)
	{
		super(color);
	}
	
	public String toString()
	{
		return super.toString() + "p";
	}

	public boolean move(int r1, int c1, int r2, int c2)
	{
		return true;
	}
}
