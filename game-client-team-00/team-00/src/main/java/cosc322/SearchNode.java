package cosc322;

import java.util.*;

public class SearchNode {
	public static final int gamePhaseOne = 10;
	public static final int gamePhaseTwo = 20;
	public static final int gamePhaseThree = 30;
	public static final int gamePhaseFour = 40;
	public static final int gamePhaseFive = 50;
	public static final int gamePhaseSix = 60;
	public static final int gamePhaseSeven = 70;
	public static final int gamePhaseEight = 80;
	public static final int gamePhaseNine = 90;
	public static final int gamePhaseTen = 100;
	
	public int turn;
	public int depth;
	public int[][] gameBoard;
	public ArrayList<LegalMove> moves;
	public ArrayList<minimaxNode> tree;
	public int[] bestMove;
	
	public SearchNode(int turn, int[][] board, ArrayList<LegalMove> move) {
		this.turn = turn;
		this.depth = 0;
		this.gameBoard = board;
		this.moves = move;
		this.tree = new ArrayList<minimaxNode>();
		this.bestMove = new int[]{-1, -1, -1, -1, -1, -1};
	}
	
	public void treeDepth() {
		switch (depth) {
			case gamePhaseOne:
				depth = 2;
			case gamePhaseTwo:
				depth = 6;
			case gamePhaseThree:
				depth = 10;
			case gamePhaseFour:
				depth = 16;
		}
	}
	
	//TODO apply heuristic function and update bestMove
	public void applyHeuristicVal() {
		new MinDistanceFunction(gameBoard, moves).evaluateAllMoves();
		
		LegalMove best;
		
		for (int i = 0; i < moves.size(); i++) {
			
		}
	}
	
	public void buildTree() {
		tree = new ArrayList<minimaxNode>();
		
		int treeDepth = 1;
		
		minimaxNode root = new minimaxNode(null, null, null);
		tree.add(root);
		
		
		for (LegalMove m : moves) {
			int[][] updatedBoard = copyArray(gameBoard);
			updatedBoard = updateBoard(m, updatedBoard, treeDepth);
			
			minimaxNode node = new minimaxNode(root, m, updatedBoard);
			tree.add(node);
		}
	}
	
	//TODO
	public void minimaxSearch() {
		
	}
	
	public int[][] updateBoard(LegalMove m, int[][] board, int depth) {
		if (depth % 2 == 0) {
			board[m.currPos[0]][m.currPos[1]] = 0;
			board[m.newPos[0]][m.newPos[1]] = 2;
			board[m.arrowPos[0]][m.arrowPos[1]] = 3;
		} else {
			board[m.currPos[0]][m.currPos[1]] = 0;
			board[m.newPos[0]][m.newPos[1]] = 1;
			board[m.arrowPos[0]][m.arrowPos[1]] = 3;
		}
		
		return board;
	}
	
	public static int[][] copyArray(int[][] arr) {
		int[][] copied = new int[arr.length][arr[0].length];
		
		for(int i = 0; i < arr.length; i++)
			  for(int j = 0; j < arr[i].length; j++)
			    copied[i][j] = arr[i][j];
		
		return copied;
	}
	
	public static void main(String[] args) {
		
	}
}
