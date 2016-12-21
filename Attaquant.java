import java.util.Random;

public class Attaquant extends Joueur
{
	private static int nbAttaquant = 3;

// paramètre du constructeur pour les valeur de position x et y et les valeurs de direction z et w
	Attaquant (int x, int y,int z, int w, Equipe e)
	{
		super(x,y,z,w,e);
	}
	
	public String toString ()
	{
		return e.getColor() + "A" + "\u001B[0m";
	}

	//l'attaquant tir en direction des but. si la position juste devant lui en direction des but est prise il tire dans une autre direction (proche de celle desbut)
	public void shot (Balle balle,Terrain t)
	{
		// si sur la balle
		if ((this.p.getX() == balle.p.getX())&&(this.p.getY() == balle.p.getY()))
		{
			//si à gauche par rapport au but
			if (p.getY()<t.getPositionButA())
			{
				if (t.getElementGrille(p.getX()+e.getSensDeJeu(),p.getY()+1)==null)
				{
					balle.d.setZ(e.getSensDeJeu());
					balle.d.setW(1);
				}
				else
				{
					balle.d.setZ(0);
					balle.d.setW(1);
				}
			}

			//si à à droite par rapport au but
			else if (p.getY()>t.getPositionButA())
			{
				if (t.getElementGrille(p.getX()+e.getSensDeJeu(),p.getY()-1)==null)
				{
					balle.d.setZ(e.getSensDeJeu());
					balle.d.setW(-1);
				}
				else
				{
					balle.d.setZ(0);
					balle.d.setW(-1);
				}
			}

			//si en face par rapport au but
			else
			{
				if (t.getElementGrille(p.getX()+e.getSensDeJeu(),p.getY())==null)
				{
					balle.d.setZ(e.getSensDeJeu());
					balle.d.setW(0);
				}
				else
				{
					int has = (int)(Math.random()*(2-0)+0);
					if (has == 0)
					{
						balle.d.setZ(e.getSensDeJeu());
						balle.d.setW(-1);
					}
					else 
					{
						balle.d.setZ(e.getSensDeJeu());
						balle.d.setW(+1);
					}
					
				}
			}
		}
	}
	public void move (Terrain t, int verifAJoue,Balle balle)
	{
		// has permet de donnet un peu d'aléatoire dans les mouvement du joueur. il peut ne pas bouget ce tours si.
		int has = (int)(Math.random()*(2-0)+0);
		if (aJoue != verifAJoue)
		{
			aJoue++;

			// si le joueur commence le tours sur la balle il tir.
			if ((p.getX() == balle.p.getX())&&(p.getY() == balle.p.getY()))
			{
				this.shot(balle,t);
			}
			// Si à porté de la balle
			else if (((e.getSensDeJeu() == 1)? (balle.p.getX() > t.getLigne()/2-2) : (balle.p.getX() < t.getLigne()/2+2))&&(has==1))
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
				//après mouvement, si ballon alors shot
				if ((d.getZ() != (directionCible(p,balle.p)).getZ())||(d.getW() != (directionCible(p,balle.p)).getW()))
				{
					Ecran.afficherln ("changement de direction vers balle !");
					this.d.setZ((directionCible(p,balle.p)).getZ());
					this.d.setW((directionCible(p,balle.p)).getW());
				}
			}
			//si pas à porté de la balle et pas sur position de base
			else if (((p.getX() != positionBase.getX())||((p.getY() != positionBase.getY())))&&(has==1))
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
	static int getNbAttaquant ()
	{
		return nbAttaquant;
	}

	//fonction inutile pour Attaquant. permet de resoudre un problème de programation
	public int getSensDeJeuEquipe ()  
	{
		return e.getSensDeJeu();
	}
}
