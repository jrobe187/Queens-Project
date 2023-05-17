package IntroAIProject1;

import java.util.ArrayList;
import java.util.Random;

public class board{
	public ArrayList<queen> queens;
	int hScore;
	int neighbors;
	int stateChanges;
	int restarts;
	
	public board() {
		queens = new ArrayList<queen>();
		populateBoard();
		
	}
	
	public void setQueens(ArrayList<queen> queens) {
		this.queens = queens;
	}
	
	public board(ArrayList<queen> x) {
		this.queens = x;
	}
	
	public ArrayList<queen> getQueens(){
		return this.queens;
	}
	
	
	public int getHeuristic() {
		return this.hScore;
	}
	
	public int getNeighbors() {
		return neighbors;
	}
	
	public int getChanges() {
		return this.stateChanges;
	}
	
	public int getRestarts() {
		return this.restarts;
	}
	
	public void setHeuristic(int x) {
		this.hScore = x;
	}
	
	public void setNeighbors(int x) {
		this.neighbors = x;
	}
	
	public void setChanges(int x) {
		this.stateChanges = x;
	}
	
	public void setRestarts(int x) {
		this.restarts = x;
	}
	
	//Populates board by filling arraylist of queen objects
	private void populateBoard() {
		board board = new board(queens);
		Random rand = new Random();
		for(int i = 0; i < 8; i++) {
			board.getQueens().add(new queen(rand.nextInt(8),i)); //heuristic value set to 0 for getHeuristic() call
		}
	}
		
	
	public void printBoard() {
		this.setHeuristic(this.collisions());
		int[][] arr = new int[8][8];
		System.out.println("Heuristic Score: " + this.getHeuristic());
		for(int i = 0; i < 8; i++) {
					arr[this.getQueens().get(i).getX()][i] = 1;
				}
		
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				System.out.print(arr[i][j] + "  ");
			}
			System.out.println(" ");
		}
	}
	
	public int collisions() { //use on board object
		int count = 0;
		for(int i = 0; i < 8; i++) {
			queen main = this.getQueens().get(i);
			for(int j = i + 1; j < 8; j++) {
				queen q = this.getQueens().get(j);
				if(main.getX() == q.getX() || Math.abs(main.getX() - q.getX()) == Math.abs(main.getY() - q.getY()))// if row value the same and if
																												   // or if slope is the same count++
					count++;
			}
		}
		return count;
	}
	
	
	
	
	public  void moveQueens() {
		
		board temp = new board(this.getQueens());
		
		int neighbor = 0;
		int heuristic = this.collisions();
		int row = 0;
		int column = 0;
		temp.setHeuristic(100000); //to ensure that on the first iteration temp is given a heuristic value
		int changes = 0;
		int restart = 0;
		this.setHeuristic(heuristic);
		
		
		while(this.collisions() > 0) {
			neighbor = 0;
			heuristic = this.collisions();
			temp = this;
		for(int i = 0; i < 8; i++) {
			int val = this.queens.get(i).getX(); // saves current row value
			for(int j = 0; j < 8; j++) {
				if(val != j) {
					temp.queens.get(i).setX(j);
					
					if(temp.collisions() < heuristic) {
						neighbor++;
					}
						if(temp.collisions() <  temp.getHeuristic()) {
						changes++;
						temp.setHeuristic(temp.collisions());
						column = temp.queens.get(i).getY();
						row = temp.queens.get(i).getX();
						}
						
					}
						temp.queens.get(i).setX(val);	
			}
		}

		System.out.println("Neighbor States with lower h: " + neighbor);
		System.out.println(" ");
		this.getQueens().get(column).setX(row);
		this.setHeuristic(temp.getHeuristic());
		
		
		this.printBoard();
		if(neighbor == 0) {
			System.out.println("Hold up, changing states real quick");
			System.out.println(" ");
			this.setQueens(new ArrayList<queen>());
			this.populateBoard();
			this.printBoard();
			restart++;
		}
	}
		System.out.println(" ");
		System.out.println("Goal State Reached!");
		System.out.println("State Changes: " + changes);
		System.out.println("Restarts: " + restart);
	}
}


		
		
		
		
		
		
	
	
	

	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
