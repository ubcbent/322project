package cosc322;

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
LegalMove newLegal=mo.newmoves.get(18);
game.tostring(newLegal.currentboard);
System.out.println();
System.out.println();

LegalMove test=mini.Minimax(mo.newmoves, 1);
System.out.println("finish!!");
	}

}
