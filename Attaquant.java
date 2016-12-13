import java.util.Random;

public abstract class Attaquant extends Personnage
{
	private static int nbAttaquant = 3;
	double nombre;
	
	// ajouter les classes move (), shoot ()
	
	public String toString ()
	{
		return "?";
		//comparer si e1 "^" si e2 "v"
	}
	
	// fonction get()
	int getNbAttaquant ()
	{
		return nbAttaquant;
	}
	
	/*void move ()
	{
		nombre = Math.random();
		
		if ( nombre < 0.33)
		{
			d.getW() = -1;
		}
		
		if (nombre < 0.66)
		{
			d.getW() = 1;
		}
		
		else 
		{
			d.getW = 0;
		}
		
		nombre = Math.random();
		
		if ( nombre < 0.33)
		{
			d.getZ() = -1;
		}
		
		if (nombre < 0.66)
		{
			d.getZ() = 1;
		}
		
		else 
		{
			d.getZ = 0;
		}
	}*/
}
