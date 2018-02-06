package cn.bput.zcc.matrixOperation;

/**
 * Created by 张城城 on 2018/2/6.
 */
public class Rotate161 {
    public void rotate(int[][] matrix){
        if(matrix==null || matrix.length==0 || matrix[0].length==0) return;
        int row = matrix.length;
        int col = matrix[0].length;
        if(row!=col) return;
        for(int i=0; i<row; i++){
            for(int j =0; j<= (col-1)/2;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][col-1-j];
                matrix[i][col-1-j] = temp;
            }
        }
        for (int i=0; i<row; i++){
            for(int j =0;j<row-i-1;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[row-j-1][row-i-1];
                matrix[row-j-1][row-i-1] = temp;
            }
        }

    }
}
