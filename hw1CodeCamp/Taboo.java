
/*
 HW1 Taboo problem class.
 Taboo encapsulates some rules about what objects
 may not follow other objects.
 (See handout).
*/

import java.util.*;

public class Taboo<T> {
	
	/**
	 * Constructs a new Taboo using the given rules (see handout.)
	 * @param rules rules for new Taboo
	 */
	public Taboo(List<T> rules) {
		this.rules = rules;
	}
	
	/**
	 * Returns the set of elements which should not follow
	 * the given element.
	 * @param elem
	 * @return elements which should not follow the given element
	 */
	public Set<T> noFollow(T elem) {
		
		Set<T> forbidenElemets = new HashSet<T>();
		
		for(int i = 1; i < this.rules.size();i++){
			if(this.rules.get(i) == elem){
				forbidenElemets.add(this.rules.get(i-1));
			}
		}
		
		return forbidenElemets;
	}
	
	/**
	 * Removes elements from the given list that
	 * violate the rules (see handout).
	 * @param list collection to reduce
	 */
	public void reduce(List<T> list) {
		
		for(int i=1; i<list.size();i++){
			
			Set<T> forbidenElemets = this.noFollow(list.get(i));
			
			if(forbidenElemets.contains(list.get(i-1))){
				
				list.remove(i);
				i= i-1;
			}
		}
	}
	
	private List<T> rules;
}
