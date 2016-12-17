import java.util.Timer;
import java.util.TimerTask;

public class Terrain
{
	static int verifAJoue = 1;
	private int ligne, colonne, largeurBut, positionButA, positionButB;
	private Playable [][] grille;
	private Equipe e1 = new Equipe("Rouge", 1,"\u001B[31m");
	private Equipe e2 = new Equipe("Vert", -1,"\u001B[32m");
	// Balle
	private Balle balle;

	Terrain ()
	{
		this.ligne = 30;
		this.colonne = 36;
		this.largeurBut = 20;
		this.positionButA = ((this.colonne - this.largeurBut)/2) -1;
		this.positionButB = ((this.colonne - this.largeurBut)/2) + this.largeurBut -1;
		this.balle = new Balle (ligne/2,colonne/2);
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
		this.balle = new Balle (ligne/2,colonne/2);
		grille = new Playable [this.ligne][this.colonne];
		for (int i=0;i<ligne;i++)
		{
			for (int j=0; j<colonne;j++) 
			{
				this.grille [i][j] = null;
			}
		}
	}

	int getLigne ()
	{
		return ligne;
	}
	int getColonne ()
	{
		return colonne;
	}

	int getPositionButA ()
	{
		return positionButA;
	}
	int getPositionButB ()
	{
		return positionButB;
	}

	Playable getElementGrille (int i, int j)
	{
		return grille[i][j];
	}
		void setElementGrille (int i, int j, Playable pl)
	{
		grille [i][j] = pl;
	}


	
	int getLargeurBut()
	{
		return this.largeurBut;
	}
	
	//initialise le placement de chaque joueur au debut d'une partie
	void start ()
	{
		// Balle
		Balle balle = new Balle (0,colonne/2);
		// 6 Attaquants
		for (int j=(colonne/2-8); j<(colonne/2+8+1);j+=8) 
		{
				grille[ligne/2-2][j] = new Attaquant (ligne/2-2,j,0,1,e1);
		}
		for (int j=(colonne/2-8); j<(colonne/2+8+1);j+=8) 
		{
				grille[ligne/2+2][j] = new Attaquant (ligne/2+2,j,0,-1,e2);
		}

		// 3 Milieu
		for (int j=(colonne/2-4); j<(colonne/2+4+1);j+=4) 
		{
				grille[8][j] = new Milieu (8,j,0,1,e1);
		}
		for (int j=(colonne/2-4); j<(colonne/2+4+1);j+=4) 
		{
				grille[ligne-9][j] = new Milieu (ligne-9,j,0,-1,e2);
		}


		// 3 Deffenseurs
		for (int j=6; j<colonne;j+=6) 
		{
				grille[3][j] = new Defense (3,j,0,1,e1);
		}
		for (int j=6; j<colonne;j+=6) 
		{
				grille[ligne-4][j] = new Defense (ligne-4,j,0,-1,e2);
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
			grille[x][y] = new Trolleur (x,y,0,1);
		}
		
	}

	public void evolve()
	{
        final Timer timer = new Timer();
        timer.schedule( new TimerTask()
        {
            public void run()
            {
                int but = parcourEvolve();
                if (but == 1) 
                {
                	timer.cancel();
                	Ecran.afficherln ("l'équipe "+e2.getNom()+" a gagné");
                }
                else if (but == -1)
                {
                	timer.cancel();
                	Ecran.afficherln ("l'équipe "+e1.getNom()+" a gagné");
                }
                if (CholleyGarnier.choix == 2)
                {
                	Clavier.saisirString();
                }
            }
        },0,  100 ); // or 10000 which is 10 s. 
    }
	int parcourEvolve ()
	{
			int but = balle.move(this);
			for (int i=0;i<(ligne);i++)
			{
				for (int j=0; j<(colonne);j++) 
				{
					if ((caseLibre(i,j)) == false)
					{
						grille[i][j].move(this,verifAJoue, this.balle);
					}
				}
			}
			verifAJoue++;
			Ecran.afficherln (toString());
			return but;
	}

	boolean caseLibre (int x, int y) 
	{
		return (grille[x][y] == null)? true : false; 
	}

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
						if ((balle.p.getX()==i)&&balle.p.getY()==j)
						{
							res = res+balle.toString();
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
						if ((balle.p.getX()==i)&&balle.p.getY()==j)
						{
							res = res+balle.toString();
						}
						else
						{
							res = res+"-";
						}
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
						if ((balle.p.getX()==i)&&balle.p.getY()==j)
						{
							res = res+balle.toString();
						}
						else
						{
							res = res+" ";
						}
					}
				}
			}
		}
		return res;
	}

}