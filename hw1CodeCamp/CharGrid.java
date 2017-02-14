import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.Function;
// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

public class CharGrid {
	private char[][] grid;

	/**
	 * Constructs a new CharGrid with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public CharGrid(char[][] grid) {
		this.grid = grid;
	}
	
	/**
	 * Returns the area for the given char in the grid. (see handout).
	 * @param ch char to look for
	 * @return area for given char
	 */
	public int charArea(char ch) {
		
		class Bounds{
			public int lower =-1;
			public int upper =-1;
			public int row=-1;
		}
		
		ArrayList<Bounds> boundsInRow = new ArrayList<Bounds>();
		for(int row=0; row < this.grid.length; row++){
			Bounds bounds = new Bounds();
			bounds.row = row;
			for(int col=0; col< this.grid[0].length; col++){
				if(this.grid[row][col]==ch){
					if(bounds.lower==-1) bounds.lower = bounds.upper =  col;
					else bounds.upper = col;
				}
				
			}
			
			boundsInRow.add(bounds);
		}
		
		int top=-1;
		int bottom=-1;
		int left=-1;
		int right=-1;
		
		for(Bounds bound : boundsInRow){
			if( bound.lower == -1 ) continue; 
			
			if( top==-1 ) top = bound.row;
			
			if( left == -1 ) left = bound.lower;
			
			if( right < bound.upper) right = bound.upper;
			
			if( bottom < bound.row) bottom = bound.row;
		}
		
		
		return (bottom + 1 - top) * (right + 1 -left); 
	}
	
	/**
	 * Returns the count of '+' figures in the grid (see handout).
	 * @return number of + in grid
	 */
	public int countPlus() {
		
		class Search{
			private int Check(int row, int col, 
					Function<Integer, Integer> rowStep, Function<Integer, Integer> colStep){
				
					char ch = CharGrid.this.grid[row][col];
					int length = 0;
					while( row < CharGrid.this.grid.length-1 && row > 0 
							&& col < CharGrid.this.grid[0].length-1 && col >0 ){
							
							row = rowStep.apply(row);
							col = colStep.apply(col);
							
							if(ch != CharGrid.this.grid[row][col]) return length;
							
							length++;
					}
					return length;
			}
		}
		
		Search armSearch = new Search();
		int arms =0;
		for(int row=1; row < this.grid.length-1; row++){
			for(int col=1; col< this.grid[0].length-1; col++){
			
				int leftLength = armSearch.Check(row, col, 
								(Integer a)-> a, (Integer b) -> new Integer(b.intValue()-1));
				
				if(leftLength == 0 ) continue;
				
				int rightLength = armSearch.Check(row, col, 
						(Integer a)-> a, (Integer b) -> new Integer(b.intValue()+1));
				
				if(leftLength !=rightLength || rightLength==0) continue;
				
				int topLength = armSearch.Check(row, col, 
						(Integer a)-> new Integer(a.intValue()-1), (Integer b) -> b);
				
				if(topLength !=rightLength || topLength !=leftLength || topLength ==0) continue;
				
				int bottomLength = armSearch.Check( row, col, 
						(Integer a)-> new Integer(a.intValue()+1), (Integer b) -> b);
			
				if(bottomLength !=rightLength || bottomLength !=leftLength || bottomLength !=topLength || bottomLength==0) continue;
				
				arms++;
			}
		}
				
		return arms;
	}
	
}
