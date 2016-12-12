public class But 
{
	int positionA, positionB;

	But () 
	{
		this.positionA = ((terrain.ligne - terrain.largeurBut)/2) -1;
		this.positionB = ((terrain.ligne - terrain.largeurBut)/2) + terrain.largeurBut -1;
	}
}