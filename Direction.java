public class Direction
{

	int z;
	int w;
	
	Direction(int w, int z)
	{
		this.z = z;
		this.w = w;
	}
	
	Direction()
	{
		w = 0;
		z = 0;
	}
	
	// fonction get()
	int getW ()
	{
		return w;
	}
	
	int getZ ()
	{
		return z;
	}
	
}
