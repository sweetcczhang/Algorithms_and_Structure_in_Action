package cn.bput.zcc.listopreation;

/**
 * Created by 张城城 on 2017/12/17.
 */
public class GenerateMatrix381 {

    public int[][] generateMatrix(int n) {
        // write your code here
        int flag=1;
        if(n<0) return null;
        int[][] result = new int[n][n];
        if(n==0) return result;
        int left = 0;
        int right = n-1;
        int top = 0;
        int end = n-1;
        while(left<=right && top<=end){
            int j= left,i=top;
            while (j<=right){
                result[i][j] = flag;
                j++;
                flag++;
            }
            j--;
            i++;
            while (i<=end){
                result[i][j]=flag;
                flag++;
                i++;
            }
            i--;
            j--;
            while (j>left && top!=end){
                result[i][j] = flag;
                flag++;
                j--;
            }
            while (i>top && left!=right){
                result[i][j] = flag;
                flag++;
                i--;
            }
            left++;
            top++;
            right--;
            end--;
        }

        return result;
    }
}
