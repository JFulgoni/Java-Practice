package john_test;

import java.util.ArrayList;
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
	//used this as a reference for understanding
	//http://www.programcreek.com/2014/03/leetcode-word-break-ii-java/
	public ArrayList<String> hard(String s, Set<String> dict){
		/*
		 * can use the same method as the medium solution
		 * the only different now is we now have to keep track of the original words
		 */
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
		ArrayList<String> result = new ArrayList<String>();
		//same rule applies, if dp[0] is false, then it won't work, so return the empty list
		if(dp[0] == false){
			return result;
		}
		// if not false, then we do a version of depth first search in order to find the path we need
		// path is first an empty string, and also start at position 0
		hardDFS(s, dict, "", 0, result);
		return result;
	}
	
	public void hardDFS(String s, Set<String> dict, String path, int start, ArrayList<String> result){
		if(start == s.length()){
			result.add(path);
			return;
		}
		//add a space between words if we actually have words in the path
		if(path.length() != 0){
			path = path + " ";
		}
		for(int i = start; i < s.length(); i++){
			String word = s.substring(start, i + 1);
			if(dict.contains(word) == false){
				continue; // this just restarts the loop, unlike break 
			}
			hardDFS(s, dict, path + word, i + 1, result);
		}
		/* Quote from an online solution to this problem:
		 * This problem is also useful for solving real problems.
		 * Assuming you want to analyze the domain names of the top 10k websites.
		 * We can use this solution to break the main part of the domain into words
		 * and then get a sense of what kinds of websites are popular.
		 * I did this a long time ago and found some interesting results.
		 * For example, the most frequent words include "news", "tube", "porn", "etc".
		 */
	}

}
