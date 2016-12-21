public class Balle
{
	Position p;
	Direction d;

	Balle ()
	{
		this.p = new Position();
		this.d = new Direction(0,0);
	}
	Balle (int x,int y)
	{
		this.p = new Position(x,y);
		this.d = new Direction(0,0);
	}

	//move () et but ()

	int move (Terrain t)
	{
		//verif si il n'y a pas de but
		int but = but(t);
		if (but == 0)
		{
			//toute les condition pour chaque direction de la balle
			if ((d.getZ()== 0)&&(d.getW()== 1))            //mouvement droite
			{
				if (p.getY()+d.getW() != t.getColonne()-1) 
				{
					p.setX(p.getX()+d.getZ());
					p.setY(p.getY()+d.getW());
				}
				else
				{
					d.setW(-1);
					p.setX(p.getX()+d.getZ());
					p.setY(p.getY()+d.getW());
				}
			}
			else if ((d.getZ()== 0)&&(d.getW()== -1))      //mouvement gauche
			{
				if (p.getY()+d.getW() != 0) 
				{
					p.setX(p.getX()+d.getZ());
					p.setY(p.getY()+d.getW());
				}
				else
				{
					d.setW(1);
					p.setX(p.getX()+d.getZ());
					p.setY(p.getY()+d.getW());
				}
			}
			else if ((d.getZ()== 1)&&(d.getW()== 0))      //mouvement bas
			{
				if (p.getX()+d.getZ() != t.getLigne()-1) 
				{
					p.setX(p.getX()+d.getZ());
					p.setY(p.getY()+d.getW());
				}
				else
				{
					d.setZ(-1);
					p.setX(p.getX()+d.getZ());
					p.setY(p.getY()+d.getW());
				}
			}
			else if ((d.getZ()== -1)&&(d.getW()== 0))      //mouvement haut
			{
				if (p.getX()+d.getZ() != 0) 
				{
					p.setX(p.getX()+d.getZ());
					p.setY(p.getY()+d.getW());
				}
				else
				{
					d.setZ(1);
					p.setX(p.getX()+d.getZ());
					p.setY(p.getY()+d.getW());
				}
			}
			else if ((d.getZ()== 1)&&(d.getW()== -1))     //mouvement diagonale bas gauche
			{
				if ((p.getX()+d.getZ() != t.getLigne()-1) && (p.getY()+d.getW() != 0))
				{
					p.setX(p.getX()+d.getZ());
					p.setY(p.getY()+d.getW());
				}
				else if ((p.getX()+d.getZ() == t.getLigne() -1) && (p.getY()+d.getW() == 0))    
				{
					d.setZ(-1);
					d.setW(1);
					p.setX(p.getX()+d.getZ());
					p.setY(p.getY()+d.getW());
				}
				else if ((p.getX()+d.getZ() == t.getLigne() -1) && (p.getY()+d.getW() != 0))
				{
					d.setZ(-1);
					d.setW(-1);
					p.setX(p.getX()+d.getZ());
					p.setY(p.getY()+d.getW());
				}
				else if ((p.getX()+d.getZ() != t.getLigne() -1) && (p.getY()+d.getW() == 0))
				{
					d.setZ(-1);
					d.setW(1);
					p.setX(p.getX()+d.getZ());
					p.setY(p.getY()+d.getW());				
				}
			}
			else if ((d.getZ()==- 1)&&(d.getW()== 1))     //mouvement diagonale haut droite
			{
				if ((p.getX()+d.getZ() != 0) && (p.getY()+d.getW() != t.getColonne()-1))
				{
					p.setX(p.getX()+d.getZ());
					p.setY(p.getY()+d.getW());
				}
				else if ((p.getX()+d.getZ() == 0) && (p.getY()+d.getW() == t.getColonne()-1))
				{
					d.setZ(1);
					d.setW(-1);
					p.setX(p.getX()+d.getZ());
					p.setY(p.getY()+d.getW());
				}
				else if ((p.getX()+d.getZ() == 0) && (p.getY()+d.getW() != t.getColonne()-1))
				{
					d.setZ(1);
					d.setW(1);
					p.setX(p.getX()+d.getZ());
					p.setY(p.getY()+d.getW());
				}
				else if ((p.getX()+d.getZ() != 0) && (p.getY()+d.getW() == t.getColonne()-1))
				{
					d.setZ(-1);
					d.setW(-1);
					p.setX(p.getX()+d.getZ());
					p.setY(p.getY()+d.getW());				
				}
			}
			else if ((d.getZ()== -1)&&(d.getW()== -1))     //mouvement diagonale haut gauche
			{
				if ((p.getX()+d.getZ() != 0) && (p.getY()+d.getW() != 0))
				{
					p.setX(p.getX()+d.getZ());
					p.setY(p.getY()+d.getW());
				}
				else if ((p.getX()+d.getZ() == 0) && (p.getY()+d.getW() == 0))
				{
					d.setZ(1);
					d.setW(1);
					p.setX(p.getX()+d.getZ());
					p.setY(p.getY()+d.getW());
				}
				else if ((p.getX()+d.getZ() == 0) && (p.getY()+d.getW() != 0))
				{
					d.setZ(1);
					d.setW(-1);
					p.setX(p.getX()+d.getZ());
					p.setY(p.getY()+d.getW());
				}
				else if ((p.getX()+d.getZ() != 0) && (p.getY()+d.getW() == 0))
				{
					d.setZ(-1);
					d.setW(1);
					p.setX(p.getX()+d.getZ());
					p.setY(p.getY()+d.getW());				
				}
			}
			else if ((d.getZ()== 1)&&(d.getW()== 1))     //mouvement diagonale bas droite
			{
				if ((p.getX()+d.getZ() != t.getLigne()-1) && (p.getY()+d.getW() != t.getColonne()-1))
				{
					p.setX(p.getX()+d.getZ());
					p.setY(p.getY()+d.getW());
				}
				else if ((p.getX()+d.getZ() == t.getLigne()-1) && (p.getY()+d.getW() == t.getColonne()-1))
				{
					d.setZ(-1);
					d.setW(-1);
					p.setX(p.getX()+d.getZ());
					p.setY(p.getY()+d.getW());
				}
				else if ((p.getX()+d.getZ() == t.getLigne()-1) && (p.getY()+d.getW() != t.getColonne()-1))
				{
					d.setZ(-1);
					d.setW(1);
					p.setX(p.getX()+d.getZ());
					p.setY(p.getY()+d.getW());
				}
				else if ((p.getX()+d.getZ() != t.getLigne()-1) && (p.getY()+d.getW() == t.getColonne()-1))
				{
					d.setZ(1);
					d.setW(-1);
					p.setX(p.getX()+d.getZ());
					p.setY(p.getY()+d.getW());				
				}
			}
		}
		return but;		
	}
	
	int but (Terrain t)
	{	//verif si but dans but 1
		if ((((p.getY()+d.getW())>t.getPositionButA())&&((p.getY()+d.getW())<t.getPositionButB()))&&((p.getX()+d.getZ())==0))
		{
			p.setX(p.getX()+d.getZ());
			p.setY(p.getY()+d.getW());
			//retour qui indique dans quel but est la balle
			return 1;
		}
		//verif si but dans but -1
		else if ((((p.getY()+d.getW())>t.getPositionButA())&&((p.getY()+d.getW())<t.getPositionButB()))&&((p.getX()+d.getZ())==t.getLigne()-1))
		{
			p.setX(p.getX()+d.getZ());
			p.setY(p.getY()+d.getW());
			//retour qui indique dans quel but est la balle
			return -1;
		}
		else 
		{
			//retour qui indique que la balle n'est pas dans un but
			return 0;
		}
	}
	
	public String toString () 
	{
		return "o";
	}
}
