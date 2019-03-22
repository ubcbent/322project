package cosc322;

import java.util.ArrayList;

public class GameState {
	//0 is empty square, 1 refers to our queens, 2 is enemy queens, 3 is arrow
	public int[][] gameboard = new int[11][11];
	public int[][] ourQueens = new int[5][3];
	public int[][] theirQueens = new int[5][3];
	public ArrayList<LegalMove> legalMoves = new ArrayList<LegalMove>();
	
	public void initialize(boolean white) { // white is true if we are first
	
		 if(white) {
			 //our queens
			 gameboard[1][4] = 1;
			 ourQueens[1][1] = 1;
			 ourQueens[1][2] = 4;
			 gameboard[1][7] = 1;
			 ourQueens[2][1] = 1;
			 ourQueens[2][2] = 7;
			 gameboard[3][1] = 1;
			 ourQueens[3][1] = 3;
			 ourQueens[3][2] = 1;
			 gameboard[3][10] = 1;
			 ourQueens[4][1] = 3;
			 ourQueens[4][2] = 10;
			 //enemy queens
			 gameboard[8][1] = 2;
			 theirQueens[1][1] = 8;
			 theirQueens[1][2] = 1;
			 gameboard[8][10] = 2;
			 theirQueens[2][1] = 8;
			 theirQueens[2][2] = 10;
			 gameboard[10][4] = 2;
			 theirQueens[3][1] = 10;
			 theirQueens[3][2] = 4;
			 gameboard[10][7] = 2;
			 theirQueens[4][1] = 10;
			 theirQueens[4][2] = 7;
			 
			 
		 }else {
			//enemy queens
			 gameboard[1][4] = 2;
			 theirQueens[1][1] = 1;
			 theirQueens[1][2] = 4;
			 gameboard[1][7] = 2;
			 theirQueens[2][1] = 1;
			 theirQueens[2][2] = 7;
			 gameboard[3][1] = 2;
			 theirQueens[4][1] = 3;
			 theirQueens[4][2] = 1;
			 gameboard[3][10] = 2;
			 theirQueens[4][1] = 3;
			 theirQueens[4][2] = 10;
			 //our queens
			 gameboard[8][1] = 1;
			 ourQueens[1][1] = 8;
			 ourQueens[1][2] = 1;
			 gameboard[8][10] = 1;
			 ourQueens[2][1] = 8;
			 ourQueens[2][2] = 10;
			 gameboard[10][4] = 1;
			 ourQueens[3][1] = 10;
			 ourQueens[3][2] = 4;
			 gameboard[10][7] = 1;
			 ourQueens[4][1] = 10;
			 ourQueens[4][2] = 7;
		 }
	}
	
	public void getLegalMoves() {
		legalMoves.clear();
		for(int queen = 1; queen <=4 ; queen++) {
			//current position
			int row = ourQueens[queen][1];
			int col = ourQueens[queen][2];
			//horizontal moves
			for(int left = 1; col-left>0 ;left++) {// check spaces to left of queen
				if(gameboard[row][col-left]==0) { // space is clear
					checkArrowMoves(row,col,row,col-left);
				}else {
					break;
				}
			}
			for(int right = 1; col+right<=10 ;right++) {// check spaces to right of queen
				if(gameboard[row][col+right]==0) { // space is clear
					checkArrowMoves(row,col,row,col+right);
				}else {
					break;
				}
			}
			//vertical moves
			for(int down = 1; row-down>0 ;down++) {// check spaces under queen
				if(gameboard[row-down][col]==0) { // space is clear
					checkArrowMoves(row,col,row-down,col);
				}else {
					break;
				}
			}
			for(int up = 1; row+up<=10 ;up++) {// check spaces above queen
				if(gameboard[row+up][col]==0) { // space is clear
					checkArrowMoves(row,col,row+up,col);
				}else {
					break;
				}
			}
			//diagonals
			for(int dl = 1; col-dl>0 && row-dl>0 ;dl++) {// check spaces down and left of queen
				if(gameboard[row-dl][col-dl]==0) { // space is clear
					checkArrowMoves(row,col,row-dl,col-dl);
				}else {
					break;
				}
			}
			for(int ur = 1; col+ur<=10 && row+ur<=10 ;ur++) {// check spaces up and right of queen
				if(gameboard[row+ur][col+ur]==0) { // space is clear
					checkArrowMoves(row,col,row+ur,col+ur);
				}else {
					break;
				}
			}
			for(int ul = 1; col-ul>0 && row+ul<=10 ;ul++) {// check spaces up and left of queen
				if(gameboard[row+ul][col-ul]==0) { // space is clear
					checkArrowMoves(row,col,row+ul,col-ul);
				}else {
					break;
				}
			}
			for(int dr = 1; col+dr<=10 && row-dr>0 ;dr++) {// check spaces down and right of queen
				if(gameboard[row-dr][col+dr]==0) { // space is clear
					checkArrowMoves(row,col,row-dr,col+dr);
				}else {
					break;
				}
			}
			
		}
	}
	protected void checkArrowMoves(int currRow, int currCol, int newRow, int newCol) {
		//for checking arrow shot candidates, we know we may shoot an arrow through the spot we moved from, or through any empty spot
		//horizontal moves
		for(int left = 1; newCol-left>0 ;left++) {// check spaces to left of queen
			if(gameboard[newRow][newCol-left]==0 || (newRow==currRow && newCol-left==currCol)) { // space is clear
				int[] curr = {currRow,currCol};
				int[] neww = {newRow,newCol};
				int[] arrow = {newRow,newCol-left};
				LegalMove move = new LegalMove(curr,neww,arrow) ;
				legalMoves.add(move);
			}else {
				break;
			}
		}
		for(int right = 1; newCol+right<=10 ;right++) {// check spaces to right of queen
			if(gameboard[newRow][newCol+right]==0 || (newRow==currRow && newCol+right==currCol)) { // space is clear
				int[] curr = {currRow,currCol};
				int[] neww = {newRow,newCol};
				int[] arrow = {newRow,newCol+right};
				LegalMove move = new LegalMove(curr,neww,arrow) ;
				legalMoves.add(move);
			}else {
				break;
			}
		}
		//vertical moves
		for(int down = 1; newRow-down>0 ;down++) {// check spaces under queen
			if(gameboard[newRow-down][newCol]==0 || (newRow-down==currRow && newCol==currCol)) { // space is clear
				int[] curr = {currRow,currCol};
				int[] neww = {newRow,newCol};
				int[] arrow = {newRow-down,newCol};
				LegalMove move = new LegalMove(curr,neww,arrow) ;
				legalMoves.add(move);
			}else {
				break;
			}
		}
		for(int up = 1; newRow+up<=10 ;up++) {// check spaces above queen
			if(gameboard[newRow+up][newCol]==0 || (newRow+up==currRow && newCol==currCol)) { // space is clear
				int[] curr = {currRow,currCol};
				int[] neww = {newRow,newCol};
				int[] arrow = {newRow+up,newCol};
				LegalMove move = new LegalMove(curr,neww,arrow) ;
				legalMoves.add(move);
			}else {
				break;
			}
		}
		//diagonal moves
		for(int dl = 1; newRow-dl>0 && newCol-dl>0 ;dl++) {// check spaces down and to the left of queen
			if(gameboard[newRow-dl][newCol-dl]==0 || (newRow-dl==currRow && newCol-dl==currCol)) { // space is clear
				int[] curr = {currRow,currCol};
				int[] neww = {newRow,newCol};
				int[] arrow = {newRow-dl,newCol-dl};
				LegalMove move = new LegalMove(curr,neww,arrow) ;
				legalMoves.add(move);
			}else {
				break;
			}
		}
		for(int ur = 1; newRow+ur<=10 && newCol+ur<=10 ;ur++) {// check spaces up and to the right of queen
			if(gameboard[newRow+ur][newCol+ur]==0 || (newRow+ur==currRow && newCol+ur==currCol)) { // space is clear
				int[] curr = {currRow,currCol};
				int[] neww = {newRow,newCol};
				int[] arrow = {newRow+ur,newCol+ur};
				LegalMove move = new LegalMove(curr,neww,arrow) ;
				legalMoves.add(move);
			}else {
				break;
			}
		}
		for(int ul = 1; newRow+ul<=10 && newCol-ul>0 ;ul++) {// check spaces up and to the left of queen
			if(gameboard[newRow+ul][newCol-ul]==0 || (newRow+ul==currRow && newCol-ul==currCol)) { // space is clear
				int[] curr = {currRow,currCol};
				int[] neww = {newRow,newCol};
				int[] arrow = {newRow+ul,newCol-ul};
				LegalMove move = new LegalMove(curr,neww,arrow) ;
				legalMoves.add(move);
			}else {
				break;
			}
		}
		for(int dr = 1; newRow-dr>0 && newCol+dr<=10 ;dr++) {// check spaces down and to the left of queen
			if(gameboard[newRow-dr][newCol+dr]==0 || (newRow-dr==currRow && newCol+dr==currCol)) { // space is clear
				int[] curr = {currRow,currCol};
				int[] neww = {newRow,newCol};
				int[] arrow = {newRow-dr,newCol+dr};
				LegalMove move = new LegalMove(curr,neww,arrow) ;
				legalMoves.add(move);
			}else {
				break;
			}
		}
	}
	
}
