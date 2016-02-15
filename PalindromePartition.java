package john_test;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {
	
	public PalindromePartition(){
		
	}

	public List<List<String>> medium(String s){
		List<List<String>> res = new ArrayList<List<String>>();
		int n = s.length();
		boolean[][] dp = new boolean[n][n];
		for(int i = n - 1; i >=0; --i){
			for(int j = 1; j < n; ++j){
				boolean derp = false;
				if(s.charAt(i)==s.charAt(j)){
					if(j< i + 2 || dp[i+1][j-1]){
						derp = true;
					}
				}
				dp[i][j] = derp;
			}
		}
        ArrayList<String> path = new ArrayList<String>();
        dfs(s, dp, 0, path, res);
        return res;
	}
	
	//copied from the solution
    public void dfs(String s, boolean[][] dp, int start, ArrayList<String> path, List<List<String>> res) {
        if (s.length() == start) {
            res.add(new ArrayList<String>(path));
            return;
        }
        for (int i = start; i < s.length(); ++i) {
            if (dp[start][i] == false) continue;
            path.add(s.substring(start,i+1));
            dfs(s, dp, i+1,path,res);
            path.remove(path.size()-1);
        }
    }
    
    public boolean isPalindrome(String s){
    	int n = s.length();
    	int i = 0;
    	int j = n - 1;
    	while(i <= j){
    		if(s.charAt(i) != s.charAt(j)){
    			return false;
    		}
    		++i;
    		--j;
    	}
    	return true;
    }
}
