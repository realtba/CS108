// TabooTest.java
// Taboo class tests -- nothing provided.

import java.util.*;

import junit.framework.TestCase;

public class TabooTest extends TestCase {
	
	public void testNoFollow(){
		
	       String rule = new String("acab");
	       ArrayList<Character> rules = new ArrayList<Character>();

	       for(int i = 0; i<rule.length(); i++){
	    	   rules.add(rule.charAt(i));
	       }	
	       HashSet<Character> noFollowC = new HashSet<Character>();
	       noFollowC.add(new Character(rule.charAt(0)));
	       HashSet<Character> noFollowA = new HashSet<Character>();
	       noFollowA.add(new Character(rule.charAt(1)));
	       HashSet<Character> noFollowB = new HashSet<Character>();
	       noFollowB.add(new Character(rule.charAt(2)));
	       
	       Taboo<Character> taboo = new Taboo<Character >(rules); 
	       
			assertEquals(noFollowC, taboo.noFollow(rule.charAt(1)));
			assertEquals(noFollowA, taboo.noFollow(rule.charAt(2)));
			assertEquals(noFollowB, taboo.noFollow(rule.charAt(3)));


	}
	
	public void testReduce(){
		
		String rule = new String("acab");
	    ArrayList<Character> rules = new ArrayList<Character>();

	    for(int i = 0; i<rule.length(); i++){
	    	   rules.add(rule.charAt(i));
	    }	
	       
	    Taboo<Character> taboo = new Taboo<Character >(rules); 
	    
		String listel = new String("acbxca");
	    ArrayList<Character> list = new ArrayList<Character>();

	    for(int i = 0; i<listel.length(); i++){
	    	   list.add(listel.charAt(i));
	    }	
	    
		String listel2 = new String("axc");
	    ArrayList<Character> list2 = new ArrayList<Character>();
	    
	    for(int i = 0; i<listel2.length(); i++){
	    	   list2.add(listel2.charAt(i));
	    }
	    
		taboo.reduce(list);
		assertEquals(list2,list );

	}
}
