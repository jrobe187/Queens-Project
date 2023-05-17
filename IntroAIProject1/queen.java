package IntroAIProject1;

import java.util.ArrayList;
import java.util.Random;
import java.lang.Math;



public class queen{
	ArrayList<queen> queens = new ArrayList<queen>();
	private int x;
	private int y;

	
	
	public queen(ArrayList<queen> i) {
		queens = i;
	}
	
	queen() {
		
	}
	
	
	public queen(int x, int y) {
		this.x = x;
		this.y = y;
		
		
	}
	
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void setX(int i) {
		this.x = i;
	}
	
	
	
	
	
	
//	public int collisions(queen temp) { //detects if a queen collides with another queen and sets heuristic value
//		
//			 
//				 int count = 0;
//				if(this.getX() == temp.getX() || this.getY() == temp.getY() ||
//						Math.abs(this.getX() - temp.getX()) == Math.abs(this.getY() - temp.getY())) { //if queens on the same row count++
//					count++;
//				}
//				return count;
//			}												
//	
	 
	
	
}

