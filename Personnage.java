public abstract class Personnage implements Playable
{
	Position p;
	Direction d;
	protected int aJoue; // permet de verifié si, pendant un tour, le joueur sur la case courante a déjà joué ou non. 
	//(++ à chaque fois que le personnage joue et comparaison avec une valeur verif dans evolve() qui doit ètre à aJoué+1 si le joueur n'a pas encore joué)


	Personnage (int x,int y,int z, int w)
	{
		this.p = new Position (x,y);
		this.d = new Direction (z,w);
		this.aJoue = 0;
	}
}
