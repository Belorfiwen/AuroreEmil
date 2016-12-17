public class Equipe 
{
	private String nom;
	private int sensDeJeu; 
	private String color; // blanc par default

	Equipe ()
	{
		this.nom = "nom";
		this.sensDeJeu = 0; 
		this.color = "\u001B[37m"; 
	}
	Equipe (String nom, int sensDeJeu, String color)
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
	int getSensDeJeu ()
	{
		return sensDeJeu;
	}
}