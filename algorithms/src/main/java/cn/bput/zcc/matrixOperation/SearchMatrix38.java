package cn.bput.zcc.matrixOperation;

/**
 * Created by 张城城 on 2018/2/5.
 */
public class SearchMatrix38 {
    public int searchMatrix(int[][] matrix,int target){
        if(matrix==null || matrix.length==0) return 0;
        int i = matrix.length-1;
        int  col = matrix[0].length;
        int j = 0;
        int result = 0;

        while(i>=0 &&j<col){
            if(matrix[i][j]==target){
                result++;
                i--;
                j++;
                if(i==0 && j<col&& matrix[i][j]>target) break;
            }else if(matrix[i][j]<target){
                j++;
            }else if(matrix[i][j]>target){
                i--;
            }

        }
        return result;
    }
    public static void main(String[] args){
        int [][] test = {{1,3,5,7},{3,11,16,20},{23,30,34,50}};
        SearchMatrix38 s = new SearchMatrix38();
        s.searchMatrix(test,3);
    }
}
