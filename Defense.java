public class Defense extends Personnage
{
	private static int nbDefenseur = 5;

	Defense (int x, int y)
	{
		p = new Position (x,y);
		d = new Direction (0,1);
	}
	
	// ajouter les classes move (), shoot ()
	
	public String toString ()
	{
		return "=";
	}
		public void shot ()
	{

	}
	public void move ()
	{
		
	}
	
	// fonction get()
	int getNbDefenseur ()
	{
		return nbDefenseur;
	}
}
