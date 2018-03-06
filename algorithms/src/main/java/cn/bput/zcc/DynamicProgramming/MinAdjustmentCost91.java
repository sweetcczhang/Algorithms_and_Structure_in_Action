package cn.bput.zcc.DynamicProgramming;

import java.util.List;

/**
 * Created by 张城城 on 2018/3/6.
 */
public class MinAdjustmentCost91 {
    /**
     * 使用动态规划求解
     * 一个元素一个元素的调整，由于是和相邻元素的差值，所以只和前一个相邻元素有关。
     * 所以只需要记录前一个值就可以了。
     * dp[i][j]表示第i个元素取值为j时的最小代价和。显然dp[i-1][k]的值为已知的。
     * dp[i][j] = dp[i-1][k]+Math.abs(j-A.get(i)).由于j和k都有多种可能，所以需要循环判断。
     * @param A
     * @param target
     * @return
     */
    public int minAdjustmentCost(List<Integer> A, int target){
        if(A==null || A.size()<2) return 0;
        int[][] dp = new int[A.size()][101];
        for (int i=0;i<101;i++){
            dp[0][i] = Math.abs(i-A.get(0));
        }
        for(int i=1;i<A.size();i++){
            for (int j=0;j<101;j++){
                dp[i][j] = Integer.MAX_VALUE;
                int left = Math.max(j-target,0);
                int right = Math.min(j+target,100);
                int diff = Math.abs(j-A.get(i));
                for (int k= left;k<=right;k++){
                    dp[i][j] = Math.min(dp[i][j],dp[i-1][k]+diff);
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for(int i=0;i<101;i++){
            if(dp[A.size()-1][i]<result){
                result = dp[A.size()-1][i];
            }
        }
        return result;
    }
}
