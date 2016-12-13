public class Position 
{
	int x;
	int y;
	
	Position(int x, int y)
	{
		this.x = x;
		this.y = y;	
	}	
	
	Position(){
		x = 0;
		y = 0;
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
	
}
