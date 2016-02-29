package john_test;

public class Stock {
	
	public int[] prices;
	
	public Stock(){
		prices = new int[]{2, 5, 7, 4, 8, 2 , 6, 9 , 0};
	}
	
	/*
	 * if allowed one buy and one sell
	 * find the best possible profit to be made
	 * naturally you have to buy before sell
	 */
	public int easy(){
		int len = prices.length;
		int result = 0;
		if(len <= 1) return result;
		
		int minVal = prices[0];
		for(int i = 1; i < len; ++i){
			result = Math.max(result,  prices[i] - minVal);
			minVal = Math.min(minVal,  prices[i]);
		}
		
		return result;
	}
	
	/*
	 * now allowed as many transactions as you like
	 * but you have to sell before you buy again
	 */
	public int medium(){
		int len = prices.length;
		int result = 0;
		if(len <= 1) return result;
		for(int i = 1; i < len; ++i){
			//continue as prices ascend
			//don't add if the price is less than what comes before it
			result += Math.max(0,  prices[i] - prices[i - 1]);
		}
		return result;
	}
	
	/*
	 * the final rule is now, we are only allowed a maximum of 2 transactions
	 */
	public int hard(){
		int len = prices.length;
		int result = 0;
		if(len <= 1) return result;
		/*
		 * the online solution says to store values in a left2right, and right2left arrays
		 * used that solution to make mine
		 * 
		 */
		int[] l2r = new int[len];
		l2r[0] = 0;
		int[] r2l = new int[len];
		r2l[len - 1] = 0;
		
		//first go left to right
		int minVal = prices[0];
		for(int i = 1; i < len; ++i){
			l2r[i] = Math.max(l2r[i - 1], prices[i] - minVal);
			minVal = Math.min(minVal,  prices[i]);
		}
		
		//then go right to left
		int maxVal = prices[len - 1];
		for(int j = len - 2; j >= 0; --j){
			r2l[j] = Math.max(r2l[j + 1], maxVal - prices[j]);
			maxVal = Math.max(maxVal,  prices[j]);
		}
		
		result = l2r[len - 1];
		//the best value will be the combination of the two halfs
		for(int k = 1; k < len - 1; ++k){
			result = Math.max(result, l2r[k] + r2l[k + 1]);
		}
		return result;
	}

	public static void main(String[] args){
		Stock myStock = new Stock();
		System.out.println("Easy: " + myStock.easy());
		System.out.println("Medium: " + myStock.medium());
		System.out.println("Hard: " + myStock.hard());
	}
}
