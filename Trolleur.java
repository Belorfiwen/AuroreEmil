public class Trolleur extends Personnage
{
	//Donne le nombre de trolleur
	static private int nbTrolleur = 3;
	
	// paramètre du constructeur pour les valeur de position x et y et les valeurs de direction z et w
	Trolleur (int x, int y, int z, int w)
	{
		super(x,y,z,w);
	}
	
	public String toString ()
	{
		return "\u001B[36m"+"@"+"\u001B[0m";
	}

	//le trolleur tir dans sa direction
	public void shot (Balle balle,Terrain t)
	{
		if ((this.p.getX() == balle.p.getX())&&(this.p.getY() == balle.p.getY()))
		{
			balle.d.setZ(this.d.getZ());
			balle.d.setW(this.d.getW());

		}
	}
	// le trolleur bouge ou change de direction de manière aleatoire
	public void move (Terrain t, int verifAJoue,Balle balle)
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
				//verif si position cible libre et pas mur
				if (((newX != t.getLigne()-1)&&(newX != 0)&&(newY != t.getColonne()-1)&&(newY != 0))&&(t.getElementGrille(newX,newY) == null))
				{
					//changment position du personnage
					t.setElementGrille(newX,newY, this);
					t.setElementGrille(x,y, null);
					p.setX(newX);
					p.setY(newY);
				}
				else
				{
					//changement de direction car position cible occupé ou mur
					d.setZ((int)( Math.random()*((2) - 0 + 1 ) ) -1);
					d.setW((int)( Math.random()*((2) - 0 + 1 ) ) -1);
				}
			}
			else
			{
				//changement de direction
				d.setZ((int)( Math.random()*((2) - 0 + 1 ) ) -1);
				d.setW((int)( Math.random()*((2) - 0 + 1 ) ) -1);
			}
			this.shot(balle,t);
		}
	}
	
	// fonction get()
	static int getNbTrolleur ()
	{
		return nbTrolleur;
	}
//fonction inutile pour trolleur
	public int getSensDeJeuEquipe ()  
	{
		return 0;
	}
}
