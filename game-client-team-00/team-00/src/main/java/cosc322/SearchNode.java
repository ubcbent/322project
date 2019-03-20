package cosc322;

import java.util.LinkedList;

public class SearchNode {
public int turn;
public LinkedList<minimaxNode> nodes =new LinkedList<minimaxNode>();
SearchNode(LinkedList nodes, int turn){
	this.turn=turn;
	this.nodes=nodes;
}
public minimaxNode getnode() {
	minimaxNode temp;
	minimaxNode max=null;
	int maxx=0;
	while(!nodes.isEmpty()) {
	temp=nodes.removeFirst();
	if(temp.LegalMoves.hscore>maxx)
		maxx=temp.LegalMoves.hscore;
	max=temp;
	}
	return max;
}

}
