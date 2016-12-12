public class Terrain
{
	private int ligne, colonne, largeurBut;
	private Jeu [][] grilleLigne;

	Terrain ()
	{
		this.ligne = 20;
		this.colonne = 40;
		this.largeurBut = 14;
		this.grilleLigne = new <ArrayList <Jeu>> ();
		for (int i=0; i<Ligne;i++) 
		{
			this.grilleColonne = new <ArrayList <Jeu>> ();
		}
		
	}
	Terrain (int ligne, int colonne, int largeurBut)
	{
		this.ligne = ligne;
		this.colonne = colone;
		this.largeurBut = largeurBut;
		this.grilleLigne = new <ArrayList <Jeu>> ();
		for (int i=0; i<Ligne;i++) 
		{
			this.grilleColonne = new <ArrayList <Jeu>> ();
		}
	}

	void evolve ()
	{

	}

	boolean caseLibre (Position x) 
	{

	}

	String toString ()
	{

	}

}