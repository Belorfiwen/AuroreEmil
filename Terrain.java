public class Terrain
{
	private int ligne, colonne, largeurBut, positionButA, positionButB;
	private Playable [][] grille;

	Terrain ()
	{
		this.ligne = 30;
		this.colonne = 36;
		this.largeurBut = 20;
		this.positionButA = ((this.colonne - this.largeurBut)/2) -1;
		this.positionButB = ((this.colonne - this.largeurBut)/2) + this.largeurBut -1;
		grille = new Playable [this.ligne][this.colonne];

		for (int i=0;i<ligne;i++)
		{
			for (int j=0; j<colonne;j++) 
			{
				this.grille [i][j] = null;
			}
		}
	}
	Terrain (int ligne, int colonne, int largeurBut)
	{
		this.ligne = ligne;
		this.colonne = colonne;
		this.largeurBut = largeurBut;
		this.positionButA = ((this.ligne - this.largeurBut)/2) -1;
		this.positionButB = ((this.ligne - this.largeurBut)/2) + this.largeurBut -1;
		grille = new Playable [this.ligne][this.colonne];
		for (int i=0;i<ligne;i++)
		{
			for (int j=0; j<colonne;j++) 
			{
				this.grille [i][j] = null;
			}
		}
	}

	//fonction get()
	int getLigne()
	{
		return this.ligne;
	}
	
	int getColonne ()
	{
		return this.colonne;
	}
	
	int getLargeurBut()
	{
		return this.largeurBut;
	}
	
	//initialise le placement de chaque joueur au debut d'une partie
	void start ()
	{
		// 6 Attaquants
		for (int j=(colonne/2-8); j<(colonne/2+8+1);j+=8) 
		{
				grille[ligne/2-2][j] = new Attaquant (ligne/2-2,j);
		}
		for (int j=(colonne/2-8); j<(colonne/2+8+1);j+=8) 
		{
				grille[ligne/2+2][j] = new Attaquant (ligne/2+2,j);
		}

		// 3 Milieu
		for (int j=(colonne/2-4); j<(colonne/2+4+1);j+=4) 
		{
				grille[8][j] = new Milieu (8,j);
		}
		for (int j=(colonne/2-4); j<(colonne/2+4+1);j+=4) 
		{
				grille[ligne-9][j] = new Milieu (ligne-9,j);
		}


		// 3 Deffenseurs
		for (int j=6; j<colonne;j+=6) 
		{
				grille[3][j] = new Defense (3,j);
		}
		for (int j=6; j<colonne;j+=6) 
		{
				grille[ligne-4][j] = new Defense (ligne-4,j);
		}

		// 3 trolleurs
		for (int i = 0;i< Trolleur.getNbTrolleur();i++)
		{
			int x = (int)( Math.random()*((ligne-2) - 1 + 1 ) ) + 1;
			int y = (int)( Math.random()*((colonne-2) - 1 + 1 ) ) + 1;
			while ((grille [x][y]) != null)
			{
				x = (int)( Math.random()*((ligne-2) - 1 + 1 ) ) + 1;
				y = (int)( Math.random()*((colonne-2) - 1 + 1 ) ) + 1;
			}
			Ecran.afficherln (x+"  "+y);
			grille[x][y] = new Trolleur (x,y);
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

	public String toString ()
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
					if ((j<this.positionButA)||(j>this.positionButB))
					{
						res = res+"#";
					}
					else 
					{
						if (grille [i][j] != null)
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
					if (grille [i][j] != null)
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
					if (grille [i][j] != null)
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
		return res;
	}

}