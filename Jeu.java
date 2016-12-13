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
	
}
