public class Terrain
{
	private int ligne, colonne, largeurBut, positionButA, positionButB;
	private Playable [][] grille;

	Terrain ()
	{
		this.ligne = 20;
		this.colonne = 40;
		this.largeurBut = 14;
		this.positionButA = ((terrain.ligne - terrain.largeurBut)/2) -1;
		this.positionButB = ((terrain.ligne - terrain.largeurBut)/2) + terrain.largeurBut -1;
		for (int i=0;i<ligne;i++)
		{
			for (int j=0; j<colonne;j++) 
			{
				this.grille [i][j] = new Playable();
			}
		}
	}
	Terrain (int ligne, int colonne, int largeurBut)
	{
		this.ligne = ligne;
		this.colonne = colone;
		this.largeurBut = largeurBut;
		this.positionButA = ((terrain.ligne - terrain.largeurBut)/2) -1;
		this.positionButB = ((terrain.ligne - terrain.largeurBut)/2) + terrain.largeurBut -1;
		for (int i=0;i<ligne;i++)
		{
			for (int j=0; j<colonne;j++) 
			{
				this.grille [i][j] = new Playable();
			}
		}
	}

	/*void evolve ()
	{
		for each (Jeu j, list)
		{
				j.move;
		}
	}*/

	/*boolean caseLibre (Position p) 
	{
		return (p.x == -1)? true : false; 
	}*/

	String toString ()
	{
		String res = "";
		for (int i=0;i<(ligne);i++)
		{
			for (int j=0; j<(colonne);j++) 
			{
				if (j == 0)
				{
					res = res+"#";
				}
				else if (j == colonne-1)
				{
					res = res+"#\n";
				}
				else if ((i == 0)||(i == ligne-1))
				{
					if ((j<this.positionA)&&(j>this.positionB))
					{
						res = res+"#";
					}
					else 
					{
						if (grille [i][j].pos.x != -1)
						{
							res = res+grille[i][j].toString();
						}
						else
						{
							res = res+" ";
						}
					}
				}
				else if (i == (ligne/2))
				{
					if (grille [i][j].pos.x != -1)
					{
						res = res+grille[i][j].toString();
					}
					else
					{
						res = res+"-";
					}
				}
				else
				{
					if (grille [i][j].pos.x != -1)
					{
						res = res+grille[i][j].toString();
					}
					else
					{
						res = res+" ";
					}
				}
			}
		}
	}

}