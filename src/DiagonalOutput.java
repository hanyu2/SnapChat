
public class DiagonalOutput {
	//http://bit.ly/2hPHryD
	public static void output(int[][] matrix){
		int m = matrix.length;
		int n = matrix[0].length;
		for(int j = 0; j < n; j++){
			for(int k = j, i = 0; k >= 0 && i < m; k--, i++){
				System.out.print(matrix[i][k] + ",");
			}
		}
		for(int i = 1; i < m; i++){
			for(int k = i, t = n - 1; k < m && n >= 0; k++, t--){
				System.out.print(matrix[k][t] + ",");
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
		output(matrix);
	}
}
