package john_test;

public class SpiralMatrix {
	private int[][] matrix;
	private final int min = 0;
	private final int max = 9;
	
	public SpiralMatrix(int i){
		matrix = new int[i][i];	
		for(int j = 0; j < i; ++j){
			for(int k = 0; k < i; ++k){
				matrix[j][k] = min + (int)(Math.random() * ((max - min) + 1));
			}
		}
	}
	
	public String toString(){
		int len = matrix.length;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < len; ++i){
			for(int j = 0; j < len; ++j){
				sb.append(matrix[i][j]);
				sb.append(' ');
			}
			sb.append('\n');
		}
		return sb.toString();
	}
	
	public static void main(String[] args){
		SpiralMatrix sm = new SpiralMatrix(5);
		System.out.println(sm);
	}

}
