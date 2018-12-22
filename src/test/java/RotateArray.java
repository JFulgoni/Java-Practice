public class RotateArray {
	
	public RotateArray(){
		
	}
	
	public int[] rotate(int[] original, int spot){
		//reverse array first
		int temp;
		int len = original.length;
		for(int i = 0; i < original.length / 2; i++){
			temp = original[i];
			original[i] = original[len - i - 1];
			original[len - i - 1] = temp;
		}
		//now reverse the first spots
		for(int j = 0; j < spot / 2; j++){
			temp = original[j];
			original[j] = original[spot - j];
			original[spot - j] = temp;
		}
		//and then reverse the last spots spot + 1 to len
		int midpoint = len - ((len - spot) / 2);
		//System.out.println("midpoint is " + midpoint);		
		for(int k = spot + 1; k < midpoint; k++){
			//System.out.println("k = " + k);
			//System.out.println(original[k]);
			temp = original[k];
			//System.out.println(original[(len - 1 - (k - spot - 1))]);
			original[k] = original[(len - 1 - (k - spot - 1))];
			original[(len - 1 - (k - spot - 1))] = temp;
		}
		return original;
	}

}
