public interface Playable 
{
	void move (Terrain t, int verifAJoue,Balle balle);
	void shot (Balle balle, Terrain t);
	int getSensDeJeuEquipe ();
}