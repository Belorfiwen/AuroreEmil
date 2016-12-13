public class CholleyGarnier 
{
	public static void main(String[] args) 
	{
		String ANSI_RED = "\u001B[31m";
		String ANSI_RESET = "\u001B[0m";

		Terrain t = new Terrain ();
		t.start();
		Ecran.afficherln (t.toString());
		Ecran.afficherln(((40-20)/2)-1);
		System.out.println(ANSI_RED + "This text is red!" + ANSI_RESET);
	}
}