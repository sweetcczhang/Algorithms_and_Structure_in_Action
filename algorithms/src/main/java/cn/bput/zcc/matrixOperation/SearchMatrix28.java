package cn.bput.zcc.matrixOperation;

/**
 * Created by 张城城 on 2018/2/5.
 */
public class SearchMatrix28 {
    public boolean searchMatrix(int[][] matrix, int target){
        if(matrix==null || matrix.length==0) return false;
        int left = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int right = matrix.length*matrix[0].length-1;
        while(left<=right){
            int mid = left +(right-left)/2;
            if(matrix[mid/col][mid%col]==target){
                return true;
            }else if(matrix[mid/col][mid%col]<target){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }

        return false;
    }
}
