public abstract class Joueur extends Personnage
{
	protected static int nbJoueur = 11;
	protected Equipe e1 = new Equipe("equipe1", true);
	protected Equipe e2 = new Equipe("equipe2", false);
	
	// fonction get()
	int getNbJoueur
	{
		return nbJoueur;
	}
}
