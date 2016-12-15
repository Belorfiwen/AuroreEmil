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
		int but = but(t);
		if (but == 0)
		{

			if ((d.getZ()== 0)&&(d.getW()== 1))
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
			else if ((d.getZ()== 0)&&(d.getW()== -1))
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
			else if ((d.getZ()== 1)&&(d.getW()== 0))
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
			else if ((d.getZ()== -1)&&(d.getW()== 0))
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
			else if ((d.getZ()== 1)&&(d.getW()== -1))
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
			else if ((d.getZ()==- 1)&&(d.getW()== 1))
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
			else if ((d.getZ()== -1)&&(d.getW()== -1))
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
			else if ((d.getZ()== 1)&&(d.getW()== 1))
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
	{
		if ((((p.getY()+d.getW())>t.getPositionButA())&&((p.getY()+d.getW())<t.getPositionButB()))&&((p.getX()+d.getZ())==0))
		{
			p.setX(p.getX()+d.getZ());
			p.setY(p.getY()+d.getW());
			return 1;
		}
		else if ((((p.getY()+d.getW())>t.getPositionButA())&&((p.getY()+d.getW())<t.getPositionButB()))&&((p.getX()+d.getZ())==t.getLigne()-1))
		{
			p.setX(p.getX()+d.getZ());
			p.setY(p.getY()+d.getW());
			return -1;
		}
		else 
		{
			return 0;
		}
	}
	
	public String toString () 
	{
		return "o";
	}
}
