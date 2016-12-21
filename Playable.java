public interface Playable 
{
	void move (Terrain t, int verifAJoue,Balle balle);
	void shot (Balle balle, Terrain t);

	//fonction non prevue qui sert à contourner un problème de programation que nous avons eux. impossible d'acceder à la variable Equipe e.
/* Milieu.java:30: error: cannot find symbol
						if ((t.getElementGrille(i,j).e.getSensDeJeu() == this.e.getSensDeJeu())&&((Math.abs(this.p.getX()-(cible.getX())))+(Math.abs(this.p.getY()-(cible.getY()))) > (Math.abs(this.p.getX()-i)+(Math.abs(this.p.getY()-j)))))
						                            ^
  symbol:   variable e
  location: interface Playable*/

	int getSensDeJeuEquipe ();
}