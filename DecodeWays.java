package john_test;

public class DecodeWays {
	
	/*
	 * returns the number of ways that an object can be decoded
	 * 
	 * it's tricky to understand, but this method actually works
	 */
	public static int decodeWays(String s){
		int len = s.length();
		//if the string is empty
		if(len == 0) return 0;
		//if it contains non digits
		if(!s.matches("[0-9]+")) return 0;
		
		//trying to understand this
		//use two integers
		int f0 = 1, f1 = 1;
		for(int i = 1; i < len; ++i){
			//if the leading char is 0, then we can only add one way to the combinations
			if(s.charAt(i) == '0') f1 = 0;
			
			int num2 = s.charAt(i) - '0';
			int num1 = (s.charAt(i - 1) - '0');
			int num =  (num1 * 10) + num2;
			System.out.println("Num: " + num1 + " " + num2 + " " + num);
			if(num < 10 || num > 26){
				f0 = 0;
			}
			int temp = f1;
			f1 += f0;
			f0 = temp;
		}
		
		return f1;
	}
	
	/*
	 * Even though only 17% of people get this right
	 * It's still considered medium
	 */
	public static void main(String[] args){
		System.out.println("Result: " + decodeWays("1214"));
	}
}
