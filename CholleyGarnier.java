public class CholleyGarnier 
{
	public static void main(String[] args) 
	{
		//initialisation des variables
		int conditionErreur =-1;
		int cas=0;
		int l=0, c=0, lBut=0; //sont les variable pour creer terrain
		
		Ecran.afficherln("Bienvenu au Troll Ball !");
		Ecran.afficherln();
		
		//saisie de la taille du terrain par l'utilisateur
		do
		{
			conditionErreur = conditionErreur + 1;
			if (conditionErreur != 0)
			{
				Ecran.afficherln("Erreur saisie. Recommencer");
			}
			Ecran.afficherln("Avant de commencer le match, choisissez la taille du terrain entre : ");
			Ecran.afficherln("	1.Terrain: 30x36");
			Ecran.afficherln("	2.Terrain: 60x72");
			Ecran.afficherln("	3.Terrain: 120x144");
			Ecran.afficherln("	4.Terrain: 240x288");
			Ecran.afficherln("	5.Hasard");
			
			Ecran.afficherln();
			Ecran.afficher ("Saisie : ");
			cas = Clavier.saisirInt();
			
		}while((cas<1)&&(cas>5));
		
		//traitement de la saisie de l'utilisateur
		switch (cas)
		{
			case 1:
				l = 30;
				c =36;
				lBut = 15;
				break;
			case 2:
				l = 60;
				c =72;
				lBut = 30;
				break;
			case 3:
				l = 120;
				c =144;
				lBut = 40;
				break;
			case 4:
				l = 240;
				c =288;
				lBut = 80;
				break;
			case 5:
				l = 30;
				c =36;
				lBut = 15;
				break;
		}	
		
		Ecran.afficherln("l :" + l +" c: " + c +"lBut: "+ lBut);
		//manque a faire le cas 5 au hasard a verif si ça fait un belle affichage avec ces valeurs et a cree terrain avec ces valeursS

		String ANSI_RED = "\u001B[31m";
		String ANSI_RESET = "\u001B[0m";

		Terrain t = new Terrain ();
		t.start();
		Ecran.afficherln (t.toString());
		Ecran.afficherln(((40-20)/2)-1);
		System.out.println(ANSI_RED + "This text is red!" + ANSI_RESET);
	}
}