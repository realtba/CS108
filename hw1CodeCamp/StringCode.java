import java.util.HashSet;
import java.util.Set;
// CS108 HW1 -- String static methods

public class StringCode {

	/**
	 * Given a string, returns the length of the largest run.
	 * A a run is a series of adajcent chars that are the same.
	 * @param str
	 * @return max run length
	 */
	public static int maxRun(String str) {
		
		if(str.length()==0) return 0;
		
		int largest = 1;
		int current = 1;
		char last = str.charAt(0);
		
		for(int i=1; i< str.length(); i++){
			
			if(last == str.charAt(i)) current++;
			
			else{
				if(current > largest){
					largest = current;
				}
				current = 1;
				last = str.charAt(i);
			}
		}
	
		return largest;
	}

	
	/**
	 * Given a string, for each digit in the original string,
	 * replaces the digit with that many occurrences of the character
	 * following. So the string "a3tx2z" yields "attttxzzz".
	 * @param str
	 * @return blown up string
	 */
	public static String blowup(String str) {
		
		if(str.length() == 0) return str;
		
		for(int i=0; i< str.length()-1;i++){
			 
			if(str.charAt(i) >= '0' && str.charAt(i)  <= '9'){
				String expand=new String();
				int repeat = Character.getNumericValue(str.charAt(i));
				for(int l=0; l< repeat;l++){
					expand += new String(str.substring(i+1,i+2));
				}
				
				String front = str.substring(0,i);
				String tail = str.substring(i+1); 
				str = front;
				str += expand;
				str += tail;
				i += repeat-1;

			}
		}
		if(str.charAt(str.length()-1) >= '0' && str.charAt(str.length()-1)  <= '9'){
			str = str.substring(0,str.length()-1);
		}

		return str; // YOUR CODE HERE
	}
	
	/**
	 * Given 2 strings, consider all the substrings within them
	 * of length len. Returns true if there are any such substrings
	 * which appear in both strings.
	 * Compute this in linear time using a HashSet. Len will be 1 or more.
	 */
	public static boolean stringIntersect(String a, String b, int len) {
		
		Set<String> subStringsA = new HashSet<String>();
		Set<String> subStringsB = new HashSet<String>();
		
		
		for(int i=0; i <= a.length() - len; i++){ // linear time
			subStringsA.add(a.substring(i, i+len)); // constant time
		}
		
		for(int i=0; i <= b.length() - len; i++){ // linear time
			subStringsB.add(b.substring(i, i+len)); // constant time
		}
		
		for(String element : subStringsA){ // linear time
			if(subStringsB.contains(element)){ // constant time
				return true;
			}
		}
		
		return false; 
	}
	
}
