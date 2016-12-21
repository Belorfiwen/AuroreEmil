public class Direction
{

	private int z;
	private int w;
	
	Direction()
	{
		w = 0;
		z = 0;
	}

	Direction(int z, int w)
	{
		this.z = z;
		this.w = w;
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

	void setW (int w)
	{
		this.w = w;
	}
	
	void setZ (int z)
	{
		this.z = z;
	}
	
}
