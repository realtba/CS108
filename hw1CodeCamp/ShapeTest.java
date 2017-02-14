import junit.framework.TestCase;
import java.util.*;



//Provided testing for simple Point class.

public class ShapeTest extends TestCase {
	public void test1() {
	Shape test = new Shape("0 0  0 1  1 1  1 0");
		
		ArrayList<Point> testArray = new ArrayList<Point>();
		
		testArray = test.getEdges();
		
		assertEquals(0.0, testArray.get(0).getX());
		assertEquals(0.0, testArray.get(0).getY());

		assertEquals(0.0, testArray.get(1).getX());
		assertEquals(1.0, testArray.get(1).getY());
		
		assertEquals(1.0, testArray.get(2).getX());
		assertEquals(1.0, testArray.get(2).getY());
		
		assertEquals(1.0, testArray.get(3).getX());
		assertEquals(0.0, testArray.get(3).getY());
	}
	
}
