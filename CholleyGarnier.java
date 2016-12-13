public class CholleyGarnier 
{
	public static void main(String[] args) 
	{
		Terrain t = new Terrain ();
		t.start();
		Ecran.afficherln (t.toString());
		Ecran.afficherln(((40-20)/2)-1);
	}
}