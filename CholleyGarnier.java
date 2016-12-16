public class CholleyGarnier 
{
	public static int choix = 0;
	public static void main(String[] args) 
	{
		Ecran. afficherln ("\nBienvenue dans le Troll Ball\n\nVeuillez choisir le mode de deroulement des tours: \n\n1 : Auto\n2 : Manuel");
		choix = Clavier.saisirInt();
		while ((choix < 1)||(choix > 2))
		{
			Ecran.afficherln ("\nMauvaise saisie :\n\n1 : Auto\n2 : Manuel");
			choix = Clavier.saisirInt();
		}
		Terrain t = new Terrain ();
		t.start();
		t.evolve();
		
	}
}