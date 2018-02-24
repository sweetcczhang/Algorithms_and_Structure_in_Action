package cn.bput.zcc.matrixOperation;

/**
 * Created by 张城城 on 2018/2/24.
 */
public class PrintZMatrix185 {

    public int[] printZMatrix(int[][] matrix){
        if(matrix==null || matrix.length==0) return null;
        int m = matrix.length;
        int n = matrix[0].length;
        int count =matrix.length *matrix[0].length;
        int [] result = new int[count];
        int a=0, b=0;
        int i =1;
        result[0] = matrix[a][b];
        while (i<count){
            while(i<count && a-1>=0 && b+1<n){
                result[i++] = matrix[--a][++b];
            }
            if(i<count && b+1<n){
                result[i++]=matrix[a][++b];
            }else if(i<count && a+1<m) {
                result[i++]= matrix[++a][b];
            }
            while(i<count && a+1<m && b-1>=0){
                result[i++] = matrix[++a][--b];
            }
            if(i<count && a+1<m){
                result[i++]=matrix[++a][b];
            }else if(i<count && b+1<n){
                result[i++]=matrix[a][++b];
            }
        }
        return result;
    }
}
