package cn.bput.zcc.matrixOperation;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 张城城 on 2018/2/26.
 */
public class SubmatrixSum405 {
    /**
     * 题目描述：给定一个整数矩阵，请找出一个子矩阵，使得其数字之和等于0.输出答案时，请返回左上数字和右下数字的坐标。
     * 解题思路：先求解(0,0)到(i,j)内子矩阵的部分和，和存放在终点(i,j)中。
     * @param matrix
     * @return
     */
    public int[][] submatrixSum(int[][] matrix){
        if (matrix==null || matrix.length==0) return null;
        int[][] result = new int[2][2];
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] sum= new int[m+1][n+1];
        for(int i=0;i<=n;i++) sum[0][i]=0;
        for(int i=0;i<=m;i++) sum[i][0]=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                sum[i+1][j+1] = sum[i][j+1]+sum[i+1][j]+matrix[i][j]-sum[i][j];
            }
        }
        for(int l=0;l<m;l++){
            for (int h=l+1;h<=m;h++){
                Map<Integer,Integer> map = new HashMap<Integer, Integer>();
                for(int j=0;j<=n;j++){
                    int diff =sum[h][j]-sum[l][j];
                    if(map.containsKey(diff)){
                        int k = map.get(diff);
                        result[0][0]=l;
                        result[0][1]=k;
                        result[1][0]=h-1;
                        result[1][1]=j-1;
                        return result;
                    }else {
                        map.put(diff,j);
                    }
                }
            }
        }

        return result;
    }
}
