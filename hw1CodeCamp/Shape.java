import java.util.*;


public class Shape {
	
	public Shape(String points){
		
		this.edges = new ArrayList<Point>();
	    Scanner sc = new Scanner(points);
	    
	    while(sc.hasNext()){
	    	this.edges.add(new Point(sc.nextDouble(), sc.nextDouble()));
	    }
	    sc.close();
	    
		double centerX = 0;
		double centerY = 0;

		for(Point edge: this.edges){
			centerX += edge.getX(); 
			centerY += edge.getY(); 

		} 
		
		this.center = new Point( centerX / this.edges.size(),centerY / this.edges.size() );
		this.radius = this.center.distance(this.edges.get(0));
		for(Point edge: this.edges){
			System.out.println(this.center.distance(edge));
			if(this.center.distance(edge) < this.radius ){ 
				this.radius = this.center.distance(edge);
				this.radiusEdge = new Point(edge);
			}

		} 
		
	}
	
	public ArrayList<Point> getEdges(){
		return this.edges;
	}
	
	/*
	 * Returns (a crosses b).
	 */
	public static boolean crosses(Shape a,Shape b ){
		
		for(int i=0; i < a.edges.size()-1; i++){
			if(b.center.distance(a.edges.get(i))<= b.radius 
					&& b.center.distance(a.edges.get(i+1)) > b.radius  ) return true;
		}
		
		if(b.center.distance(a.edges.get(a.edges.size()-1))<= b.radius 
				&& b.center.distance(a.edges.get(0)) > b.radius  ) return true;
		
		return false;
	}
	/*
	 * Returns 
	 * 2 : The center of B's circle is within A's circle 
	 * 1 : otherwise, B's circle intersects A's circle 
	 * 0 : otherwise, the two circles have no intersection 
	 * 
	 */
	public static int encircles(Shape a,Shape b ){
		
		double centerDistance = b.center.distance(a.center);
		
		if(centerDistance <= a.radius) return 2;
		
		else if(centerDistance <= b.radius) return 1;
	
		return 0;
	}
	
	private ArrayList<Point> edges; 
	private Point center;
	private Point radiusEdge;
	private double radius;
}

