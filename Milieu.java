public class Milieu extends Personnage
{
	private static int nbMilieu = 3;

	Milieu (int x, int y)
	{
		p = new Position (x,y);
		d = new Direction (0,1);
	}
	
	
	// ajouter les classes move (), shoot ()
	
	public String toString ()
	{
		return "X";
	}
		public void shot ()
	{

	}
	public void move ()
	{
		
	}
	
	// fonction get()
	int getNbMilieu ()
	{
		return nbMilieu;
	}
	
}
