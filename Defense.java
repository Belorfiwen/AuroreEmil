public abstract class Defense extends Personnage
{
	private static int nbDefenseur = 5;
	
	// ajouter les classes move (), shoot ()
	
	public String toString ()
	{
		return "=";
	}
	
	// fonction get()
	int getNbDefenseur ()
	{
		return nbDefenseur;
	}
}
