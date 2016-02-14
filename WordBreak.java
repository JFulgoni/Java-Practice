package john_test;

import java.util.Set;

public class WordBreak {
	
	public WordBreak(){
		
	}
	
	//medium solution using dynamic programming
	public boolean[] medium(String s, Set<String> dict){
		int len = s.length();
		//do a dynamic programming solution
		boolean dp[] = new boolean[len + 1];
		dp[len] = true;
		//count down from length
		for(int i = len - 1; i >= 0; --i){
			//count up from the i position
			for(int j = i; j < len; ++j){
				//if the dictionary contains a substring from i to j + 1
				//and a work already exists that starts at j
				//then we are done
				if(dict.contains(s.substring(i, j + 1)) && dp[j + 1]){
					dp[i] = true;
					break;
				}
			}
		}		
		//return dp[0] because it will be true if the whole solution works
		//and false, since the first char of string s also has to be a beginning of a substring
		//return dp[0];
		
		//returning the array to see if I can print out the exact words
		//I can!
		return dp;
	}
	
	//hard solution using dynamic programming
	public boolean hard(String s, Set<String> dict){
		
	}

}
