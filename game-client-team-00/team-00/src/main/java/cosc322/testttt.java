package cosc322;

import java.util.LinkedList;

public class testttt {

	public static void main(String[] args) {
		GameState game =new GameState();
		miniMAX mini= new miniMAX(); 
		game.initialize(true);
		game.getLegalMoves(game.gameboard);
		LegalMove lm=game.legalMoves.removeFirst();
		
		
System.out.println("initialize");
game.tostring(game.gameboard);
System.out.println("after one move");
game.tostring(lm.currentboard);
System.out.println("take the legal move and find other moves");
move mo=new move(lm);
mo.getLegalMoves();
LegalMove newLegal=mo.newmoves.get(0);
game.tostring(newLegal.currentboard);
System.out.println();
System.out.println();
//LinkedList<LegalMove> lll=new LinkedList<LegalMove>();
//lll.add(newLegal);

//LegalMove test=mini.Minimax(lll,0);
MinDistanceFunction f = new MinDistanceFunction(game.gameboard,game.legalMoves);
f.evaluateAllMoves();
LegalMove x=mini.Minimax(game.legalMoves, 1);

System.out.println("x="+x.hscore);
//System.out.println(test.hscore);
//System.out.println(test.arrowPos[0]+"  "+test.arrowPos[1]);
System.out.println("finish!!");
	}

}
