package john_test;

public class SpiralMatrix {
	private int[][] matrix;
	private int length;
	private final int min = 0;
	private final int max = 9;
	
	public SpiralMatrix(){
		length = 3;
		matrix = new int[][]{new int[]{1, 2, 3}, new int[]{4, 5, 6}, new int[]{7, 8, 9}};
	}
	public SpiralMatrix(int i){
		length = i;
		matrix = new int[i][i];	
		for(int j = 0; j < i; ++j){
			for(int k = 0; k < i; ++k){
				matrix[j][k] = min + (int)(Math.random() * ((max - min) + 1));
			}
		}
	}
	
	public int length(){
		return this.length;
	}
	
	@Override
	public String toString(){
		int len = this.matrix.length;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < len; ++i){
			for(int j = 0; j < len; ++j){
				sb.append(this.matrix[i][j]);
				sb.append(' ');
			}
			sb.append('\n');
		}
		return sb.toString();
	}
	
	/*
	 * Still need to actually implement this
	 */
	public void printSpiral(){
		int i;
		int startRow = 0;
		int endRow = i;
		int finish = 0;
		
	}
	
	public void printRow(int row, int start, int finish){
		for(int i = start; i < finish; ++i){
			System.out.println(matrix[row][i]);
		}
	}
	
	public void printCol(int col, int start, int finish){
		for(int i = start; i < finish; ++i){
			System.out.println(matrix[i][col]);
		}
	}
	
	public static void main(String[] args){
		SpiralMatrix sm = new SpiralMatrix();
		System.out.println(sm);
	}

}
