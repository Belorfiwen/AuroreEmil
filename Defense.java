public class Defense extends Joueur
{
	private static int nbDefenseur = 5;

// paramètre du constructeur pour les valeur de position x et y et les valeurs de direction z et w
	Defense (int x, int y,int z, int w, Equipe e)
	{
		super(x,y,z,w,e);
	}
	
	// ajouter les classes move (), shoot ()
	
	public String toString ()
	{
		return e.getColor() + "=" + "\u001B[0m";
	}
		public void shot (Balle balle)
	{
		if ((this.p.getX() == balle.p.getX())&&(this.p.getY() == balle.p.getY()))
		{
			balle.d.setZ(this.d.getZ());
			balle.d.setW(this.d.getW());

		}
	}
	public void move (Terrain t, int verifAJoue,Balle balle)
	{
		if (aJoue != verifAJoue)
		{
			aJoue++;
			if ((Math.abs(p.getX()-balle.p.getX()) < 5)||(Math.abs(p.getY()-balle.p.getY()) < 5))
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
			else if ((p.getX() != positionBase.getX())||((p.getY() != positionBase.getY())))
			{
				if ((d.getZ() != (directionCible(p,positionBase)).getZ())||(d.getZ() != (directionCible(p,positionBase)).getZ()))
				{
					d.setZ((directionCible(p,positionBase)).getZ());
					d.setW((directionCible(p,positionBase)).getW());
				}
				else
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
				
			}
			else
			{
				if ((d.getZ() != e.getSensDeJeu())||(d.getW() != 0))
				{
					d.setZ(e.getSensDeJeu());
					d.setW(0);
				}
			}
			this.shot(balle);
		}
	}
	
	// fonction get()
	int getNbDefenseur ()
	{
		return nbDefenseur;
	}
}
