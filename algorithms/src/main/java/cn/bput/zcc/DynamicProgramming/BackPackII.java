package cn.bput.zcc.DynamicProgramming;

/**
 * Created by 张城城 on 2017/12/2.
 */
public class BackPackII {

    /**
     *动态规划，和上一题很类似的状态转移方程：
     * f[i][j]表示前i个商品在j的空间时候能够获
     * 得最大的价值状态转移方程：不放第i个商品
     * f[i][j] = f[i-1][j]放第i个商品f[i][j] = f[i-1][j-A[i]]+V[i]
     * @param m
     * @param A
     * @param V
     * @return
     */
    public int backPackII(int m, int[] A, int[] V) {
        // write your code here
        int[][] value = new int[A.length+1][m+1];
        for(int i=1;i<=A.length;i++){
            for(int j=m;j>=0;j--){
                if(j>=A[i-1]){
                    value[i][j] = value[i-1][j-A[i-1]]+V[i-1];
                }
                value[i][j] = Math.max(value[i][j],value[i-1][j]);
            }
        }
        return value[A.length][m];
    }

    public int backPack(int m, int[] A, int[] V) {
        int[] P = new int[m+1];
        for (int i=1;i<A.length; ){
            for(int j=m;j>=0;j--){
                if(j>=A[i-1]){
                    P[j] = Math.max(P[j-1],P[j-A[i-1]]+V[i]);
                }
            }
        }

        return P[m];
    }

}
