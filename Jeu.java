public abstract class Jeu 
{
	protected Position p;
	protected Direction d;
	
	Jeu ()
	{
		this.p = new Position();
		this.d = new Direction();
	}
	Jeu (Position p,Direction d)
	{
		this.p = p;
		this.d = d;
	}
	
	// fonction get()
	Position getPX ()
	{
		return p.x;
	}
	
	Position getPY ()
	{
		return p.y;
	}
	
	//A supp ?
	Position getP ()
	{
		return p;
	}
	
	Direction getDW ()
	{
		return d.w;
	}
	
	Direction getDZ ()
	{
		return d.z;
	}
	
	//A supp ?
	Direction getD ()
	{
		return d;
	}
}
