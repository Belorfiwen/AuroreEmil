public class Equipe 
{
	private String nom;
	private boolean sensDeJeu;
	private String color;

	Equipe ()
	{
		this.nom = "nom";
		this.sensDeJeu = false;
		this.color = "\u001B[37m";
	}
	Equipe (String nom, boolean sensDeJeu, String color)
	{
		this.nom = nom;
		this.sensDeJeu = sensDeJeu;
		this.color = color;
	}
	
	// fonction get()
	String getNom ()
	{
		return nom;
	}
		String getColor ()
	{
		return color;
	}
	
	boolean getSensDeJeu ()
	{
		return sensDeJeu;
	}
}