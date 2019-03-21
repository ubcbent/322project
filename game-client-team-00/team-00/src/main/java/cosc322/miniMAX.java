package cosc322;

import java.util.LinkedList;

public class miniMAX {


public LegalMove Minimax(LinkedList<LegalMove> states,int terminal) {
	int[]checkvalue=new int[states.size()];
	LegalMove[]checkstate=new LegalMove[states.size()];
	//check[0][i] is states check[1][i] is score
	for(int i=0;i<states.size();i++) {
		LegalMove state=states.get(i);
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

public int MaxValue(LegalMove state,int terminal) {
	int v=Integer.MIN_VALUE;
	if (terminal==0)
		return v;
	//check score
	move newstate=new move(state);
	newstate.getLegalMoves();
newstate.tostring(newstate.newmoves.getLast().currentboard);
	int highestScore=newstate.newmoves.get(0).hscore;
	LegalMove bestmove=newstate.newmoves.get(0);
	for(LegalMove mo:newstate.newmoves) {
		if(mo.hscore>highestScore)
			highestScore=mo.hscore;
			bestmove=mo;
	}
	
	v=Math.max(v,MinValue(bestmove,terminal--));	

	return v;

	
}//minvalue

public int MinValue(LegalMove state,int terminal) {
	int v=Integer.MAX_VALUE;
	if (terminal==0)
		return v;
	//check score
	
	if(v>state.hscore)
		v=state.hscore;
	move newstate=new move(state);
	newstate.getLegalMoves();
	LinkedList<LegalMove> newlist=newstate.newmoves;
	int highestScore=newlist.get(0).hscore;
	LegalMove bestmove=newlist.get(0);
	for(LegalMove mo:newlist) {
		if(mo.hscore<highestScore)
			highestScore=mo.hscore;
			bestmove=mo;
	}
	v=Math.max(v,MaxValue(bestmove,terminal--));	
	
	return v;
}//minvalue
}
