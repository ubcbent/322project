package cosc322;

import java.util.LinkedList;

public class miniMAX {


public static LegalMove Minimax(LinkedList<LegalMove> states,int terminal) {
	int[]checkvalue=new int[states.size()];
	LegalMove[]checkstate=new LegalMove[states.size()];
	//check[0][i] is states check[1][i] is score
	for(int i=0;i<states.size();i++) {
		LegalMove state=states.get(i);
		System.out.println("1");
		if(state.hscore<10)
			continue;
		int maxvalue= MaxValue(state,terminal);
		checkstate[i]=state;
		checkvalue[i]=maxvalue;
		
	}//for
	LegalMove sta=null;
	int flag=0;
	for(int i=0;i<states.size();i++) {
		if(checkvalue[i]>flag) {
			flag=checkvalue[i];
			sta=checkstate[i];
		}//if
	}
	return sta;
}//minimax

public static int MaxValue(LegalMove state,int terminal) {
	terminal=terminal-1;
	int v=Integer.MIN_VALUE;
	int highestScore=v;
	LegalMove bestmove=null;
	if (terminal<=0) {
		System.out.println("4");
	if(state!=null) {
	move newstate=new move(state);
	newstate.getLegalMoves();
	MinDistanceFunction f = new MinDistanceFunction(newstate.board,newstate.newmoves);
	f.evaluateAllMoves();

	for(LegalMove mo:newstate.newmoves) {
		
		if(mo.hscore>highestScore) {
			
			highestScore=mo.hscore;
			bestmove=mo;}
	}
	}//if state!=null
	return highestScore;
	}//if terminal==0
	
	move newstate=new move(state);
	newstate.getLegalMoves();
	MinDistanceFunction f = new MinDistanceFunction(newstate.board,newstate.newmoves);
	f.evaluateAllMoves();
	System.out.println("3");
	for(LegalMove mo:newstate.newmoves) {
		
		v=mo.hscore;
		if(v<10)
			continue;
		Math.max(v,MinValue(mo,terminal));
	}
	return v;

	
}//minvalue

public static int MinValue(LegalMove state,int terminal) {
	terminal=terminal-1;
	int v=Integer.MAX_VALUE;
	int highestScore=v;
	LegalMove bestmove=null;
	if (terminal<=0) {
	if(state!=null) {
	move newstate=new move(state);
	newstate.getLegalMoves();
	MinDistanceFunction f = new MinDistanceFunction(newstate.board,newstate.newmoves);
	f.evaluateAllMoves();
	System.out.println("5");
	for(LegalMove mo:newstate.newmoves) {
		if(mo.hscore<highestScore) {
			highestScore=mo.hscore;
			bestmove=mo;}
	}
	}//if state!=null
	return highestScore;
	}//if terminal==0
	
	move newstate=new move(state);
	newstate.getLegalMoves();
	MinDistanceFunction f = new MinDistanceFunction(newstate.board,newstate.newmoves);
	f.evaluateAllMoves();
	System.out.println("6");
	for(LegalMove mo:newstate.newmoves) {
		v=mo.hscore;
		if(v<10)
			continue;
		//terminal=terminal-1;
		Math.max(v,MaxValue(mo,terminal));
	}
	return v;
}//minvalue
}
