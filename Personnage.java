public abstract class Personnage implements Playable
{
	Position p;
	Direction d;
	int aJoue;


	Personnage (int x,int y,int z, int w)
	{
		this.p = new Position (x,y);
		this.d = new Direction (z,w);
		this.aJoue = 0;
	}
}
