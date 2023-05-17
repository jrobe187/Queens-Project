package IntroAIProject1;

import java.util.ArrayList;

public class main{
	
	public static void main(String[] args) {
		board board;
		
	
		board = new board();
		board.printBoard();
		board.moveQueens();
		System.out.println();	
	}
}