package cosc322;

public class LegalMove {
	//this class contains one legal move, with the coordinates of the queen before and after the move, as well as the arrow shot coordinates
	//the int hscore is for the heuristic value that will later be applied to the move
	public int hscore;
	public int[] currPos;
	public int[] newPos;
	public int[] arrowPos;
	public int[][]currentboard;


	
	public LegalMove(int[] curr, int[] neww, int[] arrow,int[][]current) {
		currPos = curr;
		newPos = neww;
		arrowPos = arrow;
		hscore = Integer.MIN_VALUE;
		currentboard=current;
		
	}


	
}
