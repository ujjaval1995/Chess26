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

	public boolean move(int r1, int c1, int r2, int c2)
	{
		return true;
	}
}
