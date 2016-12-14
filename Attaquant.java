import java.util.Random;

public class Attaquant extends Joueur
{
	private static int nbAttaquant = 3;
	double nombre;

	Attaquant (int x, int y,int z, int w, Equipe e)
	{
		super(x,y,z,w,e);
	}
	
	// ajouter les classes move (), shoot ()
	
	public String toString ()
	{
		return e.getColor() + "A" + "\u001B[0m";
		//comparer si e1 "^" si e2 "v"
	}

	public void shot ()
	{

	}
	public void move (Terrain t, int verifAJoue)
	{
		if (aJoue != verifAJoue)
		{
			aJoue++;
			int has = (int)( Math.random()*((1) - 0 + 1 ) ) + 0;
			if (has == 1)
			{
				//mouvement
				int x = p.getX();
				int y = p.getY();
				int newX = p.getX()+d.getZ();
				int newY = p.getY()+d.getW();
				if (((newX != t.getLigne()-1)&&(newX != 0)&&(newY != t.getColonne()-1)&&(newY != 0))&&(t.getElementGrille(newX,newY) == null))
				{
					t.setElementGrille(newX,newY, this);
					t.setElementGrille(x,y, null);
					p.setX(newX);
					p.setY(newY);
				}
				else
				{
					d.setZ((int)( Math.random()*((2) - 0 + 1 ) ) -1);
					d.setW((int)( Math.random()*((2) - 0 + 1 ) ) -1);
				}
			}
			else
			{
				//direction
				d.setZ((int)( Math.random()*((2) - 0 + 1 ) ) -1);
				d.setW((int)( Math.random()*((2) - 0 + 1 ) ) -1);
			}
		}
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
