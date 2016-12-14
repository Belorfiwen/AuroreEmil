public abstract class Joueur extends Personnage
{
	protected static int nbJoueur = 11;
	Equipe e;

	Joueur (int x, int y,int z, int w, Equipe e)
	{
		super(x,y,z,w);
		this.e = e;
	}
	
	// fonction get()
	int getNbJoueur ()
	{
		return nbJoueur;
	}
}
