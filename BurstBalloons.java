package john_test;

public class BurstBalloons {
	
	public BurstBalloons(){
		
	}
	// https://leetcode.com/discuss/82998/jave-understand-illustrated-picture-take-look-still-confused
	
	public int play(int[] balloons){
		if(balloons == null || balloons.length == 0){
			return 0;
		}
		int n = balloons.length;
		if(n == 1){
			return balloons[0];
		}
		int[][]coins = new int[n + 1][n + 1]; //coins[i][j] is the value by bursting coins in the [i, j) range
		for(int j = 1; j <= n; j++){
			for(int i = j - 1; i >= 0; --i){
				int max = 0;
				for(int k = i; k <= j - 1; k++){ //k is the index of the last balloon bursted in [i, j)
					int right, left;
					if(j == n){
						right = 1;
					}
					else{
						right = balloons[j];
					}
					if(i == 0){
						left = 1;
					}
					else{
						left = balloons[i - 1];
					}
					max = Math.max(max, coins[i][k] +  coins[k + 1][j] + balloons[k] * right * left);
					//[i+1][j] is computed before [i][j] which makes this formula possible
				}//end k
				coins[i][j] = max;
			}//end i
		}//end j
		return coins[0][n];
	}

}
