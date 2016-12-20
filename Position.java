public class Position 
{
	private int x;
	private int y;

	Position()
	{
		x = 0;
		y = 0;
	}
	
	Position(int x, int y)
	{
		this.x = x;
		this.y = y;	
	}	
	
	// fonction get()
	int getX ()
	{
		return x;
	}
	int getY ()
	{
		return y;
	}

	void setX (int x)
	{
		this.x = x;
	}
	
	void setY (int y)
	{
		this.y = y;
	}
	
}
