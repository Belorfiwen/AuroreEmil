public class Milieu extends Joueur
{
	private static int nbMilieu = 3;

// paramètre du constructeur pour les valeur de position x et y et les valeurs de direction z et w
	Milieu (int x, int y,int z, int w, Equipe e)
	{
		super(x,y,z,w,e);
	}
	
	// ajouter les classes move (), shoot ()
	
	public String toString ()
	{
		return e.getColor() + "X" + "\u001B[0m";
	}

	//fonction inutile dans defenseur
	public int getSensDeJeuEquipe ()  
	{
		return 0;
	}
	
	public void shot (Balle balle,Terrain t)
	{
		// si a la balle
		if ((this.p.getX() == balle.p.getX())&&(this.p.getY() == balle.p.getY()))
		{
			//initialisation
			Position cible = new Position (1000,1000);

			//parcours de la grille pour chercher les attaquant de l'équipe de joueur
			for (int i = 0; i<t.getLigne()-1; i++)
			{
				for (int j = 0; j<t.getColonne()-1; j++)
				{
					//test presence d'attaquant sur la case
					if ((t.getElementGrille(i,j) != null)&&(t.getElementGrille(i,j) instanceof Attaquant))
					{

						//test si de la meme equipe et plus proche (dans l'axe X) que le resultat precedent.
						if ((t.getElementGrille(i,j).getSensDeJeuEquipe()==this.e.getSensDeJeu())&&((Math.abs(this.p.getX()-(cible.getX()))) > (Math.abs(this.p.getX()-i))))
						{
							//attributiuon de la position de l'attaquant à cible.
							cible.setX(i);
							cible.setY(j);
						}
					}
				}
			}
			// changement de direction de la balle en fonction de la position de la cible
			balle.d.setZ((directionCible(p,cible)).getZ());
			balle.d.setW((directionCible(p,cible)).getW());
		}
	}

	public void move (Terrain t, int verifAJoue,Balle balle)
	{
		// has permet de donnet un peu d'aléatoire dans les mouvement du joueur. il peut ne pas bouget ce tours si.
		int has = (int)(Math.random()*(3-0)+0);

		// tir permet de savoir si le joeur vient de tirer. si oui il ne fait rien ce tour si.
		int tir =0;

		if (aJoue != verifAJoue)
		{
			aJoue++;
			
			if (tir == 1)
			{
				tir = 0;
			}
			else if ((p.getX() == balle.p.getX())&&(p.getY() == balle.p.getY()))
			{
				this.shot(balle,t);
			}
			// Si à porté de la balle
			else if ((Math.abs(positionBase.getX()-(balle.p.getX())) <= (t.getLigne()/2)/4)&&(Math.abs(positionBase.getY()-(balle.p.getY())) <= (t.getColonne())/(nbMilieu)/2)&&(has !=1))
			{
				Ecran.afficherln ("position : "+p.getX()+","+p.getY()+"\ndirection : "+d.getZ()+","+d.getW()+"\nposition balle : "+balle.p.getX()+";"+balle.p.getY()+"\nposition cible : "+(directionCible(p,balle.p)).getZ()+","+(directionCible(p,balle.p)).getW()+"\n");
				if ((d.getZ() != (directionCible(p,balle.p)).getZ())||(d.getW() != (directionCible(p,balle.p)).getW()))
				{
					Ecran.afficherln ("changement de direction vers balle !");
					this.d.setZ((directionCible(p,balle.p)).getZ());
					this.d.setW((directionCible(p,balle.p)).getW());
				}
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

				//si à la fin de son tours le joueur a la balle, il tir.
				if ((p.getX() == balle.p.getX())&&(p.getY() == balle.p.getY()))
				{
					this.shot(balle,t);
				}
			}
			//si pas à porté de la balle et pas sur position de base
			else if (((p.getX() != positionBase.getX())||((p.getY() != positionBase.getY())))&&(has!=1))
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
	static int getNbMilieu ()
	{
		return nbMilieu;
	}
	
}
