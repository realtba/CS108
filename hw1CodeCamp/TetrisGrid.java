//
// TetrisGrid encapsulates a tetris board and has
// a clearRows() capability.

public class TetrisGrid {
	
	/**
	 * Constructs a new instance with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public TetrisGrid(boolean[][] grid) {
		this.grid = grid;
	}
	
	
	/**
	 * Does row-clearing on the grid (see handout).
	 */
	public void clearRows() {
		
		int lines = this.grid[0].length;
		int bricks =  this.grid.length;
		for(int y=0; y< lines; y++){ // loop trough all lines
			
			boolean isFull = false;
			
			for(int x = 0; x<bricks; x++ ) { // loop trough all bricks in line i
				isFull = this.grid[x][y];
				
				if(!isFull) break;
			}
			
			if(isFull){ 
				
				for(int x=0; x< bricks; x++){
					for(int j = y; j< lines-1; j++){
						this.grid[x][j] = this.grid[x][j+1]; //copy lines
					}
					
					this.grid[x][lines-1]=false; // fill the top row with empty bricks
				}				
			}
		}
	
	}
	
	/**
	 * Returns the internal 2d grid array.
	 * @return 2d grid array
	 */
	boolean[][] getGrid() {
		return this.grid; // YOUR CODE HERE
	}

	private boolean[][] grid;

}
