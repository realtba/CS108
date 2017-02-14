/*
 Shape data for ShapeClient:
 "0 0  0 1  1 1  1 0"
 "10 10  10 11  11 11  11 10"
 "0.5 0.5  0.5 -10  1.5 0"
 "0.5 0.5  0.75 0.75  0.75 0.2"
*/

public class ShapeClient {
	public static void main(String[] args){
		
		Shape a = new Shape("0 0  0 1  1 1  1 0");
		Shape b = new Shape( "10 10  10 11  11 11  11 10");
		Shape c = new Shape( "0.5 0.5  0.5 -10  1.5 0");
		Shape d = new Shape( "0.5 0.5  0.75 0.75  0.75 0.2");
		
		System.out.println("a crosses b: " + Shape.crosses(a, b));
		System.out.println("a crosses c: " + Shape.crosses(a, c));
		System.out.println("a crosses d: " + Shape.crosses(a, d));

		System.out.println("a encircles b: " + Shape.encircles(a, b));
		System.out.println("a encircles c: " + Shape.encircles(a, c));
		System.out.println("a encircles d: " + Shape.encircles(a, d));

	}
}
