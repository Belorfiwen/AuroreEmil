public abstract class Joueur extends Personnage
{
	protected static int nbJoueur = 11; // non utilisé
	Equipe e;
	Position positionBase;

	Joueur (int x, int y,int z, int w, Equipe e)
	{
		super(x,y,z,w);
		this.e = e;
		this.positionBase = new Position (x,y);
	}
	
	// fonction get()
	int getNbJoueur ()
	{
		return nbJoueur;
	}

	Direction directionCible(Position joueur, Position cible)
	{
		Direction res;
		int z, w;
		if (joueur.getX() < cible.getX())
		{
			z = 1;
		}
		else if (joueur.getX() == cible.getX())
		{
			z = 0;
		}
		else
		{
			z = -1;
		}

		if (joueur.getY() < cible.getY())
		{
			w = 1;
		}
		else if (joueur.getY() == cible.getY())
		{
			w = 0;
		}
		else
		{
			w = -1;
		}
		res = new Direction (z,w);
		return res;
	}
}
