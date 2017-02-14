
// Test cases for CharGrid -- a few basic tests are provided.

import junit.framework.TestCase;

public class CharGridTest extends TestCase {
	
	public void testCharArea1() {
		char[][] grid = new char[][] {
				{'a', 'y', ' '},
				{'x', 'a', 'z'},
			};
		
		
		CharGrid cg = new CharGrid(grid);
				
		assertEquals(4, cg.charArea('a'));
		assertEquals(1, cg.charArea('z'));
	}
	
	
	public void testCharArea2() {
		char[][] grid = new char[][] {
				{'c', 'a', ' '},
				{'b', ' ', 'b'},
				{' ', ' ', 'a'}
			};
		
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(6, cg.charArea('a'));
		assertEquals(3, cg.charArea('b'));
		assertEquals(1, cg.charArea('c'));
	}
	
	public void testCountPlus(){
		char[][] grid = new char[][] {
			{'b', 'a', 'b'},
			{'a', 'a', 'a'},
			{'b', 'a', 'b'}
		};
		
		CharGrid cg = new CharGrid(grid);
	
		assertEquals(1, cg.countPlus());
		
		char[][] grid2 = new char[][] {
			{'b', 'a', 'b'},
			{'a', 'c', 'a'},
			{'b', 'a', 'b'}
		};
		
		CharGrid cg2 = new CharGrid(grid2);
	
		assertEquals(0, cg2.countPlus());
		

		char[][] grid3 = new char[][] {
			{'b', 'a', 'b','b', 'e', 'f'},
			{'a', 'a', 'a','b', 'e', 'f'},
			{'b', 'a', 'b','b', 'e', 'f'}
		};
		
		CharGrid cg3 = new CharGrid(grid3);
	
		assertEquals(1, cg3.countPlus());
		
		char[][] grid4 = new char[][] {
			{'b', 'a', 'b', 'c','b', 'a', 'b'},
			{'a', 'a', 'a', 'c','a', 'a', 'a'},
			{'b', 'a', 'b', 'c','b', 'a', 'b'}

		};
		
		CharGrid cg4 = new CharGrid(grid4);
	
		assertEquals(2, cg4.countPlus());
		
		
	}
	
	
}
