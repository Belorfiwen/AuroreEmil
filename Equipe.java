public class Equipe 
{
	private String nom;
	private boolean sensDeJeu;

	Equipe (String nom, boolean sensDeJeu)
	{
		this.nom = nom;
		this.sensDeJeu = sensDeJeu;
	}
	
	// fonction get()
	String getNom
	{
		return nom;
	}
	
	boolean getSensDeJeu
	{
		return sensDeJeu;
	}
}