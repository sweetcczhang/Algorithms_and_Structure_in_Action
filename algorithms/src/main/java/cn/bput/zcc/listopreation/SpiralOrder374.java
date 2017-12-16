package cn.bput.zcc.listopreation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 张城城 on 2017/12/16.
 */
public class SpiralOrder374 {
    /**
     *
     * @param matrix
     * @return
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        // write your code here
        List<Integer> result = new ArrayList<Integer>();
        if(matrix==null || matrix.length==0) return result;
        int top=0;
        int end=matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;
        while (top<=end&& left<=right){
            int i = top, j=left;
            while (j<=right){
                result.add(matrix[i][j]);
                j++;
            }
            i++;
            j--;
            while (i<=end){
                result.add(matrix[i][j]);
                i++;
            }
            i--;
            j--;
            while (j>=left && top!=end){
                result.add(matrix[i][j]);
                j--;
            }
            j++;
            i--;
            while (i>top && left!=right){
                result.add(matrix[i][j]);
                i--;
            }
            top++;
            left++;
            end--;
            right--;
        }
        return result;
    }
    public static void main(String[] args){
        int [] [] a= {{1,2,3},{4,5,6},{7,8,9}};
        spiralOrder(a);
    }
}
