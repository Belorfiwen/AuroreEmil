public class Balle
{
	Position p;
	Direction d;

	Balle ()
	{
		this.p = new Position();
		this.d = new Direction();
	}
	Balle (Position p,Direction d)
	{
		this.p = p;
		this.d = d;
	}
	//move () et but ()
	
	public String toString () 
	{
		return "o";
	}
}
