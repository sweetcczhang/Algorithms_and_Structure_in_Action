package cn.bput.zcc.DynamicProgramming;

/**
 * Created by 张城城 on 2018/3/6.
 */
public class BackPack92 {
    public int backPack(int m, int[] A){
        int[][] dp = new int[A.length+1][m+1];
        for (int i=1;i<=A.length;i++){
            for(int j=m;j>=0;j--){
                if(j>=A[i-1]){
                    dp[i][j] = dp[i-1][j-A[i-1]]+A[i-1];
                }
                dp[i][j] = Math.max(dp[i][j],dp[i-1][j]);
            }
        }

        return dp[A.length][m];
    }

}
