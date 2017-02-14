import java.util.*;

public class Appearances {
	
	/**
	 * Returns the number of elements that appear the same number
	 * of times in both collections. Static method. (see handout).
	 * @return number of same-appearance elements
	 */
	
	public static <T> int sameCount(Collection<T> a, Collection<T> b) {
		
		HashMap<T, Integer > countsA = new HashMap<T, Integer >();
		HashMap<T, Integer > countsB = new HashMap<T, Integer >();
		int same=0;
		
		for(T t :a ){
			if(countsA.containsKey(t)){
				countsA.put(t,countsA.get(t)+1);
			}
			else{
				countsA.put(t, 1);
			}
		}
	
		for(T t :b ){
			if(countsB.containsKey(t)){
				countsB.put(t,countsB.get(t)+1);
			}
			else{
				countsB.put(t, 1);
			}
		}
		
		for(T t : countsA.keySet()){
			if(countsB.containsKey(t) && countsA.get(t) == countsB.get(t)){
				same++;
			}
		}
		
		return same; 
		
	}
}
