public class Trolleur extends Personnage
{
	static private int nbTrolleur = 3;
	
	Trolleur (int x, int y)
	{
		p = new Position (x,y);
		d = new Direction (0,1);
	}
	// ajouter les classes move (), shoot (), position baseHasard
	
	public String toString ()
	{
		return "@";
	}

	public void shot ()
	{

	}

	public void move ()
	{
		
	}
	
	// fonction get()
	static int getNbTrolleur ()
	{
		return nbTrolleur;
	}
}
