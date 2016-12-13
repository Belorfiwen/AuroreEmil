public abstract class Personnage implements Playable
{
	Position p;
	Direction d;

	Personnage ()
	{
		this.p = new Position();
		this.d = new Direction();
	}
	Personnage (Position p,Direction d)
	{
		this.p = p;
		this.d = d;
	}
}
