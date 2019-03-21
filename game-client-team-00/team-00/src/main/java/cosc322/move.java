package cosc322;

import java.util.LinkedList;

public class move {
LegalMove lm;
int[][]board;
LinkedList <LegalMove> newmoves=new LinkedList<LegalMove>();

public move(LegalMove lm) {
	this.lm=lm;
	board=lm.currentboard;
}

public void tostring(int [][]GB) {
	for(int i=0;i<GB.length;i++) {
		System.out.println();
		for(int j=0;j<GB[0].length;j++) {
			System.out.print(GB[i][j]+" ");
		}//for j
	}//for i
System.out.println();
}//to string

public void getLegalMoves() {
	
	     
		//current position
		int row = lm.newPos[0];
		int col = lm.newPos[1];
		//horizontal moves
		for(int left = 1; col-left>0 ;left++) {// check spaces to left of queen
			if(board[row][col-left]==0) { // space is clear
				checkArrowMoves(row,col,row,col-left);
			}else {
				break;
			}
		}
		for(int right = 1; col+right<=10 ;right++) {// check spaces to right of queen
			if(board[row][col+right]==0) { // space is clear
				checkArrowMoves(row,col,row,col+right);
			}else {
				break;
			}
		}
		//vertical moves
		for(int down = 1; row-down>0 ;down++) {// check spaces under queen
			if(board[row-down][col]==0) { // space is clear
				checkArrowMoves(row,col,row-down,col);
			}else {
				break;
			}
		}
		for(int up = 1; row+up<=10 ;up++) {// check spaces above queen
			if(board[row+up][col]==0) { // space is clear
				checkArrowMoves(row,col,row+up,col);
			}else {
				break;
			}
		}
		//diagonals
		for(int dl = 1; col-dl>0 && row-dl>0 ;dl++) {// check spaces down and left of queen
			if(board[row-dl][col-dl]==0) { // space is clear
				checkArrowMoves(row,col,row-dl,col-dl);
			}else {
				break;
			}
		}
		for(int ur = 1; col+ur<=10 && row+ur<=10 ;ur++) {// check spaces up and right of queen
			if(board[row+ur][col+ur]==0) { // space is clear
				checkArrowMoves(row,col,row+ur,col+ur);
			}else {
				break;
			}
		}
		for(int ul = 1; col-ul>0 && row+ul<=10 ;ul++) {// check spaces up and left of queen
			if(board[row+ul][col-ul]==0) { // space is clear
				checkArrowMoves(row,col,row+ul,col-ul);
			}else {
				break;
			}
		}
		for(int dr = 1; col+dr<=10 && row-dr>0 ;dr++) {// check spaces down and right of queen
			if(board[row-dr][col+dr]==0) { // space is clear
				checkArrowMoves(row,col,row-dr,col+dr);
			}else {
				break;
			}
		}
		
	}

public void checkArrowMoves(int currRow, int currCol, int newRow, int newCol) {
	//for checking arrow shot candidates, we know we may shoot an arrow through the spot we moved from, or through any empty spot
	//horizontal moves
	
	for(int left = 1; newCol-left>0 ;left++) {// check spaces to left of queen
		if(board[newRow][newCol-left]==0 || (newRow==currRow && newCol-left==currCol)) { // space is clear
			int[] curr = {currRow,currCol};
			int[] neww = {newRow,newCol};
			int[] arrow = {newRow,newCol-left};
			int[][]tempboard=new int[11][11];
			for(int i = 1; i<11; i++) {
				for(int j = 1; j<11; j++) {
					tempboard[i][j] = board[i][j];
				}
			}
			tempboard[neww[0]][neww[1]]=1;
			tempboard[curr[0]][curr[1]]=0;
			tempboard[arrow[0]][arrow[1]]=3;
			LegalMove move =new LegalMove(curr,neww,arrow,tempboard);
			newmoves.add(move);
		}else {
			break;
		}
	}
	for(int right = 1; newCol+right<=10 ;right++) {// check spaces to right of queen
		if(board[newRow][newCol+right]==0 || (newRow==currRow && newCol+right==currCol)) { // space is clear
			int[] curr = {currRow,currCol};
			int[] neww = {newRow,newCol};
			int[] arrow = {newRow,newCol+right};
			int[][]tempboard=new int[11][11];
			for(int i = 1; i<11; i++) {
				for(int j = 1; j<11; j++) {
					tempboard[i][j] = board[i][j];
				}
			}
			tempboard[neww[0]][neww[1]]=1;
			tempboard[curr[0]][curr[1]]=0;
			tempboard[arrow[0]][arrow[1]]=3;
			LegalMove move =new LegalMove(curr,neww,arrow,tempboard);
			newmoves.add(move);
		}else {
			break;
		}
	}
	//vertical moves
	for(int down = 1; newRow-down>0 ;down++) {// check spaces under queen
		if(board[newRow-down][newCol]==0 || (newRow-down==currRow && newCol==currCol)) { // space is clear
			int[] curr = {currRow,currCol};
			int[] neww = {newRow,newCol};
			int[] arrow = {newRow-down,newCol};
			int[][]tempboard=new int[11][11];
			for(int i = 1; i<11; i++) {
				for(int j = 1; j<11; j++) {
					tempboard[i][j] = board[i][j];
				}
			}
			tempboard[neww[0]][neww[1]]=1;
			tempboard[curr[0]][curr[1]]=0;
			tempboard[arrow[0]][arrow[1]]=3;
			LegalMove move =new LegalMove(curr,neww,arrow,tempboard);
			newmoves.add(move);
		}else {
			break;
		}
	}
	for(int up = 1; newRow+up<=10 ;up++) {// check spaces above queen
		if(board[newRow+up][newCol]==0 || (newRow+up==currRow && newCol==currCol)) { // space is clear
			int[] curr = {currRow,currCol};
			int[] neww = {newRow,newCol};
			int[] arrow = {newRow+up,newCol};
			int[][]tempboard=new int[11][11];
			for(int i = 1; i<11; i++) {
				for(int j = 1; j<11; j++) {
					tempboard[i][j] = board[i][j];
				}
			}
			tempboard[neww[0]][neww[1]]=1;
			tempboard[curr[0]][curr[1]]=0;
			tempboard[arrow[0]][arrow[1]]=3;
			LegalMove move =new LegalMove(curr,neww,arrow,tempboard);
			newmoves.add(move);
		}else {
			break;
		}
	}
	//diagonal moves
	for(int dl = 1; newRow-dl>0 && newCol-dl>0 ;dl++) {// check spaces down and to the left of queen
		if(board[newRow-dl][newCol-dl]==0 || (newRow-dl==currRow && newCol-dl==currCol)) { // space is clear
			int[] curr = {currRow,currCol};
			int[] neww = {newRow,newCol};
			int[] arrow = {newRow-dl,newCol-dl};
			int[][]tempboard=new int[11][11];
			for(int i = 1; i<11; i++) {
				for(int j = 1; j<11; j++) {
					tempboard[i][j] = board[i][j];
				}
			}
			tempboard[neww[0]][neww[1]]=1;
			tempboard[curr[0]][curr[1]]=0;
			tempboard[arrow[0]][arrow[1]]=3;
			LegalMove move =new LegalMove(curr,neww,arrow,tempboard);
			newmoves.add(move);
		}else {
			break;
		}
	}
	for(int ur = 1; newRow+ur<=10 && newCol+ur<=10 ;ur++) {// check spaces up and to the right of queen
		if(board[newRow+ur][newCol+ur]==0 || (newRow+ur==currRow && newCol+ur==currCol)) { // space is clear
			int[] curr = {currRow,currCol};
			int[] neww = {newRow,newCol};
			int[] arrow = {newRow+ur,newCol+ur};
			int[][]tempboard=new int[11][11];
			for(int i = 1; i<11; i++) {
				for(int j = 1; j<11; j++) {
					tempboard[i][j] = board[i][j];
				}
			}
			tempboard[neww[0]][neww[1]]=1;
			tempboard[curr[0]][curr[1]]=0;
			tempboard[arrow[0]][arrow[1]]=3;
			LegalMove move =new LegalMove(curr,neww,arrow,tempboard);
			newmoves.add(move);
		}else {
			break;
		}
	}
	for(int ul = 1; newRow+ul<=10 && newCol-ul>0 ;ul++) {// check spaces up and to the left of queen
		if(board[newRow+ul][newCol-ul]==0 || (newRow+ul==currRow && newCol-ul==currCol)) { // space is clear
			int[] curr = {currRow,currCol};
			int[] neww = {newRow,newCol};
			int[] arrow = {newRow+ul,newCol-ul};
			int[][]tempboard=new int[11][11];
			for(int i = 1; i<11; i++) {
				for(int j = 1; j<11; j++) {
					tempboard[i][j] = board[i][j];
				}
			}
			tempboard[neww[0]][neww[1]]=1;
			tempboard[curr[0]][curr[1]]=0;
			tempboard[arrow[0]][arrow[1]]=3;
			LegalMove move =new LegalMove(curr,neww,arrow,tempboard);
			newmoves.add(move);
		}else {
			break;
		}
	}
	for(int dr = 1; newRow-dr>0 && newCol+dr<=10 ;dr++) {// check spaces down and to the left of queen
		if(board[newRow-dr][newCol+dr]==0 || (newRow-dr==currRow && newCol+dr==currCol)) { // space is clear
			int[] curr = {currRow,currCol};
			int[] neww = {newRow,newCol};
			int[] arrow = {newRow-dr,newCol+dr};
			int[][]tempboard=new int[11][11];
			for(int i = 1; i<11; i++) {
				for(int j = 1; j<11; j++) {
					tempboard[i][j] = board[i][j];
				}
			}
			tempboard[neww[0]][neww[1]]=1;
			tempboard[curr[0]][curr[1]]=0;
			tempboard[arrow[0]][arrow[1]]=3;
			LegalMove move =new LegalMove(curr,neww,arrow,tempboard);
			newmoves.add(move);
		}else {
			break;
		}
	}

}
}
