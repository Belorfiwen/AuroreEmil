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

	void move (int ligne,int colonne)
	{
		if ((d.getZ()== 0)&&(d.getW()== 1))
		{
			if (p.getY()+d.getW() != colonne-1) 
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
			if (p.getX()+d.getZ() != ligne-1) 
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
			if ((p.getX()+d.getZ() != ligne-1) && (p.getX()+d.getW() != 0))
			{
				p.setX(p.getX()+d.getZ());
				p.setY(p.getY()+d.getW());
			}
			else if ((p.getX()+d.getZ() == ligne -1) && (p.getX()+d.getW() == 0))
			{
				d.setZ(-1);
				d.setW(1);
				p.setX(p.getX()+d.getZ());
				p.setY(p.getY()+d.getW());
			}
			else if ((p.getX()+d.getZ() == ligne -1) && (p.getX()+d.getW() != 0))
			{
				d.setZ(-1);
				d.setW(-1);
				p.setX(p.getX()+d.getZ());
				p.setY(p.getY()+d.getW());
			}
			else if ((p.getX()+d.getZ() != ligne -1) && (p.getX()+d.getW() == 0))
			{
				d.setZ(-1);
				d.setW(1);
				p.setX(p.getX()+d.getZ());
				p.setY(p.getY()+d.getW());				
			}
		}
		else if ((d.getZ()==- 1)&&(d.getW()== 1))
		{
			if ((p.getX()+d.getZ() != 0) && (p.getX()+d.getW() != colonne-1))
			{
				p.setX(p.getX()+d.getZ());
				p.setY(p.getY()+d.getW());
			}
			else if ((p.getX()+d.getZ() == 0) && (p.getX()+d.getW() == colonne-1))
			{
				d.setZ(1);
				d.setW(-1);
				p.setX(p.getX()+d.getZ());
				p.setY(p.getY()+d.getW());
			}
			else if ((p.getX()+d.getZ() == 0) && (p.getX()+d.getW() != colonne-1))
			{
				d.setZ(1);
				d.setW(1);
				p.setX(p.getX()+d.getZ());
				p.setY(p.getY()+d.getW());
			}
			else if ((p.getX()+d.getZ() != 0) && (p.getX()+d.getW() == colonne-1))
			{
				d.setZ(-1);
				d.setW(-1);
				p.setX(p.getX()+d.getZ());
				p.setY(p.getY()+d.getW());				
			}
		}
		else if ((d.getZ()== -1)&&(d.getW()== -1))
		{
			if ((p.getX()+d.getZ() != 0) && (p.getX()+d.getW() != 0))
			{
				p.setX(p.getX()+d.getZ());
				p.setY(p.getY()+d.getW());
			}
			else if ((p.getX()+d.getZ() == 0) && (p.getX()+d.getW() == 0))
			{
				d.setZ(1);
				d.setW(1);
				p.setX(p.getX()+d.getZ());
				p.setY(p.getY()+d.getW());
			}
			else if ((p.getX()+d.getZ() == 0) && (p.getX()+d.getW() != 0))
			{
				d.setZ(1);
				d.setW(-1);
				p.setX(p.getX()+d.getZ());
				p.setY(p.getY()+d.getW());
			}
			else if ((p.getX()+d.getZ() != 0) && (p.getX()+d.getW() == 0))
			{
				d.setZ(-1);
				d.setW(1);
				p.setX(p.getX()+d.getZ());
				p.setY(p.getY()+d.getW());				
			}
		}
		else if ((d.getZ()== 1)&&(d.getW()== 1))
		{
			if ((p.getX()+d.getZ() != ligne-1) && (p.getX()+d.getW() != colonne-1))
			{
				p.setX(p.getX()+d.getZ());
				p.setY(p.getY()+d.getW());
			}
			else if ((p.getX()+d.getZ() == ligne-1) && (p.getX()+d.getW() == colonne-1))
			{
				d.setZ(-1);
				d.setW(-1);
				p.setX(p.getX()+d.getZ());
				p.setY(p.getY()+d.getW());
			}
			else if ((p.getX()+d.getZ() == ligne-1) && (p.getX()+d.getW() != colonne-1))
			{
				d.setZ(-1);
				d.setW(1);
				p.setX(p.getX()+d.getZ());
				p.setY(p.getY()+d.getW());
			}
			else if ((p.getX()+d.getZ() != ligne-1) && (p.getX()+d.getW() == colonne-1))
			{
				d.setZ(1);
				d.setW(-1);
				p.setX(p.getX()+d.getZ());
				p.setY(p.getY()+d.getW());				
			}
		}		
	}
	void but ()
	{
		
	}
	
	public String toString () 
	{
		return "o";
	}
}
