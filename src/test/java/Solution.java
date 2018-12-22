public class Solution {
	
	public static String[] Braces(String[] values){
		String[] result = new String[values.length];
		String current;
		for(int i = 0; i < values.length; ++i){
			current = values[i];
			if(BraceCheck(current)){
				result[i] = "YES";
			}
			else{
				result[i] = "NO";
			}
		}
		return result;
	}
	
	public static boolean BraceCheck(String current){
		int paren = 0;
		int square = 0;
		int curly = 0;
		char myChar;
		for(int j = 0; j < current.length(); ++j){
			myChar = current.charAt(j);
			switch(myChar){
			case '(':
				++paren;
				break;
			case ')':
				--paren;
				break;
			case '[':
				++square;
				break;
			case ']':
				--square;
				break;
			case '{':
				++curly;
				break;
			case '}':
				--curly;
			}//end switch case
			if(paren == -1 || square == -1 || curly == -1){
				return false;
			}
		}
		if(paren != 0 || square != 0 || curly != 0){
			return false;
		}
		return true;
	}
	
	public static int getIntComplement(int n){
        int copy = n;
        double p = 2;
        int place = 1;
        while(p < copy){
            p = p * 2;
            ++place;
        }
        System.out.println(place);
        System.out.println(Math.pow(2,  7));
        
        int[] bin = new int[place];
        --place; // to account for it
        for(int i = place; i >= 0; --i){
        	bin[place] = (int) (copy / Math.pow(2,  i));
        	//I don't know why it's printing correctly here
        	System.out.println("In place");
        	System.out.println(bin[place]);
        	if(bin[place] == 1){
        		copy = (int) (copy % Math.pow(2,  i));
        	}
        }
        
        int result = 0;
        for(int j = 0; j < bin.length; j++){
        	//but not here
        	System.out.println("In Test");
        	System.out.println(bin[j]);
        	if(bin[j] == 1){
        		//System.out.println(Math.pow(2, bin.length - j));
            	result += (int) Math.pow(2, j + 1);
        	}
        }
        System.out.println("Answer:");
        return result;
	}
	
	public static void findDuplicates(int[] array){
		int size = array.length;
		for(int i = 0; i < size; ++i){
			if(array[Math.abs(array[i])] >= 0){
				array[Math.abs(array[i])] = -array[Math.abs(array[i])];
			}
			else{
				System.out.println(Math.abs(array[i]));
			}
		}
		
	}

	public static void main(String[] args) {
//		String[] values = new String[]{"{[]}", "}[]}"};
//		String[] result = Braces(values);
//		for(String res : result){
//			System.out.println(res);
//		}
		//System.out.println(getIntComplement(100));
		//int[] dup = new int[]{1, 3, 4, 6, 3, 7, 6, 1};
		//findDuplicates(dup);
		int n = 6;
        for(int i = 1; i < n + 1; ++i){
            int j;
            for(j = 0; j < (n - i); ++j){
                System.out.print(" ");
            }
            for(int k = 0; k < (n - j); ++k){
                System.out.print("#");
            }
            System.out.print("\n");
        }
	}

}
