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
			balle.d.setZ(this.e.getSensDeJeu());
			balle.d.setW(0);

	}
	public void move (Terrain t, int verifAJoue,Balle balle)
	{
		if (aJoue != verifAJoue)
		{
			aJoue++;

			if ((p.getX() == balle.p.getX())&&(p.getY() == balle.p.getY()))
			{
				this.shot(balle);
			}
			// Si à porté de la balle
			else if ((Math.abs(positionBase.getX()-(balle.p.getX())) < 5)&&(Math.abs(positionBase.getY()-(balle.p.getY())) < 5))
			{
				Ecran.afficherln ("position : "+p.getX()+","+p.getY()+"\ndirection : "+d.getZ()+","+d.getW()+"\nposition balle : "+balle.p.getX()+";"+balle.p.getY()+"\nposition cible : "+(directionCible(p,balle.p)).getZ()+","+(directionCible(p,balle.p)).getW()+"\n");
				if ((d.getZ() != (directionCible(p,balle.p)).getZ())||(d.getW() != (directionCible(p,balle.p)).getW()))
				{
					Ecran.afficherln ("changement de direction vers balle !");
					this.d.setZ((directionCible(p,balle.p)).getZ());
					this.d.setW((directionCible(p,balle.p)).getW());
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
						
					}
				}
			}
			//si pas à porté de la balle et pas sur position de base
			else if ((p.getX() != positionBase.getX())||((p.getY() != positionBase.getY())))
			{
				Ecran.afficherln ("position : "+p.getX()+","+p.getY()+"\ndirection : "+d.getZ()+","+d.getW()+"\nposition de base : "+positionBase.getX()+";"+positionBase.getY()+"\nposition cible : "+(directionCible(p,positionBase)).getZ()+","+(directionCible(p,positionBase)).getW()+"\n");
				if ((d.getZ() != (directionCible(p,positionBase)).getZ())||(d.getW() != (directionCible(p,positionBase)).getW()))
				{
					Ecran.afficherln ("changement de direction vers position de base");
					this.d.setZ((directionCible(p,positionBase)).getZ());
					this.d.setW((directionCible(p,positionBase)).getW());
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
						
					}
				}
				
			}
			else    // Si sur position de base
			{
				if ((d.getZ() != e.getSensDeJeu())||(d.getW() != 0))
				{
					d.setZ(e.getSensDeJeu());
					d.setW(0);
				}
			}
		}
	}
	
	// fonction get()
	static int getNbDefenseur ()
	{
		return nbDefenseur;
	}
}
